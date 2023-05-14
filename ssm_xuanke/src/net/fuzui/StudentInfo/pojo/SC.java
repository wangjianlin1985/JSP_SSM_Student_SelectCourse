// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class SC implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String sid;
    private String cid;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
    }
    
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(final String cid) {
        this.cid = cid;
    }
}
