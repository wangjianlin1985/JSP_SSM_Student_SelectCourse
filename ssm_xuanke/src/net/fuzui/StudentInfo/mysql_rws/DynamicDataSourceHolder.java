// 
// 
// 

package net.fuzui.StudentInfo.mysql_rws;

public class DynamicDataSourceHolder
{
    private static ThreadLocal<DynamicDataSourceGlobal> holder;
    
    static {
        DynamicDataSourceHolder.holder = new ThreadLocal();
    }
    
    public static void putDataSource(final DynamicDataSourceGlobal dataSource) {
        DynamicDataSourceHolder.holder.set(dataSource);
    }
    
    public static DynamicDataSourceGlobal getDataSource() {
        return DynamicDataSourceHolder.holder.get();
    }
    
    public static void clearDataSource() {
        DynamicDataSourceHolder.holder.remove();
    }
}
