package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Action;

import org.apache.struts2.ServletActionContext;

import com.domain.Picture;
import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.PictureServicesImp;
import com.services.PictureServicesInterface;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AJaXTextActoin extends ActionSupport {
	private String inp1;
	private String inp2;
	private String inp3;
	private String piclink;
	private String uplaodDate;
	private Integer likes;
	private String bewrite;
	private UserInfo uif;
	
	
	public String getInp1() {
		return inp1;
	}
	public void setInp1(String inp1) {
		this.inp1 = inp1;
	}
	public String getInp2() {
		return inp2;
	}
	public void setInp2(String inp2) {
		this.inp2 = inp2;
	}
	public String getInp3() {
		return inp3;
	}
	public void setInp3(String inp3) {
		this.inp3 = inp3;
	}
	public String getPiclink() {
		return piclink;
	}
	public void setPiclink(String piclink) {
		this.piclink = piclink;
	}
	public String getUplaodDate() {
		return uplaodDate;
	}
	public void setUplaodDate(String uplaodData) {
		this.uplaodDate = uplaodData;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public String getBewrite() {
		return bewrite;
	}
	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}
	public UserInfo getUif() {
		return uif;
	}
	public void setUif(UserInfo uif) {
		this.uif = uif;
	}
	
	public String textFeadBack(){
		Map session = ServletActionContext.getContext().getSession();
		PictureServicesInterface picif = new PictureServicesImp();
		List list = picif.queryAllPicture();
		JSONArray dataArray = new JSONArray();
		for(Iterator iter=list.iterator();iter.hasNext();){
			JSONObject data = new JSONObject();
			Picture pic = (Picture) iter.next();
			if(pic.getPictureId()!=null){
				data.put("pictureId", pic.getPictureId());
				data.put("userId", pic.getUserInfo().getUserId());
				data.put("piclink", pic.getPiclink());
				data.put("bewrite", pic.getBewrite());
				data.put("uploaddate", pic.getUploaddate());
				data.put("picvisitable", pic.getPicvisitable());
				data.put("likes", pic.getLikes());
				dataArray.add(data);
			}
		}
		ActionContext.getContext().put("data", dataArray);
		
		return "user";
	}
}
