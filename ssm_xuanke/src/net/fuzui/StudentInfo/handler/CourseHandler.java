// 
// 
// 

package net.fuzui.StudentInfo.handler;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.ui.Model;
import net.fuzui.StudentInfo.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.CourseService;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/CourseHandler" })
@SessionAttributes({ "courseList" })
public class CourseHandler
{
    @Autowired
    CourseService courseService;
    
    @RequestMapping({ "/addCourse" })
    public String addCourse(final Course course, final Model model) {
        if (this.courseService.insertCourse(course) != 0) {
            model.addAttribute("course", (Object)course);
            return "success";
        }
        return "fail";
    }
    
    public void pageIn(final Model model, final List list) {
        final PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", (Object)page);
    }
    
    public void queryCou(final HttpServletRequest request) {
        List<Course> courseList = new ArrayList<Course>();
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        request.setAttribute("courseList", (Object)courseList);
    }
    
    @RequestMapping(value = { "/query/{pn}" }, method = { RequestMethod.GET })
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
            return "admin/queryCourse";
        }
        if (serc.equals("sid")) {
            courseList = (List<Course>)this.courseService.getByCourseCid(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println("sid");
            return "admin/queryCourse";
        }
        if (serc.equals("nam")) {
            courseList = (List<Course>)this.courseService.getByCourseCname(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("cla");
            return "admin/queryCourse";
        }
        if (serc.equals("col")) {
            courseList = (List<Course>)this.courseService.getByCourseCol(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("col");
            return "admin/queryCourse";
        }
        if (serc.equals("type")) {
            courseList = (List<Course>)this.courseService.getByCourseType(1, 10, condition);
            this.pageIn(model, courseList);
            request.setAttribute("courseList", (Object)courseList);
            System.out.println(courseList);
            System.out.println("pro");
            return "admin/queryCourse";
        }
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        request.setAttribute("courseList", (Object)courseList);
        return "admin/queryCourse";
    }
    
    @RequestMapping(value = { "/delete/{cid}" }, method = { RequestMethod.GET })
    public String deleteStudent(@PathVariable("cid") final String cid, final HttpServletRequest request) {
        if (this.courseService.deleteCourse(cid) != 0) {
            System.out.println("success");
            this.queryCou(request);
            return "success";
        }
        System.out.println("fail");
        return "fail";
    }
    
    @RequestMapping(value = { "/finalPage" }, method = { RequestMethod.GET })
    public String finalPage(final HttpSession httpSession, final HttpServletRequest request) {
        final Object admin = request.getSession().getAttribute("courseList");
        System.out.println(admin + "111111111111111111111111111111111111111111111111111111111111111111111111111");
        return "admin/queryCourse";
    }
    
    @RequestMapping(value = { "/moditystu/{cid}" }, method = { RequestMethod.GET })
    public String editPre(@PathVariable("cid") final String cid, final HttpServletRequest request) {
        List<Course> courseList = new ArrayList<Course>();
        courseList = (List<Course>)this.courseService.getByCourseCid(1, 10, cid);
        request.setAttribute("courseList", (Object)courseList);
        return "admin/modiCourse";
    }
    
    @RequestMapping(value = { "/moditystud/{cid}" }, method = { RequestMethod.GET })
    public String update(@PathVariable("cid") final String cid, final Course course, final Model model) {
        if (this.courseService.modifyCourse(course) != 0) {
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping({ "/managecou/{pn}" })
    public String manageCourse(final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        courseList = (List<Course>)this.courseService.selectCourseBySql(1, 10);
        this.pageIn(model, courseList);
        request.setAttribute("courseList", (Object)courseList);
        return "admin/queryCourse";
    }
}
