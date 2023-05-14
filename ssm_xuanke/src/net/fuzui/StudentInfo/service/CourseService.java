// 
// 
// 

package net.fuzui.StudentInfo.service;

import java.util.List;
import net.fuzui.StudentInfo.pojo.Course;

public interface CourseService
{
    int insertCourse(Course p0);
    
    int deleteCourse(String p0);
    
    int modifyCourse(Course p0);
    
    Course getByCouCid(String p0);
    
    List<Course> selectCourseBySql(int p0, int p1);
    
    List<Course> getByCourseCid(int p0, int p1, String p2);
    
    List<Course> getByCourseCname(int p0, int p1, String p2);
    
    List<Course> getByCourseCol(int p0, int p1, String p2);
    
    List<Course> getByCourseType(int p0, int p1, String p2);
    
    String ajaxQueryByCid(String p0);
}
