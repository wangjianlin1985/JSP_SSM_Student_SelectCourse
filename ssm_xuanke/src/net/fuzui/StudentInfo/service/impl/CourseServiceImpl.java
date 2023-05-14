// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import net.fuzui.StudentInfo.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.CourseMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseMapper courseMapper;
    
    public int insertCourse(final Course course) {
        return this.courseMapper.insertCourse(course);
    }
    
    public int deleteCourse(final String cid) {
        return this.courseMapper.deleteCourse(cid);
    }
    
    public int modifyCourse(final Course course) {
        return this.courseMapper.modifyCourse(course);
    }
    
    public Course getByCouCid(final String cid) {
        return this.courseMapper.getByCouCid(cid);
    }
    
    public List<Course> selectCourseBySql(final int pageNo, final int pageSize) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        return this.courseMapper.selectCourseBySql(data);
    }
    
    public List<Course> getByCourseCid(final int pageNo, final int pageSize, final String cid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cid", cid);
        return this.courseMapper.getByCourseCid(data);
    }
    
    public List<Course> getByCourseCname(final int pageNo, final int pageSize, final String cname) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cname", cname);
        return this.courseMapper.getByCourseCname(data);
    }
    
    public List<Course> getByCourseCol(final int pageNo, final int pageSize, final String belongcoll) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("belongcoll", belongcoll);
        return this.courseMapper.getByCourseCol(data);
    }
    
    public List<Course> getByCourseType(final int pageNo, final int pageSize, final String type) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("type", type);
        return this.courseMapper.getByCourseType(data);
    }
    
    public String ajaxQueryByCid(final String cid) {
        return this.courseMapper.ajaxQueryByCid(cid);
    }
}
