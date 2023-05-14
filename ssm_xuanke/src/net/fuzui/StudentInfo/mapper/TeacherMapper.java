// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import net.fuzui.StudentInfo.pojo.Teacher;

public interface TeacherMapper
{
    int insertTeacher(Teacher p0);
    
    int deleteTeacher(String p0);
    
    int modifyTeacher(Teacher p0);
    
    int modifyTeacherPwd(@Param("tpassword") String p0, @Param("tid") String p1);
    
    Teacher getByTeaTid(String p0);
    
    String queryByNamePwd(@Param("tid") String p0, @Param("tpassword") String p1);
    
    List<Teacher> selectTeacherBySql(Map<String, Object> p0);
    
    List<Teacher> getByTeacherTid(Map<String, Object> p0);
    
    String ajaxQueryByTid(String p0);
}
