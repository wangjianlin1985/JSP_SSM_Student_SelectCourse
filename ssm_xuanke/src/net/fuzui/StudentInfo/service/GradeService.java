// 
// 
// 

package net.fuzui.StudentInfo.service;

import java.util.List;
import net.fuzui.StudentInfo.pojo.Grade;

public interface GradeService
{
    int insertGrade(Grade p0);
    
    String queryCreditsSum(String p0);
    
    List<Grade> getEedCourseBySid(int p0, int p1, String p2);
}
