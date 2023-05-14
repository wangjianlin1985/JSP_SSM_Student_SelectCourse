// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import java.util.Map;
import java.util.HashMap;
import net.fuzui.StudentInfo.pojo.SC;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.SelectCourseMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.SelectCourseService;

@Service
public class SelectCourseServiceImpl implements SelectCourseService
{
    @Autowired
    private SelectCourseMapper selectCourseMapper;
    
    public int selectCourse(final String cid, final String sid) {
        return this.selectCourseMapper.selectCourse(cid, sid);
    }
    
    public String existCourse(final String cid, final String sid) {
        return this.selectCourseMapper.existCourse(cid, sid);
    }
    
    public List<SC> getAllSC(final int pageNo, final int pageSize, final String sid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("sid", sid);
        return this.selectCourseMapper.getAllSC(data);
    }
    
    public List<SC> getSCByCid(final int pageNo, final int pageSize, final String cid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cid", cid);
        return this.selectCourseMapper.getSCByCid(data);
    }
    
    public List<StuSelectResult> getSCBySid(final int pageNo, final int pageSize, final String sid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("sid", sid);
        return this.selectCourseMapper.getSCBySid(data);
    }
    
    public List<StuExitSelect> getExitBysid(final int pageNo, final int pageSize, final String sid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("sid", sid);
        return this.selectCourseMapper.getExitBysid(data);
    }
    
    public int deleteSC(final String cid, final String sid) {
        return this.selectCourseMapper.deleteSC(cid, sid);
    }
    
    public List<StuExitSelect> getLookByTid(final int pageNo, final int pageSize, final String tid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("tid", tid);
        return this.selectCourseMapper.getLookByTid(data);
    }
    
    public List<Student> getByStuSid(final int pageNo, final int pageSize, final String cid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("cid", cid);
        return this.selectCourseMapper.getByStuSid(data);
    }
}
