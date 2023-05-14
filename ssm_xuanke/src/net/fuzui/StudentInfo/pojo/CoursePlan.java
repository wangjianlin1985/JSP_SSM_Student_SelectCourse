// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class CoursePlan implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String courseclass;
    private String coursetime;
    private String courseweek;
    private String cid;
    private String tid;
    private String classroom;
    private String credits;
    private String period;
    private String totalnum;
    
    public String getCourseclass() {
        return this.courseclass;
    }
    
    public void setCourseclass(final String courseclass) {
        this.courseclass = courseclass;
    }
    
    public String getCoursetime() {
        return this.coursetime;
    }
    
    public void setCoursetime(final String coursetime) {
        this.coursetime = coursetime;
    }
    
    public String getCourseweek() {
        return this.courseweek;
    }
    
    public void setCourseweek(final String courseweek) {
        this.courseweek = courseweek;
    }
    
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(final String cid) {
        this.cid = cid;
    }
    
    public String getTid() {
        return this.tid;
    }
    
    public void setTid(final String tid) {
        this.tid = tid;
    }
    
    public String getClassroom() {
        return this.classroom;
    }
    
    public void setClassroom(final String classroom) {
        this.classroom = classroom;
    }
    
    public String getCredits() {
        return this.credits;
    }
    
    public void setCredits(final String credits) {
        this.credits = credits;
    }
    
    public String getPeriod() {
        return this.period;
    }
    
    public void setPeriod(final String period) {
        this.period = period;
    }
    
    public String getTotalnum() {
        return this.totalnum;
    }
    
    public void setTotalnum(final String totalnum) {
        this.totalnum = totalnum;
    }
}
