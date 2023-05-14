// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class StuSelectResult implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String classr;
    private String coursetime;
    private String courseweek;
    private String cname;
    private String classroom;
    private String credits;
    private String period;
    private String tname;
    
    public String getClassr() {
        return this.classr;
    }
    
    public void setClassr(final String classr) {
        this.classr = classr;
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
    
    public String getCname() {
        return this.cname;
    }
    
    public void setCname(final String cname) {
        this.cname = cname;
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
    
    public String getTname() {
        return this.tname;
    }
    
    public void setTname(final String tname) {
        this.tname = tname;
    }
}
