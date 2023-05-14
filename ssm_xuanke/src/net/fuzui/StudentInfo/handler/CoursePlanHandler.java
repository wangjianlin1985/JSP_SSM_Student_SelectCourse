// 
// 
// 

package net.fuzui.StudentInfo.handler;

import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.github.pagehelper.PageHelper;
import net.fuzui.StudentInfo.pojo.Course;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import net.fuzui.StudentInfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.CoursePlanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/CoursePlanHandler" })
public class CoursePlanHandler
{
    @Autowired
    CoursePlanService coursePlanService;
    @Autowired
    CourseService courseService;
    
    @RequestMapping({ "/doaddcouplan/{tid}" })
    public ModelAndView addCoursePlan(final CoursePlan coursePlan, final Model model, final HttpSession httpSession, @PathVariable("tid") final String tid) {
        if (this.coursePlanService.insertCoursePlan(coursePlan) != 0) {
            model.addAttribute("coursePlan", (Object)coursePlan);
            System.out.println(coursePlan);
            return new ModelAndView((View)new RedirectView("/ssm_xuanke/TeacherHandler/managecou/{tid}/1"));
        }
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/fail.jsp"));
    }
    
    @RequestMapping(value = { "/querycouplan/{cid}" }, method = { RequestMethod.GET })
    public String deleteStudent(@PathVariable("cid") final String cid, final Model model, final HttpSession session, final HttpServletRequest request) {
        if (this.coursePlanService.existsCoursePlan(cid) != null) {
            request.setAttribute("msg", (Object)"\u8be5\u8bfe\u7a0b\u5df2\u7ecf\u6709\u8001\u5e08\u4ee3\u8bfe\uff0c\u65e0\u6cd5\u9009\u62e9\u6b64\u8bfe\u7a0b\uff01");
            return "fail";
        }
        model.addAttribute("cid", (Object)cid);
        System.out.println(cid);
        return "teacher/doAddCou";
    }
    
    @RequestMapping({ "/addquery/{pn}" })
    public String adStudent(@PathVariable("pn") final String pn, final Model model, final HttpSession httpSession) {
        final int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        httpSession.setAttribute("courseList", (Object)courseList);
        return "teacher/addCou";
    }
    
    public void pageIn(final Model model, final List list) {
        final PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", (Object)page);
    }
    
    @RequestMapping(value = { "/queryy/{pn}" }, method = { RequestMethod.GET })
    public String redirect(@RequestParam("serc") final String serc, @RequestParam("condition") final String condition, final Model model, final HttpSession httpSession, @PathVariable("pn") final String pn, final HttpServletRequest request) {
        final int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        request.setAttribute("serc", (Object)serc);
        request.setAttribute("condition", (Object)condition);
        if (serc.equals("all")) {
            courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
            this.pageIn(model, courseList);
            httpSession.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            return "teacher/addCou";
        }
        if (serc.equals("sid")) {
            courseList = (List<Course>)this.courseService.getByCourseCid(1, 10, condition);
            this.pageIn(model, courseList);
            httpSession.setAttribute("courseList", (Object)courseList);
            System.out.println("sid");
            return "teacher/addCou";
        }
        if (serc.equals("nam")) {
            courseList = (List<Course>)this.courseService.getByCourseCname(1, 10, condition);
            this.pageIn(model, courseList);
            httpSession.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("cla");
            return "teacher/addCou";
        }
        if (serc.equals("col")) {
            courseList = (List<Course>)this.courseService.getByCourseCol(1, 10, condition);
            this.pageIn(model, courseList);
            httpSession.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("col");
            return "teacher/addCou";
        }
        if (serc.equals("type")) {
            courseList = (List<Course>)this.courseService.getByCourseType(1, 10, condition);
            this.pageIn(model, courseList);
            httpSession.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("pro");
            return "teacher/addCou";
        }
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        httpSession.setAttribute("courseList", (Object)courseList);
        System.out.println(courseList);
        return "teacher/addCou";
    }
    
    @RequestMapping({ "/modicouplan/{courseclass}" })
    public String modiCouPlan(@PathVariable("courseclass") final String courseclass, final Model model, final HttpSession httpSession) {
        List<CoursePlan> cPlanList = new ArrayList<CoursePlan>();
        cPlanList = (List<CoursePlan>)this.coursePlanService.getByCoursePlanCourseclass(1, 10, courseclass);
        if (cPlanList != null) {
            httpSession.setAttribute("cPlanList", (Object)cPlanList);
            System.out.println(cPlanList);
            return "teacher/modCouPlan";
        }
        return "fail";
    }
    
    @RequestMapping({ "/moditycouplan/{tid}" })
    public ModelAndView modityCouPlan(@PathVariable("tid") final String tid, final CoursePlan coursePlan) {
        if (this.coursePlanService.modifyCoursePlan(coursePlan) != 0) {
            return new ModelAndView((View)new RedirectView("/ssm_xuanke/TeacherHandler/managecou/{tid}/1"));
        }
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/fail.jsp"));
    }
    
    @RequestMapping({ "/delcouplan/{courseclass}/{tid}" })
    public ModelAndView modityCouPlan(@PathVariable("courseclass") final String courseclass, @PathVariable("tid") final String tid, final HttpSession httpSession) {
        if (this.coursePlanService.deleteCoursePlan(courseclass) != 0) {
            httpSession.removeAttribute("couList");
            httpSession.removeAttribute("coursePlanList");
            return new ModelAndView((View)new RedirectView("/ssm_xuanke/TeacherHandler/managecou/{tid}/1"));
        }
        return new ModelAndView((View)new RedirectView("/ssm_xuanke/fail.jsp"));
    }
}
