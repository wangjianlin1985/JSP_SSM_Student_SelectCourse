// 
// 
// 

package net.fuzui.StudentInfo.handler;

import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.TeacherService;
import net.fuzui.StudentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/AjaxHandler" })
public class AjaxHandler
{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CoursePlanService coursePlanService;
    
    @RequestMapping(value = { "/existCid" }, method = { RequestMethod.POST })
    public void existCid(@RequestParam("cid") final String cid, final HttpServletResponse response, final HttpServletRequest request) throws IOException {
        System.out.println("\u8bfe\u7a0b\u7f16\u53f7=" + cid);
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        System.out.println(String.valueOf(cid) + "----------");
        PrintWriter out = null;
        out = response.getWriter();
        if (this.courseService.getByCouCid(cid) != null && cid != null && !"".equals(cid)) {
            out.println("\u8bfe\u7a0b\u7f16\u53f7\u5df2\u5b58\u5728");
        }
        else if (cid != null && !"".equals(cid)) {
            out.println("\u6b64\u8bfe\u7a0b\u7f16\u53f7\u53ef\u4ee5\u4f7f\u7528");
        }
        else {
            out.println("\u8bfe\u7a0b\u7f16\u53f7\u4e0d\u80fd\u4e3a\u7a7a");
        }
        out.flush();
        out.close();
    }
    
    @RequestMapping(value = { "/existSid" }, method = { RequestMethod.POST })
    public void existSid(@RequestParam("sid") final String sid, final HttpServletResponse response, final HttpServletRequest request) throws IOException {
        System.out.println("\u5b66\u53f7=" + sid);
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = null;
        out = response.getWriter();
        if (this.studentService.getByStuSid(sid) != null && sid.length() == 12) {
            out.println("\u5b66\u53f7\u5df2\u5b58\u5728");
        }
        else if (sid.length() == 12) {
            out.println("\u5b66\u53f7\u53ef\u4ee5\u4f7f\u7528");
        }
        else {
            out.println("\u5b66\u53f7\u5fc5\u987b\u662f12\u4f4d");
        }
        out.flush();
        out.close();
    }
    
    @RequestMapping(value = { "/existTid" }, method = { RequestMethod.POST })
    public void existTid(@RequestParam("tid") final String tid, final HttpServletResponse response, final HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = null;
        out = response.getWriter();
        if (this.teacherService.getByTeaTid(tid) != null && tid.length() <= 5) {
            out.println("\u6559\u5e08\u7f16\u53f7\u5df2\u5b58\u5728");
        }
        else if (tid.length() <= 12) {
            out.println("\u6559\u5e08\u7f16\u53f7\u53ef\u4ee5\u4f7f\u7528");
        }
        else {
            out.println("\u6559\u5e08\u7f16\u53f7\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e5\u4f4d");
        }
        out.flush();
        out.close();
    }
    
    @RequestMapping(value = { "/existTime" }, method = { RequestMethod.POST })
    public void existTime(@RequestParam("coursetime") final String coursetime, @RequestParam("courseweek") final String courseweek, @RequestParam("classroom") final String classroom, final HttpServletResponse response, final HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = null;
        System.out.println("--------------------------");
        System.out.println(String.valueOf(coursetime) + "---" + courseweek + "---" + classroom);
        out = response.getWriter();
        if (this.coursePlanService.ajaxGetCoursePlan(coursetime, courseweek, classroom) != null) {
            out.println("\u6b64\u529f\u80fd\u6392\u91cd\u6b63\u5728\u5f00\u53d1\u4e2d.....");
        }
        else {
            out.println("\u6b64\u529f\u80fd\u6392\u91cd\u6b63\u5728\u5f00\u53d1\u4e2d.....");
        }
        out.flush();
        out.close();
    }
}
