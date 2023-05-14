// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import net.fuzui.StudentInfo.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.TeacherMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherMapper teacherMapper;
    
    public int insertTeacher(final Teacher teacher) {
        return this.teacherMapper.insertTeacher(teacher);
    }
    
    public int deleteTeacher(final String tid) {
        return this.teacherMapper.deleteTeacher(tid);
    }
    
    public int modifyTeacher(final Teacher teacher) {
        return this.teacherMapper.modifyTeacher(teacher);
    }
    
    public int modifyTeacherPwd(final String tpassword, final String tid) {
        return this.teacherMapper.modifyTeacherPwd(tpassword, tid);
    }
    
    public Teacher getByTeaTid(final String tid) {
        return this.teacherMapper.getByTeaTid(tid);
    }
    
    public String queryByNamePwd(final String tid, final String pwd) {
        return this.teacherMapper.queryByNamePwd(tid, pwd);
    }
    
    public List<Teacher> selectTeacherBySql(final int pageNo, final int pageSize) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        return this.teacherMapper.selectTeacherBySql(data);
    }
    
    public List<Teacher> getByTeacherTid(final int pageNo, final int pageSize, final String tid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("tid", tid);
        return this.teacherMapper.getByTeacherTid(data);
    }
    
    public String ajaxQueryByTid(final String tid) {
        return this.teacherMapper.ajaxQueryByTid(tid);
    }
}
