// 
// 
// 

package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.pojo.Student;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import net.fuzui.StudentInfo.service.TeacherService;
import net.fuzui.StudentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/LoginHandler" })
public class LoginHandler
{
    @Autowired
    AdminService adminServiceImpl;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    
    @RequestMapping({ "/adminlogin" })
    public String loginStudent(@RequestParam("aname") final String aname, @RequestParam("apassword") final String apassword, final Model model, final HttpSession httpSession) {
        String n = null;
        n = this.adminServiceImpl.queryByNamePwd(aname, apassword);
        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("aname", (Object)aname);
            return "admin/adminFace";
        }
        return "login";
    }
    
    @RequestMapping({ "/adminlogout" })
    public ModelAndView adminLogout(final HttpSession httpSession) {
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("couList");
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/index.jsp"));
    }
    
    @RequestMapping({ "/studentlogin" })
    public ModelAndView loginStudent(@RequestParam("sid") final String sid, @RequestParam("spassword") final String spassword, final Model model, final HttpSession httpSession, final HttpServletRequest httpRequest) {
        Student student = new Student();
        student = this.studentService.getByStuSid(sid);
        if (this.studentService.queryByNamePwd(sid, spassword) != null) {
            httpSession.setAttribute("sid", (Object)sid);
            httpSession.setAttribute("sname", (Object)student.getSname());
            return new ModelAndView((View)new RedirectView("../student/studentFace.jsp"));
        }
        httpRequest.setAttribute("msg", (Object)"\u8d26\u53f7\u6216\u5bc6\u7801\u4e0d\u6b63\u786e\uff0c\u767b\u5f55\u5931\u8d25!");
        return new ModelAndView((View)new RedirectView("../fail.jsp"));
    }
    
    @RequestMapping({ "/studentlogout" })
    public ModelAndView studentLogout(final HttpSession httpSession) {
        httpSession.removeAttribute("sid");
        httpSession.removeAttribute("sname");
        httpSession.removeAttribute("courseList");
        httpSession.removeAttribute("ssrList");
        httpSession.removeAttribute("sesList");
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/index.jsp"));
    }
    
    @RequestMapping({ "/teacherlogin" })
    public ModelAndView loginTeacher(@RequestParam("tid") final String tid, @RequestParam("tpassword") final String tpassword, final Model model, final HttpSession httpSession) {
        if (this.teacherService.queryByNamePwd(tid, tpassword) != null) {
            Teacher teacher = new Teacher();
            teacher = this.teacherService.getByTeaTid(tid);
            httpSession.setAttribute("tid", (Object)tid);
            httpSession.setAttribute("tname", (Object)teacher.getTname());
            return new ModelAndView((View)new RedirectView("../teacher/teacherFace.jsp"));
        }
        return new ModelAndView((View)new RedirectView("../fail.jsp"));
    }
    
    @RequestMapping({ "/teacherlogout" })
    public ModelAndView teacherLogout(final HttpSession httpSession) {
        httpSession.removeAttribute("tid");
        httpSession.removeAttribute("tname");
        httpSession.removeAttribute("couList");
        httpSession.removeAttribute("sesList");
        httpSession.removeAttribute("lookList");
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/index.jsp"));
    }
}
