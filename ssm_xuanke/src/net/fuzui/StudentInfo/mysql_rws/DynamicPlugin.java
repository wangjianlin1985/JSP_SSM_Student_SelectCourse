// 
// 
// 

package net.fuzui.StudentInfo.mysql_rws;

import java.util.Properties;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.mapping.SqlCommandType;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.apache.ibatis.plugin.Invocation;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Interceptor;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }), @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class DynamicPlugin implements Interceptor
{
    private Logger log;
    private static final Map<String, DynamicDataSourceGlobal> cacheMap;
    
    static {
        cacheMap = new ConcurrentHashMap<String, DynamicDataSourceGlobal>();
    }
    
    public DynamicPlugin() {
        this.log = LoggerFactory.getLogger((Class)DynamicPlugin.class);
    }
    
    public Object intercept(final Invocation invocation) throws Throwable {
        final boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if (!synchronizationActive) {
            final Object[] object = invocation.getArgs();
            final MappedStatement ms = (MappedStatement)object[0];
            DynamicDataSourceGlobal dynamicDataSourceGlobal = null;
            if ((dynamicDataSourceGlobal = DynamicPlugin.cacheMap.get(ms.getId())) == null) {
                if (ms.getSqlCommandType().equals((Object)SqlCommandType.SELECT)) {
                    if (ms.getId().contains("!selectKey")) {
                        dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                    }
                    else {
                        dynamicDataSourceGlobal = DynamicDataSourceGlobal.READ;
                    }
                }
                else {
                    dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
                }
                System.out.println("\u8bbe\u7f6e\u65b9\u6cd5[{" + ms.getId() + "}] use [{" + dynamicDataSourceGlobal.name() + "}] Strategy, SqlCommandType [{" + ms.getSqlCommandType().name() + "}]..");
                this.log.warn("\u8bbe\u7f6e\u65b9\u6cd5[{}] use [{}] Strategy, SqlCommandType [{}]..", new Object[] { ms.getId(), dynamicDataSourceGlobal.name(), ms.getSqlCommandType().name() });
                DynamicPlugin.cacheMap.put(ms.getId(), dynamicDataSourceGlobal);
            }
            DynamicDataSourceHolder.putDataSource(dynamicDataSourceGlobal);
        }
        return invocation.proceed();
    }
    
    public Object plugin(final Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, (Interceptor)this);
        }
        return target;
    }
    
    public void setProperties(final Properties properties) {
    }
}
