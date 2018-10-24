package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

public class Pml_loginAction extends ActionSupport {
	private String phoneOremail;
	private String password;
	
	public String getPhoneOremail() {
		return phoneOremail;
	}
	public void setPhoneOremail(String phoneOremail) {
		this.phoneOremail = phoneOremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String loginFB() {
		String getPoE=getPhoneOremail();
		String getPW=getPassword();
		UserInfo uifp,uife;
		//数据库查询
		UserInfoServicesInterface usif=new UserInfoServicesImp();
		
		List userinfo_p = usif.userInfoQueryByPhone(getPoE);
		List userinfo_e = usif.userInfoQueryByEmail(getPoE);
		if(userinfo_p.size()!=0){
			uifp = (UserInfo) userinfo_p.get(0);
			if(uifp.getPassword().trim().equals(getPW)){
				Map session = ActionContext.getContext().getSession();
				
				session.put("userId", uifp.getUserId());
				session.put("username", uifp.getUsername().trim());
				session.put("sex", uifp.getSex());
				session.put("sexvisitable", uifp.getSexvisitable());
				session.put("email", uifp.getEmail());
				session.put("phone", getPoE);
				session.put("signature", uifp.getSignature().trim());
				session.put("portrait", uifp.getPortrait());
				return "loginSuccess";
			}else{
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("passWordFalse","密码错误，请重新输入！ ");
				return "passWordFalse";
			}
		}else if(userinfo_e.size()!=0){
			uife = (UserInfo) userinfo_e.get(0);
			if(uife.getPassword().trim().equals(getPW)){
				Map session = ActionContext.getContext().getSession();
				session.put("userId", uife.getUserId());
				session.put("username", uife.getUsername());
				session.put("sex", uife.getSex());
				session.put("sexvisitable", uife.getSexvisitable());
				session.put("email", getPoE);
				session.put("phone", uife.getPhone());
				session.put("signature", uife.getSignature());
				session.put("portrait", uife.getPortrait());
				return "loginSuccess";
			}else{
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("passWordFalse","密码错误，请重新输入！ ");
				return "passWordFalse";
			}
		}else{
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("PoEisNotExist","该手机号码或邮箱没有注册！ ");
			return "PoEisNotExist";
		}
	}
}
