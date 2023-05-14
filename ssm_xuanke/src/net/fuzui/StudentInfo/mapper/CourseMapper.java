// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import java.util.List;
import java.util.Map;
import net.fuzui.StudentInfo.pojo.Course;

public interface CourseMapper
{
    int insertCourse(Course p0);
    
    int deleteCourse(String p0);
    
    int modifyCourse(Course p0);
    
    Course getByCouCid(String p0);
    
    List<Course> selectCourseBySql(Map<String, Object> p0);
    
    List<Course> getByCourseCid(Map<String, Object> p0);
    
    List<Course> getByCourseCname(Map<String, Object> p0);
    
    List<Course> getByCourseCol(Map<String, Object> p0);
    
    List<Course> getByCourseType(Map<String, Object> p0);
    
    String ajaxQueryByCid(String p0);
}
