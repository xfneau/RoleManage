package com.hoolai.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.xml.rpc.ServiceFactory;

//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class SecurityInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get(Content.USER_SESSION);  
        String  name = invocation.getInvocationContext().getName();
        // 如果没有登陆，返回重新登陆  
  
        if (name.equals("hello")||(name.equals("index")&&user!=null)) {
            // 如果用户想登录，则使之通过
            return invocation.invoke();
        } else {
	        if (user != null) {   
	            return invocation.invoke();  
	        }  
        }
  

        return "login";  
	}

}
