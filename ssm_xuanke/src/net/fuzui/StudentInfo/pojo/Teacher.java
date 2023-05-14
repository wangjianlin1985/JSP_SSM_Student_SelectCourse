// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class Teacher implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String tid;
    private String tname;
    private String tpassword;
    private String tsex;
    private String introduction;
    
    public String getTid() {
        return this.tid;
    }
    
    public void setTid(final String tid) {
        this.tid = tid;
    }
    
    public String getTname() {
        return this.tname;
    }
    
    public void setTname(final String tname) {
        this.tname = tname;
    }
    
    public String getTpassword() {
        return this.tpassword;
    }
    
    public void setTpassword(final String tpassword) {
        this.tpassword = tpassword;
    }
    
    public String getTsex() {
        return this.tsex;
    }
    
    public void setTsex(final String tsex) {
        this.tsex = tsex;
    }
    
    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(final String introduction) {
        this.introduction = introduction;
    }
}
