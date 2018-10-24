package com.intercepter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class Pmlintercepteor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String pageName = arg0.getInvocationContext().getName();
		if(pageName.equals("pml_LoginAction")||pageName.equals("pml_LogupAction")||pageName.equals("Pml_MainPageAction")){
			return arg0.invoke();
		}else{
			Map session = arg0.getInvocationContext().getSession();
			if(session.get("userId")==null||session.get("userId").equals("")){
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("error", "ÓÃ»§ÉÐÎ´µÇÂ¼£¬ÇëµÇÂ¼ÔÙÊÔ¡£");
				return "error";
			}else{
				return arg0.invoke();
			}
		}
	}

}
