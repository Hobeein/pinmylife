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

import net.sf.json.JSONObject;

public class Pml_pwUpdateAction extends ActionSupport {
	private String password;
	private String passwordNow;

	public String getPasswordNow() {
		return passwordNow;
	}

	public void setPasswordNow(String passwordNow) {
		this.passwordNow = passwordNow;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String pwUpdateFB() {
		UserInfoServicesInterface uifif = new UserInfoServicesImp();
		Map session = ServletActionContext.getContext().getSession();
		Integer userId = (Integer) session.get("userId");
		List userlist = uifif.userInfoQueryById(userId);
		UserInfo uif = null;
		for(Iterator iter = userlist.iterator();iter.hasNext();){
			uif = (UserInfo)iter.next();
		}
		if(uif.getUserId()!=null){
			if(!uif.getPassword().trim().equals(getPasswordNow().trim())){
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("error00", "密码错误，请重新输入正确密码！");
				ActionContext.getContext().put("data", jsonObj);
				return "success";
			}else{
				UserInfo uifUpdate = new UserInfo();
				uifUpdate.setUserId(uif.getUserId());
				uifUpdate.setUsername(uif.getUsername());
				uifUpdate.setPassword(getPassword());
				uifUpdate.setSex(uif.getSex());
				uifUpdate.setSexvisitable(uif.getSexvisitable());
				uifUpdate.setEmail(uif.getEmail());
				uifUpdate.setPhone(uif.getPhone());
				uifUpdate.setPortrait(uif.getPortrait());
				uifUpdate.setSignature(uif.getSignature());
				String flag = uifif.userInfoUpdata(uifUpdate);
				if(flag == "Success"){
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("success", "success");
					ActionContext.getContext().put("data", jsonObj);
					return "success";
				}else{
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("error01", "服务器错误，更新密码失败！");
					ActionContext.getContext().put("data", jsonObj);
					return "success";
				}
			}
		}else{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("error02", "服务器错误，查询不到当前用户名，建议重新登录！");
			ActionContext.getContext().put("data", jsonObj);
			return "success";
		}
	}
}
