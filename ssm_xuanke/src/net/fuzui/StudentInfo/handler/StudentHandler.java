// 
// 
// 

package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import javax.servlet.http.HttpSession;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import net.fuzui.StudentInfo.pojo.Teacher;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageHelper;
import net.fuzui.StudentInfo.pojo.Course;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Grade;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import net.fuzui.StudentInfo.service.GradeService;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/StudentHandler" })
public class StudentHandler
{
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CoursePlanService coursePlanService;
    @Autowired
    CourseService courseService;
    @Autowired
    SelectCourseService selectCourseService;
    @Autowired
    GradeService gradeService;
    
    @RequestMapping({ "/queryvitastu/{sid}" })
    public String queryVita(@PathVariable("sid") final String sid, final Model model) {
        final Grade grade = new Grade();
        final String credits = this.gradeService.queryCreditsSum(sid);
        Student student = new Student();
        student = this.studentService.getByStuSid(sid);
        model.addAttribute("sid", (Object)student.getSid());
        model.addAttribute("sname", (Object)student.getSname());
        model.addAttribute("sidcard", (Object)student.getSidcard());
        model.addAttribute("ssex", (Object)student.getSsex());
        model.addAttribute("spassword", (Object)student.getSpassword());
        model.addAttribute("sage", (Object)student.getSage());
        model.addAttribute("classr", (Object)student.getClassr());
        model.addAttribute("profession", (Object)student.getProfession());
        model.addAttribute("college", (Object)student.getCollege());
        model.addAttribute("credits", (Object)credits);
        System.out.println(student);
        System.out.println(student.getSpassword());
        return "student/queryVitaStu";
    }
    
    @RequestMapping({ "/moditypwstu/{sid}" })
    public ModelAndView teacherModi(@PathVariable("sid") final String sid, final Model model) {
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/student/modityPwStu.jsp"));
    }
    
    @RequestMapping({ "/moditypasswordstu/{sid}" })
    public ModelAndView teacherModiPw(@PathVariable("sid") final String tid, @RequestParam("spassword") final String spassword, final Model model) {
        if (this.studentService.modifyStudentPwd(spassword, tid) != 0) {
            return new ModelAndView((View)new RedirectView("../queryvitastu/{sid}"));
        }
        return new ModelAndView((View)new RedirectView("../fail.jsp"));
    }
    
    public void pageIn(final Model model, final List list) {
        final PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", (Object)page);
    }
    
    @RequestMapping(value = { "/queryy/{pn}" }, method = { RequestMethod.GET })
    public String redirect(@RequestParam("serc") final String serc, @RequestParam("condition") final String condition, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        request.setAttribute("serc", (Object)serc);
        request.setAttribute("condition", (Object)condition);
        if (serc.equals("all")) {
            courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            return "student/selCourse";
        }
        if (serc.equals("sid")) {
            courseList = (List<Course>)this.courseService.getByCourseCid(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println("sid");
            return "student/selCourse";
        }
        if (serc.equals("nam")) {
            courseList = (List<Course>)this.courseService.getByCourseCname(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("cla");
            return "student/selCourse";
        }
        if (serc.equals("col")) {
            courseList = (List<Course>)this.courseService.getByCourseCol(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("col");
            return "student/selCourse";
        }
        if (serc.equals("type")) {
            courseList = (List<Course>)this.courseService.getByCourseType(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("pro");
            return "student/selCourse";
        }
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        request.setAttribute("courseList", (Object)courseList);
        System.out.println(courseList);
        return "student/selCourse";
    }
    
    @RequestMapping(value = { "/selcou/{cid}" }, method = { RequestMethod.GET })
    public String selCou(@PathVariable("cid") final String cid, final Model model) {
        List<CoursePlan> lists = null;
        lists = (List<CoursePlan>)this.coursePlanService.getTidByCoursePlanCid(1, 10, cid);
        System.out.println("------" + lists.size());
        Teacher teacher = new Teacher();
        Course course = new Course();
        if (lists.size() != 0) {
            System.out.println("-----\u8fdb\u5165\u9009\u8bfe");
            final String tid = lists.get(0).getTid();
            teacher = this.teacherService.getByTeaTid(tid);
            model.addAttribute("tname", (Object)teacher.getTname());
            model.addAttribute("inroduction", (Object)teacher.getIntroduction());
            System.out.println(String.valueOf(teacher.getIntroduction()) + "-----------------------");
            course = this.courseService.getByCouCid(cid);
            model.addAttribute("cname", (Object)course.getCname());
            model.addAttribute("cid", (Object)cid);
            return "student/seling";
        }
        System.out.println("-----\u8fdb\u5165\u65e0\u6559\u5e08\u9009\u8bfe");
        course = this.courseService.getByCouCid(cid);
        model.addAttribute("cname", (Object)course.getCname());
        model.addAttribute("cid", (Object)cid);
        return "student/noseling";
    }
    
    @RequestMapping({ "/seling" })
    public String confirmSelect(@RequestParam("cid") final String cid, @RequestParam("sid") final String sid, final Model model, final HttpSession httpSession, final HttpServletRequest httpRequest) {
        if (this.selectCourseService.existCourse(cid, sid) != null) {
            httpRequest.setAttribute("msg", (Object)"\u5df2\u7ecf\u52a0\u5165\u8fc7\u8be5\u8bfe\u7a0b\uff0c\u4e0d\u80fd\u91cd\u590d\u52a0\u5165!");
            System.out.println("\u5df2\u7ecf\u52a0\u5165\u8fc7\u8be5\u8bfe\u7a0b\uff0c\u4e0d\u80fd\u91cd\u590d\u52a0\u5165!");
            return "fail";
        }
        if (this.selectCourseService.selectCourse(cid, sid) != 0) {
            System.out.println(cid);
            System.out.println(sid);
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping({ "/backseling/{cid}" })
    public ModelAndView backConfirmSelect(@PathVariable("cid") final String cid) {
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/StudentHandler/selqueryy/1"));
    }
    
    @RequestMapping({ "/selqueryy/{pn}" })
    public String selQueryy(final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        request.setAttribute("courseList", (Object)courseList);
        return "student/selCourse";
    }
    
    @RequestMapping(value = { "/selcouresult/{sid}/{pn}" }, method = { RequestMethod.GET })
    public String selcouresult(@PathVariable("sid") final String sid, final StuSelectResult ssr, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        List<StuSelectResult> ssrList = new ArrayList<StuSelectResult>();
        ssrList = (List<StuSelectResult>)this.selectCourseService.getSCBySid(1, 10, sid);
        this.pageIn(model, ssrList);
        request.setAttribute("ssrList", (Object)ssrList);
        return "student/selectedCourse";
    }
    
    @RequestMapping(value = { "/exitchoose/{sid}/{pn}" }, method = { RequestMethod.GET })
    public String exitChoose(@PathVariable("sid") final String sid, final StuSelectResult ssr, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        List<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
        sesList = (List<StuExitSelect>)this.selectCourseService.getExitBysid(1, 10, sid);
        this.pageIn(model, sesList);
        request.setAttribute("sesList", (Object)sesList);
        return "student/exitSel";
    }
    
    @RequestMapping(value = { "/exitsel/{cid}/{sid}" }, method = { RequestMethod.GET })
    public ModelAndView exitSel(@PathVariable("cid") final String cid, @PathVariable("sid") final String sid) {
        if (this.selectCourseService.deleteSC(cid, sid) != 0) {
            return new ModelAndView((View)new RedirectView("/ssm_xuanke/StudentHandler/exitchoose/{sid}/1"));
        }
        return new ModelAndView((View)new RedirectView("../fail.jsp"));
    }
    
    @RequestMapping(value = { "/endcourse/{sid}/{pn}" }, method = { RequestMethod.GET })
    public String endcourse(@PathVariable("sid") final String sid, final Grade grade, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        List<Grade> endCourseList = new ArrayList<Grade>();
        endCourseList = (List<Grade>)this.gradeService.getEedCourseBySid(1, 10, sid);
        this.pageIn(model, endCourseList);
        request.setAttribute("endCourseList", (Object)endCourseList);
        return "student/endCourse";
    }
}
