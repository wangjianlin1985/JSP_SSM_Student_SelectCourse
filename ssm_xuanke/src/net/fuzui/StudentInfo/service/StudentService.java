// 
// 
// 

package net.fuzui.StudentInfo.service;

import java.util.List;
import net.fuzui.StudentInfo.pojo.Student;

public interface StudentService
{
    int insertStudent(Student p0);
    
    int deleteStudent(String p0);
    
    int modifyStudent(Student p0);
    
    int modifyStudentPwd(String p0, String p1);
    
    Student getByStuSid(String p0);
    
    String queryByNamePwd(String p0, String p1);
    
    List<Student> selectStudentBySql(int p0, int p1);
    
    List<Student> getByStudentSid(int p0, int p1, String p2);
    
    List<Student> getByStudentCol(int p0, int p1, String p2);
    
    List<Student> getByStudentPro(int p0, int p1, String p2);
    
    List<Student> getByStudentCla(int p0, int p1, String p2);
    
    String ajaxQueryBySid(String p0);
}
