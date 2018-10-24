package com.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.domain.Picture;
import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.PictureServicesImp;
import com.services.PictureServicesInterface;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

import net.sf.json.JSONObject;

public class Pml_ImgShareUploadAction extends ActionSupport {
	private File dayMoodImg;
	private String dayMoodImgContentType;
	private String dayMoodImgFileName;
	private String bewrite;
	private String picvisitable;
	public File getDayMoodImg() {
		return dayMoodImg;
	}
	public void setDayMoodImg(File dayMoodImg) {
		this.dayMoodImg = dayMoodImg;
	}
	public String getDayMoodImgContentType() {
		return dayMoodImgContentType;
	}
	public void setDayMoodImgContentType(String dayMoodImgContentType) {
		this.dayMoodImgContentType = dayMoodImgContentType;
	}
	public String getDayMoodImgFileName() {
		return dayMoodImgFileName;
	}
	public void setDayMoodImgFileName(String dayMoodImgFileName) {
		this.dayMoodImgFileName = dayMoodImgFileName;
	}
	public String getBewrite() {
		return bewrite;
	}
	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}
	public String getPicvisitable() {
		return picvisitable;
	}
	public void setPicvisitable(String picvisitable) {
		this.picvisitable = picvisitable;
	}
	
	public String imgShareFB() {
		Map session = ServletActionContext.getContext().getSession();
		UserInfoServicesInterface uifif = new UserInfoServicesImp();
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		Date mydate = new Date();
		String uploaddate = dft.format(mydate);
		List userList = uifif.userInfoQueryById((Integer)session.get("userId"));
		if(userList.size()!=0){
			UserInfo uif = (UserInfo) userList.get(0);
			if(dayMoodImg.exists()){
				String savePath =ServletActionContext.getServletContext().getRealPath("/")+"/imgFromUplaod/"+uif.getUserId();
				File createFile = new File(savePath,dayMoodImgFileName);
				Boolean isFilePathExist = createFile.getParentFile().exists();
				Boolean isRenameSuccess = false;
				if(!isFilePathExist){
					Boolean isFilePathCreate = createFile.getParentFile().mkdirs();
					if(isFilePathCreate){
						isRenameSuccess = dayMoodImg.renameTo(createFile);
					}else{
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("error03", "服务器上传文件错误，请稍后重试！");
						ActionContext.getContext().put("data", jsonObj);
						return "feedBack";
					}
				}else{
					File saveFile = isFlieNameExist(createFile);
					isRenameSuccess = dayMoodImg.renameTo(saveFile);
				}
				if(isRenameSuccess){
					PictureServicesInterface picif = new PictureServicesImp();
					Picture pic = new Picture();
					pic.setUserInfo(uif);
					pic.setPiclink("/pinMyLife/imgFromUplaod/"+uif.getUserId()+"/"+dayMoodImgFileName);
					pic.setBewrite(getBewrite());
					pic.setUploaddate(uploaddate);
					pic.setPicvisitable(getPicvisitable());
					pic.setLikes(0);
					Boolean isDBInsertSuccess = picif.insertPicture(pic);
					if(isDBInsertSuccess){
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("piclink", "/pinMyLife/imgFromUplaod/"+uif.getUserId()+"/"+dayMoodImgFileName);
						jsonObj.put("uploaddate", uploaddate);
						jsonObj.put("bewrite", getBewrite());
						jsonObj.put("username", uif.getUsername());
						ActionContext.getContext().put("data", jsonObj);
						return "feedBack";
					}else{
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("error03", "服务器上传文件错误，请稍后重试！");
						ActionContext.getContext().put("data", jsonObj);
						return "feedBack";
					}
				}else{
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("error03", "服务器上传文件错误，请稍后重试！");
					ActionContext.getContext().put("data", jsonObj);
					return "feedBack";
				}
			}else{
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("error02", "空文件上传不了哦！");
				ActionContext.getContext().put("data", jsonObj);
				return "feedBack";
			}
		}else{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("error01", "查询不到用户信息，建议重新登录!");
			ActionContext.getContext().put("data", jsonObj);
			return "feedBack";
		}
	}
	public File isFlieNameExist(File myFile){
		String realName = myFile.getName().substring(0, myFile.getName().indexOf("."));
		String typeName = myFile.getName().substring(myFile.getName().indexOf("."));
		if(myFile.exists()){
			File theFile = new File(myFile.getParentFile(),realName+"s"+typeName);
			return isFlieNameExist(theFile);
		}else{
			return myFile;
		}
	}
}
