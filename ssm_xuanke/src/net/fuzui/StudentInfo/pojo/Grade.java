// 
// 
// 

package net.fuzui.StudentInfo.pojo;

public class Grade
{
    private String cid;
    private String cname;
    private String sid;
    private Integer grade;
    private Integer credits;
    
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(final String cid) {
        this.cid = cid;
    }
    
    public String getCname() {
        return this.cname;
    }
    
    public void setCname(final String cname) {
        this.cname = cname;
    }
    
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
    }
    
    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }
    
    public Integer getCredits() {
        return this.credits;
    }
    
    public void setCredits(final Integer credits) {
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return "Grade [cid=" + this.cid + ", sid=" + this.sid + ", grade=" + this.grade + ", credits=" + this.credits + "]";
    }
}
