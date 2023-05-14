// 
// 
// 

package net.fuzui.StudentInfo.mysql_rws;

import java.util.Map;
import java.util.HashMap;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{
    private Object writeDataSource;
    private Object readDataSource;
    
    public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("Property writeDataSource is required");
        }
        this.setDefaultTargetDataSource(this.writeDataSource);
        final Map<Object, Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put(DynamicDataSourceGlobal.WRITE.name(), this.writeDataSource);
        if (this.readDataSource != null) {
            targetDataSource.put(DynamicDataSourceGlobal.READ.name(), this.readDataSource);
        }
        this.setTargetDataSources((Map)targetDataSource);
        super.afterPropertiesSet();
    }
    
    protected Object determineCurrentLookupKey() {
        final DynamicDataSourceGlobal dataSourceGlobal = DynamicDataSourceHolder.getDataSource();
        if (dataSourceGlobal == null || dataSourceGlobal == DynamicDataSourceGlobal.WRITE) {
            return DynamicDataSourceGlobal.WRITE.name();
        }
        return DynamicDataSourceGlobal.READ.name();
    }
    
    public Object getWriteDataSource() {
        return this.writeDataSource;
    }
    
    public void setWriteDataSource(final Object writeDataSource) {
        this.writeDataSource = writeDataSource;
    }
    
    public Object getReadDataSource() {
        return this.readDataSource;
    }
    
    public void setReadDataSource(final Object readDataSource) {
        this.readDataSource = readDataSource;
    }
}
