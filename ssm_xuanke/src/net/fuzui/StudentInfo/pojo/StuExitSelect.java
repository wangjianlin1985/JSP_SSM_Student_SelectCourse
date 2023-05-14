// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class StuExitSelect implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String cid;
    private String Cname;
    private String sid;
    private Integer totalNum;
    private Integer stuSum;
    
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(final String cid) {
        this.cid = cid;
    }
    
    public String getCname() {
        return this.Cname;
    }
    
    public void setCname(final String cname) {
        this.Cname = cname;
    }
    
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
    }
    
    public void setStuSum(final Integer stuSum) {
        this.stuSum = stuSum;
    }
    
    public Integer getStuSum() {
        return this.stuSum;
    }
    
    public void setTotalNum(final Integer totalNum) {
        this.totalNum = totalNum;
    }
    
    public Integer getTotalNum() {
        return this.totalNum;
    }
}
