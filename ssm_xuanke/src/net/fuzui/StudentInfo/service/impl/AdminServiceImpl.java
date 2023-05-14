// 
// 
// 

package net.fuzui.StudentInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import net.fuzui.StudentInfo.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import net.fuzui.StudentInfo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminMapper adminMapper;
    
    public String queryByNamePwd(final String aname, final String apassword) {
        return this.adminMapper.queryByNamePwd(aname, apassword);
    }
}
