package com.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;

import com.domain.Picture;
import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.PictureServicesImp;
import com.services.PictureServicesInterface;

import freemarker.template.SimpleDate;

public class Pml_ImgUploadAction extends ActionSupport {
	private File imgUpload;
	private String imgUploadContentType;
	private String imgUploadFileName;
	private String bewrite;
	private String picvisitable;
	
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
	public File getImgUpload() {
		return imgUpload;
	}
	public void setImgUpload(File imgUpload) {
		this.imgUpload = imgUpload;
	}
	public String getImgUploadContentType() {
		return imgUploadContentType;
	}
	public void setImgUploadContentType(String imgUploadContentType) {
		this.imgUploadContentType = imgUploadContentType;
	}
	public String getImgUploadFileName() {
		return imgUploadFileName;
	}
	public void setImgUploadFileName(String imgUploadFileName) {
		this.imgUploadFileName = imgUploadFileName;
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
	public String uploadFB() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Map session = ServletActionContext.getContext().getSession();
		PictureServicesInterface picif = new PictureServicesImp();
		UserInfo uif = new UserInfo();
		Picture pic = new Picture();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		Date date = new Date();
		String uploaddate = df.format(date);
		
		uif.setUserId((Integer)session.get("userId"));
		uif.setUsername((String)session.get("username"));
		uif.setSex((String)session.get("sex"));
		uif.setSexvisitable((String)session.get("sexvisitable"));
		uif.setEmail((String)session.get("email"));
		uif.setPhone((String)session.get("phone"));
		uif.setSignature((String)session.get("signature"));
		uif.setPortrait((String)session.get("portrait"));
		
		String myTomCatPath = ServletActionContext.getServletContext().getRealPath("/");//获取服务器所部署的项目的根目录
		String uploadLocation = myTomCatPath+"/imgFromUplaod";//文件保存的路径
		
		if(imgUpload!=null){//判断上传的文件路径是否为空
			File saveFile = new File(uploadLocation+"/"+uif.getUserId(),imgUploadFileName);//new一个新的File对象，并将文件名和文件保存路径添加进去
			Boolean flagf = saveFile.getParentFile().exists();//判断文件路径是否存在
			Boolean flag;
			File nameBack = isFlieNameExist(saveFile);
			
			if(!nameBack.getParentFile().exists()){
				boolean indicator1 = nameBack.getParentFile().mkdirs();//若不存在，则新建该路径
				if(indicator1){
					flag = imgUpload.renameTo(nameBack);//将上传的文件的路径，修改为文件保存的路径，并接收返回值
				}else{
					flag = false;
				}
			}else{
				flag = imgUpload.renameTo(nameBack);//将上传的文件的路径，修改为文件保存的路径，并接收返回值
			}
			if(flag){//返回true则文件保存成功
				pic.setUserInfo(uif);
				pic.setBewrite(getBewrite());
				pic.setUploaddate(uploaddate);
				pic.setPicvisitable(getPicvisitable().trim());
				pic.setPiclink("/pinMyLife/"+nameBack.getParentFile().getParentFile().getName()+"/"+nameBack.getParentFile().getName()+"/"+nameBack.getName());
				pic.setLikes(0);
				boolean indicator = picif.insertPicture(pic);
				if(indicator){
					req.setAttribute("uploadFB", "已传!");
					return "Success";
				}else{
					nameBack.delete();
					req.setAttribute("uploadFB", "文件保存数据库失败!");
					return "Fail";
				}
			}else{//否则文件上传失败
				req.setAttribute("uploadFB", "移动文件失败!");
				return "Fail";
			}
		}else{//否则提示找不到上传的文件路径
			req.setAttribute("uploadFB", "找不到该文件的路径!");
			return "Fail";
		}
	}
	
	public String loginCheck() {
		List list = new ArrayList();
		String userId="";String username="";
		Map session = ActionContext.getContext().getSession();
		if(session.get("userId")!=null){
			userId = (Integer) session.get("userId")+"";
			username= (String) session.get("username");
			ActionContext.getContext().put("userId", userId);
			ActionContext.getContext().put("username", username);
			return "Success";
		}
		return "Fail";
	}
}
