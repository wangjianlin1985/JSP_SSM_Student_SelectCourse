// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import net.fuzui.StudentInfo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import net.fuzui.StudentInfo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService, Serializable
{
    @Autowired
    private StudentMapper studentMapper;
    
    public int insertStudent(final Student student) {
        return this.studentMapper.insertStudent(student);
    }
    
    public int deleteStudent(final String sid) {
        return this.studentMapper.deleteStudent(sid);
    }
    
    public int modifyStudent(final Student student) {
        return this.studentMapper.modifyStudent(student);
    }
    
    public int modifyStudentPwd(final String spassword, final String sid) {
        return this.studentMapper.modifyStudentPwd(spassword, sid);
    }
    
    public Student getByStuSid(final String sid) {
        return this.studentMapper.getByStuSid(sid);
    }
    
    public String queryByNamePwd(final String sid, final String pwd) {
        return this.studentMapper.queryByNamePwd(sid, pwd);
    }
    
    public List<Student> selectStudentBySql(final int pageNo, final int pageSize) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        return this.studentMapper.selectStudentBySql(data);
    }
    
    public List<Student> getByStudentSid(final int pageNo, final int pageSize, final String sid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("sid", sid);
        return this.studentMapper.getByStudentSid(data);
    }
    
    public List<Student> getByStudentCol(final int pageNo, final int pageSize, final String college) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("college", college);
        return this.studentMapper.getByStudentCol(data);
    }
    
    public List<Student> getByStudentPro(final int pageNo, final int pageSize, final String profession) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("profession", profession);
        return this.studentMapper.getByStudentPro(data);
    }
    
    public List<Student> getByStudentCla(final int pageNo, final int pageSize, final String classr) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("classr", classr);
        return this.studentMapper.getByStudentCla(data);
    }
    
    public String ajaxQueryBySid(final String sid) {
        return this.studentMapper.ajaxQueryBySid(sid);
    }
}
