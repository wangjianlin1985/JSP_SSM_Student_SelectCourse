// 
// 
// 

package net.fuzui.StudentInfo.service;

import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import net.fuzui.StudentInfo.pojo.SC;
import java.util.List;

public interface SelectCourseService
{
    int selectCourse(String p0, String p1);
    
    String existCourse(String p0, String p1);
    
    List<SC> getAllSC(int p0, int p1, String p2);
    
    List<SC> getSCByCid(int p0, int p1, String p2);
    
    List<StuSelectResult> getSCBySid(int p0, int p1, String p2);
    
    List<StuExitSelect> getExitBysid(int p0, int p1, String p2);
    
    int deleteSC(String p0, String p1);
    
    List<StuExitSelect> getLookByTid(int p0, int p1, String p2);
    
    List<Student> getByStuSid(int p0, int p1, String p2);
}
