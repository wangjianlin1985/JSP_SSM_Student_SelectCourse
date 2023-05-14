// 
// 
// 

package net.fuzui.StudentInfo.pojo;

import java.io.Serializable;

public class Course implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String cid;
    private String cname;
    private String cintroduction;
    private String type;
    private String belongcoll;
    private String belongpro;
    
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
    
    public String getCintroduction() {
        return this.cintroduction;
    }
    
    public void setCintroduction(final String cintroduction) {
        this.cintroduction = cintroduction;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getBelongcoll() {
        return this.belongcoll;
    }
    
    public void setBelongcoll(final String belongcoll) {
        this.belongcoll = belongcoll;
    }
    
    public String getBelongpro() {
        return this.belongpro;
    }
    
    public void setBelongpro(final String belongpro) {
        this.belongpro = belongpro;
    }
}
