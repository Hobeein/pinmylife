package com.action;

import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;

import org.apache.struts2.ServletActionContext;

import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

public class Pml_logupAction extends ActionSupport {

	private String username;
	private String password;
	private String sex;
	private String sexvisitable;
	private String email;
	private String phone;
	private String signature;
	private String portrait;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSexvisitable() {
		return sexvisitable;
	}
	public void setSexvisitable(String sexvisitable) {
		this.sexvisitable = sexvisitable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
	public String logupFB() {
		UserInfoServicesInterface uisi=new UserInfoServicesImp();
		List uifp = uisi.userInfoQueryByPhone(getPhone());
		List uife = uisi.userInfoQueryByEmail(getEmail());
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("logupFB", "返回注册页面");
		
		if(uifp.size()!=0){
			req.setAttribute("PhoneisExist", "该手机号码已被注册！");
			return "logupFail";
		}else if(uife.size()!=0){
			req.setAttribute("EmailisExist", "该邮箱已被注册！");
			return "logupFail";
		}else{
			UserInfo uif=new UserInfo();
			uif.setUsername(getUsername());
			uif.setPassword(getPassword());
			uif.setSex(getSex());
			uif.setSexvisitable(getSexvisitable());
			uif.setEmail(getEmail());
			uif.setPhone(getPhone());
			uif.setSignature(getSignature());
			uif.setPortrait(getPortrait());
			
			String flag = uisi.userInfoInsert(uif);
			if(flag.equals("Success")){
				req.setAttribute("logupSuccess", getPhone());
				return "logupSuccess";
			}else{
				req.setAttribute("logupFail", "注册失败请重新注册");
				return "logupFail";
			}
		}
	}
}
