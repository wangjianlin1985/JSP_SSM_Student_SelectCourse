// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String sid;
    private String sname;
    private String sidcard;
    private String ssex;
    private String spassword;
    private String sage;
    private String classr;
    private String profession;
    private String college;
    
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
    }
    
    public String getSname() {
        return this.sname;
    }
    
    public void setSname(final String sname) {
        this.sname = sname;
    }
    
    public String getSidcard() {
        return this.sidcard;
    }
    
    public void setSidcard(final String sidcard) {
        this.sidcard = sidcard;
    }
    
    public String getSsex() {
        return this.ssex;
    }
    
    public void setSsex(final String ssex) {
        this.ssex = ssex;
    }
    
    public String getSpassword() {
        return this.spassword;
    }
    
    public void setSpassword(final String spassword) {
        this.spassword = spassword;
    }
    
    public String getSage() {
        return this.sage;
    }
    
    public void setSage(final String sage) {
        this.sage = sage;
    }
    
    public String getClassr() {
        return this.classr;
    }
    
    public void setClassr(final String classr) {
        this.classr = classr;
    }
    
    public String getProfession() {
        return this.profession;
    }
    
    public void setProfession(final String profession) {
        this.profession = profession;
    }
    
    public String getCollege() {
        return this.college;
    }
    
    public void setCollege(final String college) {
        this.college = college;
    }
}
