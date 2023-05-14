// 
// 
// 

package net.fuzui.StudentInfo.service;

import java.util.List;
import net.fuzui.StudentInfo.pojo.Teacher;

public interface TeacherService
{
    int insertTeacher(Teacher p0);
    
    int deleteTeacher(String p0);
    
    int modifyTeacher(Teacher p0);
    
    int modifyTeacherPwd(String p0, String p1);
    
    Teacher getByTeaTid(String p0);
    
    String queryByNamePwd(String p0, String p1);
    
    List<Teacher> selectTeacherBySql(int p0, int p1);
    
    List<Teacher> getByTeacherTid(int p0, int p1, String p2);
    
    String ajaxQueryByTid(String p0);
}
