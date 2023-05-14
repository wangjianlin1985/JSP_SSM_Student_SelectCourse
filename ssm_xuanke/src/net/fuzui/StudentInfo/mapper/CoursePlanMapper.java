// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.CourseGrade;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
import net.fuzui.StudentInfo.pojo.CoursePlan;

public interface CoursePlanMapper
{
    int insertCoursePlan(CoursePlan p0);
    
    int deleteCoursePlan(String p0);
    
    int modifyCoursePlan(CoursePlan p0);
    
    List<CoursePlan> getByCoursePlanCourseclass(Map<String, Object> p0);
    
    List<CoursePlan> getByCoursePlanTid(Map<String, Object> p0);
    
    List<CoursePlan> getCidByCoursePlanTid(Map<String, Object> p0);
    
    List<CoursePlan> getTidByCoursePlanCid(Map<String, Object> p0);
    
    String ajaxGetCoursePlan(@Param("coursetime") String p0, @Param("courseweek") String p1, @Param("classroom") String p2);
    
    String existsCoursePlan(String p0);
    
    Integer getCreditsByCid(String p0);
    
    List<CourseGrade> getCourseGrade(Map<String, Object> p0);
}
