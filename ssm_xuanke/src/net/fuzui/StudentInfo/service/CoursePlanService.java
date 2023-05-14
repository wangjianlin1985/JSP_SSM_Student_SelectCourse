// 
// 
// 

package net.fuzui.StudentInfo.service;

import net.fuzui.StudentInfo.pojo.CourseGrade;
import java.util.List;
import net.fuzui.StudentInfo.pojo.CoursePlan;

public interface CoursePlanService
{
    int insertCoursePlan(CoursePlan p0);
    
    int deleteCoursePlan(String p0);
    
    int modifyCoursePlan(CoursePlan p0);
    
    List<CoursePlan> getByCoursePlanCourseclass(int p0, int p1, String p2);
    
    List<CoursePlan> getByCoursePlanTid(int p0, int p1, String p2);
    
    List<CoursePlan> getCidByCoursePlanTid(int p0, int p1, String p2);
    
    List<CoursePlan> getTidByCoursePlanCid(int p0, int p1, String p2);
    
    String ajaxGetCoursePlan(String p0, String p1, String p2);
    
    String existsCoursePlan(String p0);
    
    Integer getCreditsByCid(String p0);
    
    List<CourseGrade> getCourseGrade(int p0, int p1, String p2);
}
