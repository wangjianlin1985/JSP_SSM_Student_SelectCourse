// 
// 
// 

package net.fuzui.StudentInfo.handler;

import java.sql.CallableStatement;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.sql.PreparedStatement;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;

@MappedTypes({ List.class })
@MappedJdbcTypes({ JdbcType.VARCHAR })
public class MyListTypeHandler extends BaseTypeHandler<List<String>>
{
    public void setNonNullParameter(final PreparedStatement preparedStatement, final int i, final List<String> strings, final JdbcType jdbcType) throws SQLException {
        final StringBuffer sb = new StringBuffer();
        for (final String string : strings) {
            sb.append(string).append(",");
        }
        preparedStatement.setString(i, sb.toString().substring(0, sb.toString().length() - 1));
    }
    
    public List<String> getNullableResult(final ResultSet resultSet, final String s) throws SQLException {
        final String[] split = resultSet.getString(s).split(",");
        return Arrays.asList(split);
    }
    
    public List<String> getNullableResult(final ResultSet resultSet, final int i) throws SQLException {
        final String[] split = resultSet.getString(i).split(",");
        return Arrays.asList(split);
    }
    
    public List<String> getNullableResult(final CallableStatement callableStatement, final int i) throws SQLException {
        final String[] split = callableStatement.getString(i).split(",");
        return Arrays.asList(split);
    }
}
