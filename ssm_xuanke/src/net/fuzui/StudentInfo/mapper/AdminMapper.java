// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper
{
    String queryByNamePwd(@Param("aname") String p0, @Param("apassword") String p1);
}
