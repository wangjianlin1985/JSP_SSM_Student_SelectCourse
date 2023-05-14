// 
// 
// 

package net.fuzui.StudentInfo.interceptor;

import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

public class TeacherLoginInterceptor implements HandlerInterceptor
{
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        final Object sid = request.getSession().getAttribute("tid");
        if (sid == null) {
            System.out.println("\u5c1a\u672a\u767b\u5f55\uff0c\u8c03\u5230\u767b\u5f55\u9875\u9762");
            response.sendRedirect("/ssm_xuanke/index.jsp");
            return false;
        }
        return true;
    }
    
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
    
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
