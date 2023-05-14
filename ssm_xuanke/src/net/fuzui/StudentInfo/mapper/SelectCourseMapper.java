// 
// 
// 

package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import net.fuzui.StudentInfo.pojo.SC;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface SelectCourseMapper
{
    int selectCourse(@Param("cid") String p0, @Param("sid") String p1);
    
    String existCourse(@Param("cid") String p0, @Param("sid") String p1);
    
    List<SC> getAllSC(Map<String, Object> p0);
    
    List<SC> getSCByCid(Map<String, Object> p0);
    
    List<StuSelectResult> getSCBySid(Map<String, Object> p0);
    
    List<StuExitSelect> getExitBysid(Map<String, Object> p0);
    
    int deleteSC(@Param("cid") String p0, @Param("sid") String p1);
    
    List<StuExitSelect> getLookByTid(Map<String, Object> p0);
    
    List<Student> getByStuSid(Map<String, Object> p0);
}
