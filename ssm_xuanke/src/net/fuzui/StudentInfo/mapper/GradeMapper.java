// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import java.util.List;
import java.util.Map;
import net.fuzui.StudentInfo.pojo.Grade;

public interface GradeMapper
{
    int insertGrade(Grade p0);
    
    String queryCreditsSum(String p0);
    
    List<Grade> getEedCourseBySid(Map<String, Object> p0);
}
