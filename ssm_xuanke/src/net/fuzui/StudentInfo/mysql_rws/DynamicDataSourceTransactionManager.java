// 
// 
// 

package net.fuzui.StudentInfo.mysql_rws;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager
{
    private static final long serialVersionUID = 1L;
    
    protected void doBegin(final Object transaction, final TransactionDefinition definition) {
        final boolean readOnly = definition.isReadOnly();
        if (readOnly) {
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.READ);
        }
        else {
            DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.WRITE);
        }
        super.doBegin(transaction, definition);
    }
    
    protected void doCleanupAfterCompletion(final Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DynamicDataSourceHolder.clearDataSource();
    }
}
