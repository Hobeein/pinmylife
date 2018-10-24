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
		
		String myTomCatPath = ServletActionContext.getServletContext().getRealPath("/");//��ȡ���������������Ŀ�ĸ�Ŀ¼
		String uploadLocation = myTomCatPath+"/imgFromUplaod";//�ļ������·��
		
		if(imgUpload!=null){//�ж��ϴ����ļ�·���Ƿ�Ϊ��
			File saveFile = new File(uploadLocation+"/"+uif.getUserId(),imgUploadFileName);//newһ���µ�File���󣬲����ļ������ļ�����·����ӽ�ȥ
			Boolean flagf = saveFile.getParentFile().exists();//�ж��ļ�·���Ƿ����
			Boolean flag;
			File nameBack = isFlieNameExist(saveFile);
			
			if(!nameBack.getParentFile().exists()){
				boolean indicator1 = nameBack.getParentFile().mkdirs();//�������ڣ����½���·��
				if(indicator1){
					flag = imgUpload.renameTo(nameBack);//���ϴ����ļ���·�����޸�Ϊ�ļ������·���������շ���ֵ
				}else{
					flag = false;
				}
			}else{
				flag = imgUpload.renameTo(nameBack);//���ϴ����ļ���·�����޸�Ϊ�ļ������·���������շ���ֵ
			}
			if(flag){//����true���ļ�����ɹ�
				pic.setUserInfo(uif);
				pic.setBewrite(getBewrite());
				pic.setUploaddate(uploaddate);
				pic.setPicvisitable(getPicvisitable().trim());
				pic.setPiclink("/pinMyLife/"+nameBack.getParentFile().getParentFile().getName()+"/"+nameBack.getParentFile().getName()+"/"+nameBack.getName());
				pic.setLikes(0);
				boolean indicator = picif.insertPicture(pic);
				if(indicator){
					req.setAttribute("uploadFB", "�Ѵ�!");
					return "Success";
				}else{
					nameBack.delete();
					req.setAttribute("uploadFB", "�ļ��������ݿ�ʧ��!");
					return "Fail";
				}
			}else{//�����ļ��ϴ�ʧ��
				req.setAttribute("uploadFB", "�ƶ��ļ�ʧ��!");
				return "Fail";
			}
		}else{//������ʾ�Ҳ����ϴ����ļ�·��
			req.setAttribute("uploadFB", "�Ҳ������ļ���·��!");
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
