// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import net.fuzui.StudentInfo.pojo.Student;

public interface StudentMapper
{
    int insertStudent(Student p0);
    
    int deleteStudent(String p0);
    
    int modifyStudent(Student p0);
    
    int modifyStudentPwd(@Param("spassword") String p0, @Param("sid") String p1);
    
    Student getByStuSid(String p0);
    
    String queryByNamePwd(@Param("sid") String p0, @Param("spassword") String p1);
    
    List<Student> selectStudentBySql(Map<String, Object> p0);
    
    List<Student> getByStudentSid(Map<String, Object> p0);
    
    List<Student> getByStudentCol(Map<String, Object> p0);
    
    List<Student> getByStudentPro(Map<String, Object> p0);
    
    List<Student> getByStudentCla(Map<String, Object> p0);
    
    String ajaxQueryBySid(String p0);
}
