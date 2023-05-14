// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.CourseGrade;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.CoursePlanMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.CoursePlanService;

@Service
public class CoursePlanServiceImpl implements CoursePlanService
{
    @Autowired
    private CoursePlanMapper coursePlanMapper;
    
    public int insertCoursePlan(final CoursePlan coursePlan) {
        return this.coursePlanMapper.insertCoursePlan(coursePlan);
    }
    
    public int deleteCoursePlan(final String courseclass) {
        return this.coursePlanMapper.deleteCoursePlan(courseclass);
    }
    
    public int modifyCoursePlan(final CoursePlan coursePlan) {
        return this.coursePlanMapper.modifyCoursePlan(coursePlan);
    }
    
    public List<CoursePlan> getByCoursePlanCourseclass(final int pageNo, final int pageSize, final String courseclass) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("courseclass", courseclass);
        return this.coursePlanMapper.getByCoursePlanCourseclass(data);
    }
    
    public List<CoursePlan> getByCoursePlanTid(final int pageNo, final int pageSize, final String tid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("tid", tid);
        return this.coursePlanMapper.getByCoursePlanTid(data);
    }
    
    public List<CoursePlan> getCidByCoursePlanTid(final int pageNo, final int pageSize, final String tid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("tid", tid);
        return this.coursePlanMapper.getCidByCoursePlanTid(data);
    }
    
    public List<CoursePlan> getTidByCoursePlanCid(final int pageNo, final int pageSize, final String cid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cid", cid);
        return this.coursePlanMapper.getTidByCoursePlanCid(data);
    }
    
    public String ajaxGetCoursePlan(final String coursetime, final String courseweek, final String classroom) {
        return this.coursePlanMapper.ajaxGetCoursePlan(coursetime, courseweek, classroom);
    }
    
    public String existsCoursePlan(final String cid) {
        return this.coursePlanMapper.existsCoursePlan(cid);
    }
    
    public Integer getCreditsByCid(final String cid) {
        return this.coursePlanMapper.getCreditsByCid(cid);
    }
    
    public List<CourseGrade> getCourseGrade(final int pageNo, final int pageSize, final String cid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cid", cid);
        return this.coursePlanMapper.getCourseGrade(data);
    }
}
