// 
// 
// 

package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.Grade;
import net.fuzui.StudentInfo.pojo.CourseGrade;
import net.fuzui.StudentInfo.pojo.Student;
import org.springframework.web.bind.annotation.RequestMethod;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import javax.servlet.http.HttpSession;
import com.github.pagehelper.PageInfo;
import java.util.List;
import net.fuzui.StudentInfo.pojo.Teacher;
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
@RequestMapping({ "/TeacherHandler" })
public class TeacherHandler
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
    
    @RequestMapping({ "/addcou" })
    public String addCou() {
        return "teacher/addCou";
    }
    
    @RequestMapping({ "/sercsc" })
    public String sercSC() {
        return "teacher/serchSC";
    }
    
    @RequestMapping({ "/queryvita/{tid}" })
    public String queryVita(@PathVariable("tid") final String tid, final Model model) {
        Teacher teacher = new Teacher();
        teacher = this.teacherService.getByTeaTid(tid);
        model.addAttribute("tid", (Object)teacher.getTid());
        model.addAttribute("tname", (Object)teacher.getTname());
        model.addAttribute("tpassword", (Object)teacher.getTpassword());
        model.addAttribute("tsex", (Object)teacher.getTsex());
        model.addAttribute("introduction", (Object)teacher.getIntroduction());
        System.out.println(teacher);
        System.out.println(teacher.getTpassword());
        return "teacher/queryVita";
    }
    
    public void pageIn(final Model model, final List list) {
        final PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", (Object)page);
    }
    
    @RequestMapping({ "/managecou/{tid}/{pn}" })
    public String manageCou(@PathVariable("tid") final String tid, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<CoursePlan> coursePlanList = new ArrayList<CoursePlan>();
        List<Course> couList = new ArrayList<Course>();
        coursePlanList = (List<CoursePlan>)this.coursePlanService.getByCoursePlanTid(1, 10, tid);
        this.pageIn(model, coursePlanList);
        final List<CoursePlan> lists = (List<CoursePlan>)this.coursePlanService.getCidByCoursePlanTid(1, 3, tid);
        if (lists.size() != 0) {
            couList = (List<Course>)this.courseService.getByCourseCid(1, 10, lists.get(0).getCid());
            httpSession.setAttribute("coursePlanList", (Object)coursePlanList);
            httpSession.setAttribute("couList", (Object)couList);
            System.out.println(coursePlanList);
            System.out.println(couList);
        }
        return "teacher/manageCourse";
    }
    
    @RequestMapping({ "/moditypw/{tid}" })
    public ModelAndView teacherModi(@PathVariable("tid") final String tid, final Model model, final HttpServletRequest request) {
        System.out.print(request.getRemoteAddr());
        return new ModelAndView((View)new RedirectView("../../teacher/modityPw.jsp"));
    }
    
    @RequestMapping({ "/moditypassword/{tid}" })
    public ModelAndView teacherModiPw(@PathVariable("tid") final String tid, @RequestParam("tpassword") final String tpassword, final Model model) {
        if (this.teacherService.modifyTeacherPwd(tpassword, tid) != 0) {
            return new ModelAndView((View)new RedirectView("../queryvita/{tid}"));
        }
        return new ModelAndView((View)new RedirectView("../fail.jsp"));
    }
    
    @RequestMapping(value = { "/sercsc/{tid}/{pn}" }, method = { RequestMethod.GET })
    public String sercChoose(@PathVariable("tid") final String tid, final StuSelectResult ssr, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
        sesList = (List<StuExitSelect>)this.selectCourseService.getLookByTid(1, 10, tid);
        this.pageIn(model, sesList);
        httpSession.setAttribute("sesList", (Object)sesList);
        return "teacher/serchSC";
    }
    
    @RequestMapping(value = { "/looksel/{cid}/{cname}/{pn}" }, method = { RequestMethod.GET })
    public String lookChoose(@PathVariable("cid") final String cid, @PathVariable("cname") final String cname, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn, final HttpServletRequest request) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Student> lookList = new ArrayList<Student>();
        lookList = (List<Student>)this.selectCourseService.getByStuSid(1, 10, cid);
        this.pageIn(model, lookList);
        httpSession.setAttribute("lookList", (Object)lookList);
        model.addAttribute("cname", (Object)cname);
        request.setAttribute("cid", (Object)cid);
        request.setAttribute("cname", (Object)cname);
        return "teacher/printStudent";
    }
    
    @RequestMapping(value = { "/endcou/{cid}/{cname}/{pn}" }, method = { RequestMethod.GET })
    public String endCourse(@PathVariable("cid") final String cid, @PathVariable("cname") final String cname, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn, final HttpServletRequest request) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Student> lookList = new ArrayList<Student>();
        lookList = (List<Student>)this.selectCourseService.getByStuSid(1, 10, cid);
        this.pageIn(model, lookList);
        httpSession.setAttribute("lookList", (Object)lookList);
        model.addAttribute("cname", (Object)cname);
        request.setAttribute("cid", (Object)cid);
        request.setAttribute("cname", (Object)cname);
        return "teacher/endCourse";
    }
    
    @RequestMapping(value = { "/endcougrade/{cid}/{cname}/{pn}" }, method = { RequestMethod.GET })
    public String endCourseGrade(@PathVariable("cid") final String cid, @PathVariable("cname") final String cname, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn, final HttpServletRequest request) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<CourseGrade> lookList = new ArrayList<CourseGrade>();
        lookList = (List<CourseGrade>)this.coursePlanService.getCourseGrade(1, 10, cid);
        this.pageIn(model, lookList);
        httpSession.setAttribute("lookList1", (Object)lookList);
        request.setAttribute("cname", (Object)cname);
        return "teacher/endCourseGrade";
    }
    
    @RequestMapping(value = { "/addGrade" }, method = { RequestMethod.POST })
    public String addGrade(@RequestParam("cid") final String cid, @RequestParam("sid") final String sid, @RequestParam("grade") final Integer grade, final Model model, final HttpServletRequest request) {
        final Grade g = new Grade();
        g.setCid(cid);
        g.setSid(sid);
        g.setGrade(grade);
        if (grade >= 60) {
            final Integer credits = this.coursePlanService.getCreditsByCid(cid);
            g.setCredits(credits);
        }
        this.gradeService.insertGrade(g);
        System.out.println(g.toString());
        return "teacher/endCourse";
    }
}
