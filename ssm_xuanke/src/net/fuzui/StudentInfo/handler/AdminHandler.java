// 
// 
// 

package net.fuzui.StudentInfo.handler;

import javax.servlet.http.HttpSession;
import net.fuzui.StudentInfo.pojo.Teacher;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/AdminHandler" })
public class AdminHandler
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
    String[] arr_belongcoll;
    String[][] arr_belongpro;
    String[][][] arr_belongcla;
    
    public AdminHandler() {
        this.arr_belongcoll = new String[] { "\u8ba1\u7b97\u673a\u5b66\u9662", "\u5efa\u7b51\u5b66\u9662", "\u5916\u56fd\u8bed\u5b66\u9662", "\u4eba\u6587\u5b66\u9662" };
        this.arr_belongpro = new String[][] { { "\u7f51\u7edc\u5de5\u7a0b", "\u8f6f\u4ef6\u5de5\u7a0b", "\u7269\u8054\u7f51", "\u4fe1\u606f\u7ba1\u7406" }, { "\u571f\u6728\u5de5\u7a0b", "\u6d4b\u7ed8\u5de5\u7a0b", "\u5de5\u7a0b\u9020\u4ef7", "\u57ce\u5e02\u89c4\u5212" }, { "\u82f1\u8bed", "\u65e5\u8bed", "\u4fc4\u8bed", "\u897f\u73ed\u7259\u8bed" }, { "\u6c49\u8bed\u8a00", "\u5386\u53f2", "\u65b0\u95fb", "\u7f51\u7edc\u65b0\u5a92\u4f53" } };
        this.arr_belongcla = new String[][][] { { { "\u7f51\u7edcB151", "\u7f51\u7edcB152", "\u7f51\u7edcB161", "\u7f51\u7edcB162", "\u7f51\u7edcB171", "\u7f51\u7edcB172" }, { "\u8f6f\u4ef6B151", "\u8f6f\u4ef6B152", "\u8f6f\u4ef6B161", "\u8f6f\u4ef6B162", "\u8f6f\u4ef6B171", "\u8f6f\u4ef6B172" }, { "\u7269\u8054B151", "\u7269\u8054B152", "\u7269\u8054B161", "\u7269\u8054B162", "\u7269\u8054B171", "\u7269\u8054B172" }, { "\u4fe1\u7ba1B151", "\u4fe1\u7ba1B152", "\u4fe1\u7ba1B161", "\u4fe1\u7ba1B162", "\u4fe1\u7ba1B171", "\u4fe1\u7ba1B172" } }, { { "\u571f\u6728B151", "\u571f\u6728B152", "\u571f\u6728B161", "\u571f\u6728B162", "\u571f\u6728B171", "\u571f\u6728B172" }, { "\u6d4b\u7ed8B151", "\u6d4b\u7ed8B152", "\u6d4b\u7ed8B161", "\u6d4b\u7ed8B162", "\u6d4b\u7ed8B171", "\u6d4b\u7ed8B172" }, { "\u9020\u4ef7B151", "\u9020\u4ef7B152", "\u9020\u4ef7B161", "\u9020\u4ef7B162", "\u9020\u4ef7B171", "\u9020\u4ef7B172" }, { "\u89c4\u5212B151", "\u89c4\u5212B152", "\u89c4\u5212B161", "\u89c4\u5212B162", "\u89c4\u5212B171", "\u89c4\u5212B172" } }, { { "\u82f1\u8bedB151", "\u82f1\u8bedB152", "\u82f1\u8bedB161", "\u82f1\u8bedB162", "\u82f1\u8bedB171", "\u82f1\u8bedB172" }, { "\u65e5\u8bedB151", "\u65e5\u8bedB152", "\u65e5\u8bedB161", "\u65e5\u8bedB162", "\u65e5\u8bedB171", "\u65e5\u8bedB172" }, { "\u4fc4\u8bedB151", "\u4fc4\u8bedB152", "\u4fc4\u8bedB161", "\u4fc4\u8bedB162", "\u4fc4\u8bedB171", "\u4fc4\u8bedB172" }, { "\u7259\u8bedB151", "\u7259\u8bedB152", "\u7259\u8bedB161", "\u7259\u8bedB162", "\u7259\u8bedB171", "\u7259\u8bedB172" } }, { { "\u6c49\u8bedB151", "\u6c49\u8bedB152", "\u6c49\u8bedB161", "\u6c49\u8bedB162", "\u6c49\u8bedB171", "\u6c49\u8bedB172" }, { "\u5386\u53f2B151", "\u5386\u53f2B152", "\u5386\u53f2B161", "\u5386\u53f2B162", "\u5386\u53f2B171", "\u5386\u53f2B172" }, { "\u65b0\u95fbB151", "\u65b0\u95fbB152", "\u65b0\u95fbB161", "\u65b0\u95fbB162", "\u65b0\u95fbB171", "\u65b0\u95fbB172" }, { "\u7f51\u5a92B151", "\u7f51\u5a92B152", "\u7f51\u5a92B161", "\u7f51\u5a92B162", "\u7f51\u5a92B171", "\u7f51\u5a92B172" } } };
    }
    
    @RequestMapping({ "/addStudent" })
    public String addStudent(final Student student, final Model model) {
        final int col = Integer.parseInt(student.getCollege());
        final int pro = Integer.parseInt(student.getProfession());
        final int cla = Integer.parseInt(student.getClassr());
        student.setCollege(this.arr_belongcoll[pro]);
        student.setProfession(this.arr_belongpro[pro][col]);
        student.setClassr(this.arr_belongcla[pro][col][cla]);
        if (this.studentService.insertStudent(student) != 0) {
            model.addAttribute("student", (Object)student);
            return "success";
        }
        return "fail";
    }
    
    public void queryStu(final HttpServletRequest request) {
        List<Student> studentList = new ArrayList<Student>();
        studentList = (List<Student>)this.studentService.selectStudentBySql(1, 10);
        request.setAttribute("slist", (Object)studentList);
    }
    
    public void pageIn(final Model model, final List list) {
        final PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", (Object)page);
    }
    
    @RequestMapping(value = { "/query/{pn}" }, method = { RequestMethod.GET })
    public String redirect(@RequestParam("serc") final String serc, @RequestParam("condition") final String condition, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        List<Student> studentList = new ArrayList<Student>();
        PageHelper.startPage(no, 5);
        request.setAttribute("serc", (Object)serc);
        request.setAttribute("condition", (Object)condition);
        if (serc.equals("all")) {
            System.out.println("------------------------------------------------------------------------------------------------");
            studentList = (List<Student>)this.studentService.selectStudentBySql(1, 10);
            this.pageIn(model, studentList);
            request.setAttribute("slist", (Object)studentList);
            return "admin/queryStudent";
        }
        if (serc.equals("sid")) {
            studentList = (List<Student>)this.studentService.getByStudentSid(1, 10, condition);
            this.pageIn(model, studentList);
            request.setAttribute("slist", (Object)studentList);
            System.out.println("sid");
            return "admin/queryStudent";
        }
        if (serc.equals("col")) {
            studentList = (List<Student>)this.studentService.getByStudentCol(1, 10, condition);
            this.pageIn(model, studentList);
            request.setAttribute("slist", (Object)studentList);
            System.out.println(studentList);
            System.out.println("col");
            return "admin/queryStudent";
        }
        if (serc.equals("pro")) {
            studentList = (List<Student>)this.studentService.getByStudentPro(1, 10, condition);
            this.pageIn(model, studentList);
            request.setAttribute("slist", (Object)studentList);
            System.out.println(studentList);
            System.out.println("pro");
            return "admin/queryStudent";
        }
        if (serc.equals("cla")) {
            studentList = (List<Student>)this.studentService.getByStudentCla(1, 10, condition);
            this.pageIn(model, studentList);
            request.setAttribute("slist", (Object)studentList);
            return "admin/queryStudent";
        }
        studentList = (List<Student>)this.studentService.selectStudentBySql(1, 10);
        this.pageIn(model, studentList);
        request.setAttribute("slist", (Object)studentList);
        return "admin/queryStudent";
    }
    
    @RequestMapping(value = { "/delete/{sid}" }, method = { RequestMethod.GET })
    public String deleteStudent(@PathVariable("sid") final String sid, final Model model) {
        if (this.studentService.deleteStudent(sid) != 0) {
            System.out.println("success");
            return "success";
        }
        System.out.println("fail");
        return "fail";
    }
    
    @RequestMapping(value = { "/finalPage" }, method = { RequestMethod.GET })
    public String finalPage(final HttpServletRequest request) {
        this.queryStu(request);
        return "admin/queryStudent";
    }
    
    @RequestMapping(value = { "/moditystu/{sid}" }, method = { RequestMethod.GET })
    public String editPre(@PathVariable("sid") final String sid, final HttpServletRequest request) {
        List<Student> studentList = new ArrayList<Student>();
        studentList = (List<Student>)this.studentService.getByStudentSid(1, 10, sid);
        request.setAttribute("studentList", (Object)studentList);
        System.out.println("-----\u8fdb\u5165\u4fee\u6539");
        return "admin/modiStudent";
    }
    
    @RequestMapping(value = { "/moditystud/{sid}" }, method = { RequestMethod.GET })
    public String update(@PathVariable("sid") final String sid, final Student student, final HttpServletRequest request) {
        final int col = Integer.parseInt(student.getCollege());
        final int pro = Integer.parseInt(student.getProfession());
        final int cla = Integer.parseInt(student.getClassr());
        student.setCollege(this.arr_belongcoll[pro]);
        student.setProfession(this.arr_belongpro[pro][col]);
        student.setClassr(this.arr_belongcla[pro][col][cla]);
        if (this.studentService.modifyStudent(student) != 0) {
            System.out.println("----\u4fee\u6539\u6210\u529f--------------------------------------------------------------------------------------------------------");
            return "success";
        }
        System.out.println("----\u4fee\u6539\u5931\u8d25----------------------------------------------------------------");
        return "fail";
    }
    
    @RequestMapping({ "/managestu/{pn}" })
    public String manageStudent(final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Student> studentList = new ArrayList<Student>();
        studentList = (List<Student>)this.studentService.selectStudentBySql(1, 100);
        this.pageIn(model, studentList);
        request.setAttribute("slist", (Object)studentList);
        return "admin/queryStudent";
    }
    
    @RequestMapping({ "/managetea/{pn}" })
    public String manageTeacher(final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = (List<Teacher>)this.teacherService.selectTeacherBySql(1, 10);
        this.pageIn(model, teacherList);
        request.setAttribute("teacherList", (Object)teacherList);
        return "admin/queryTeacher";
    }
    
    @RequestMapping({ "/addstu" })
    public String adStudent() {
        return "admin/addStudent";
    }
    
    @RequestMapping({ "/addtea" })
    public String adTeacher() {
        return "admin/addTeacher";
    }
    
    @RequestMapping({ "/addcou" })
    public String adCourse() {
        return "admin/addCourse";
    }
    
    @RequestMapping({ "/addTeacher" })
    public String addTeacher(final Teacher teacher, final Model model, final HttpSession httpSession) {
        if (this.teacherService.insertTeacher(teacher) != 0) {
            model.addAttribute("teacher", (Object)teacher);
            return "success";
        }
        return "fail";
    }
    
    public void queryTea(final HttpServletRequest request) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = (List<Teacher>)this.teacherService.selectTeacherBySql(1, 10);
        request.setAttribute("teacherList", (Object)teacherList);
    }
    
    @RequestMapping(value = { "/queryTea/{pn}" }, method = { RequestMethod.GET })
    public String redirectTea(@RequestParam("serc") final String serc, @RequestParam("condition") final String condition, final HttpServletRequest request, @PathVariable("pn") final String pn, final Model model) {
        final int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Teacher> teacherList = new ArrayList<Teacher>();
        request.setAttribute("serc", (Object)serc);
        request.setAttribute("condition", (Object)condition);
        if (serc.equals("all")) {
            teacherList = (List<Teacher>)this.teacherService.selectTeacherBySql(1, 10);
            this.pageIn(model, teacherList);
            request.setAttribute("teacherList", (Object)teacherList);
            return "admin/queryTeacher";
        }
        if (serc.equals("tid")) {
            teacherList = (List<Teacher>)this.teacherService.getByTeacherTid(1, 10, condition);
            this.pageIn(model, teacherList);
            request.setAttribute("teacherList", (Object)teacherList);
            System.out.println("tid");
            return "admin/queryTeacher";
        }
        teacherList = (List<Teacher>)this.teacherService.selectTeacherBySql(1, 10);
        this.pageIn(model, teacherList);
        request.setAttribute("teacherList", (Object)teacherList);
        return "admin/queryTeacher";
    }
    
    @RequestMapping(value = { "/deleteTea/{tid}" }, method = { RequestMethod.GET })
    public String deleteTeacher(@PathVariable("tid") final String tid, final Model model) {
        if (this.teacherService.deleteTeacher(tid) != 0) {
            System.out.println("success");
            return "success";
        }
        System.out.println("fail");
        return "fail";
    }
    
    @RequestMapping(value = { "/finalPageTea" }, method = { RequestMethod.GET })
    public String finalPageTea(final HttpServletRequest request) {
        this.queryTea(request);
        return "admin/queryTeacher";
    }
    
    @RequestMapping(value = { "/modityTea/{tid}" }, method = { RequestMethod.GET })
    public String editPreTea(@PathVariable("tid") final String tid, final HttpServletRequest request) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = (List<Teacher>)this.teacherService.getByTeacherTid(1, 10, tid);
        request.setAttribute("teacherList", (Object)teacherList);
        return "admin/modiTeacher";
    }
    
    @RequestMapping(value = { "/modityTeac/{tid}" }, method = { RequestMethod.GET })
    public String update(@PathVariable("tid") final String tid, final Teacher teacher, final HttpServletRequest request) {
        if (this.teacherService.modifyTeacher(teacher) != 0) {
            return "success";
        }
        return "fail";
    }
}
