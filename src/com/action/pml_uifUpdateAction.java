package com.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class pml_uifUpdateAction extends ActionSupport {
	private String username;
	private String sex;
	private String sexvisitable;
	private String email;
	private String phone;
	private String signature;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public String uifUpdateFB() {
		UserInfoServicesInterface uifif = new UserInfoServicesImp();
		UserInfo uif = new UserInfo();
		UserInfo uifp = new UserInfo();
		UserInfo uife = new UserInfo();
		Map session = ServletActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		List uifList = uifif.userInfoQueryById(userId);
		UserInfo userinfo= new UserInfo();
		if(uifList.size()!=0){
			userinfo = (UserInfo) uifList.get(0);
		}
		
		
		List emailuserList = uifif.userInfoQueryByEmail(getEmail());
		List phoneuserList = uifif.userInfoQueryByPhone(getPhone());
		
		if(emailuserList.size()!=0){uife = (UserInfo) emailuserList.get(0);}
		if(phoneuserList.size()!=0){uifp = (UserInfo) phoneuserList.get(0);}
		
		if(!userinfo.getPhone().trim().equals(getPhone().trim())){
			if(uifp.getUserId()!=null){
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("error00", "用户手机号码已存在！不能重复绑定！");
				ActionContext.getContext().put("data", jsonObj);
				return "success";
			}
		}
		if(!userinfo.getEmail().trim().equals(getEmail().trim())){
			if(uifp.getUserId()!=null||uife.getUserId()!=null){
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("error00", "用户邮箱已存在！不能重复绑定！");
				ActionContext.getContext().put("data", jsonObj);
				return "success";
			}
		}
		
		
		uif.setUserId(userId);
		uif.setUsername(getUsername());
		uif.setPassword(userinfo.getPassword());
		uif.setSex(getSex());
		uif.setSexvisitable(getSexvisitable());
		uif.setEmail(getEmail());
		uif.setPhone(getPhone());
		uif.setSignature(getSignature());
		uif.setPortrait(userinfo.getPortrait());
		String flag = uifif.userInfoUpdata(uif);
		if(flag == "Success"){
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("userId", userId);
			jsonObj.put("username", getUsername());
			jsonObj.put("sex", getSex());
			jsonObj.put("sexvisitable", getSexvisitable());
			jsonObj.put("email", getEmail());
			jsonObj.put("phone", getPhone());
			jsonObj.put("signature", getSignature());
			session.put("userId", userId);
			session.put("username", getUsername());
			session.put("sex", getSex());
			session.put("sexvisitable", getSexvisitable());
			session.put("email",getEmail());
			session.put("phone", getPhone());
			session.put("signature", getSignature());
			jsonArr.add(jsonObj);
			ActionContext.getContext().put("data", jsonArr);
			return "success";
		}else{
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("error", "error");
			jsonArr.add(jsonObj);
			ActionContext.getContext().put("data", jsonArr);
			return "success";
		}
	}
}
