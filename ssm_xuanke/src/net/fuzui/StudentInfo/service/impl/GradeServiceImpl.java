// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import net.fuzui.StudentInfo.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.GradeMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService
{
    @Autowired
    private GradeMapper gradeMapper;
    
    public int insertGrade(final Grade grade) {
        return this.gradeMapper.insertGrade(grade);
    }
    
    public String queryCreditsSum(final String sid) {
        return this.gradeMapper.queryCreditsSum(sid);
    }
    
    public List<Grade> getEedCourseBySid(final int pageNo, final int pageSize, final String sid) {
        final Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNo", (pageNo - 1) * pageSize);
        data.put("pageSize", pageSize);
        data.put("sid", sid);
        return this.gradeMapper.getEedCourseBySid(data);
    }
}
