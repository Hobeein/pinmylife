package com.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

import net.sf.json.JSONObject;

public class Pml_porUpdateAction extends ActionSupport {
	private File porUpdate;
	private String porUpdateContentType;
	private String porUpdateFileName;
	
	public File getPorUpdate() {
		return porUpdate;
	}
	public void setPorUpdate(File porUpdate) {
		this.porUpdate = porUpdate;
	}
	public String getPorUpdateContentType() {
		return porUpdateContentType;
	}
	public void setPorUpdateContentType(String porUpdateContentType) {
		this.porUpdateContentType = porUpdateContentType;
	}
	public String getPorUpdateFileName() {
		return porUpdateFileName;
	}
	public void setPorUpdateFileName(String porUpdateFileName) {
		this.porUpdateFileName = porUpdateFileName;
	}
	
	public String porUpdateFB() {
		if(porUpdate==null||!porUpdate.exists()){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("error00", "并没有选到文件哦！");
			ActionContext.getContext().put("data", jsonObj);
			return "success";
		}		
		Map session = ServletActionContext.getContext().getSession();
		UserInfoServicesInterface uifif = new UserInfoServicesImp();
		UserInfo uif = new UserInfo();
		List userlist = uifif.userInfoQueryById((Integer)session.get("userId"));
		if(userlist.size()!=0){
			uif = (UserInfo) userlist.get(0);
		}
		if(uif.getUserId()==null){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("error01", "服务器错误：查询不到用户，建议重新登录！");
			ActionContext.getContext().put("data", jsonObj);
			return "success";
		}else{
			String uploadLocation = ServletActionContext.getServletContext().getRealPath("/") + "/imgFromUplaod";
			String savePath = uploadLocation+"/"+uif.getUserId()+"/portrait";
			File saveFile = new File(savePath,getPorUpdateFileName());
			if(saveFile.getParentFile().exists()){
				clearFile(saveFile);
				File comfFile = isFlieNameExist(saveFile);
				Boolean flag = porUpdate.renameTo(comfFile);
				if(flag){
					UserInfo uifUpdate = new UserInfo();
					uifUpdate.setUserId(uif.getUserId());
					uifUpdate.setUsername(uif.getUsername());
					uifUpdate.setPassword(uif.getPassword());
					uifUpdate.setSex(uif.getSex());
					uifUpdate.setSexvisitable(uif.getSexvisitable());
					uifUpdate.setEmail(uif.getEmail());
					uifUpdate.setPhone(uif.getPhone());
					uifUpdate.setPortrait("/pinMyLife/imgFromUplaod/"+uif.getUserId()+"/portrait/"+comfFile.getName());
					uifUpdate.setSignature(uif.getSignature());
					String isUifUpdate = uifif.userInfoUpdata(uifUpdate);
					if(isUifUpdate=="Success"){
						session.put("portrait", uifUpdate.getPortrait());
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("portrait", uifUpdate.getPortrait());
						ActionContext.getContext().put("data", jsonObj);
						return "success";
					}else{
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("error03", "服务器保存头像失败！");
						ActionContext.getContext().put("data", jsonObj);
						return "success";
					}
				}else{
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("error02", "上传文件失败！");
					ActionContext.getContext().put("data", jsonObj);
					return "success";
				}
			}else{
				Boolean isFileCreate = saveFile.getParentFile().mkdirs();
				if(isFileCreate){
					File comfFile = isFlieNameExist(saveFile);
					Boolean flag = porUpdate.renameTo(comfFile);
					if(flag){
						UserInfo uifUpdate = new UserInfo();
						uifUpdate.setUserId(uif.getUserId());
						uifUpdate.setUsername(uif.getUsername());
						uifUpdate.setPassword(uif.getPassword());
						uifUpdate.setSex(uif.getSex());
						uifUpdate.setSexvisitable(uif.getSexvisitable());
						uifUpdate.setEmail(uif.getEmail());
						uifUpdate.setPhone(uif.getPhone());
						uifUpdate.setPortrait("/pinMyLife/imgFromUplaod/"+uif.getUserId()+"/portrait/"+comfFile.getName());
						uifUpdate.setSignature(uif.getSignature());
						String isUifUpdate = uifif.userInfoUpdata(uifUpdate);
						if(isUifUpdate=="Success"){
							session.put("portrait", uifUpdate.getPortrait());
							JSONObject jsonObj = new JSONObject();
							jsonObj.put("portrait", uifUpdate.getPortrait());
							ActionContext.getContext().put("data", jsonObj);
							return "success";
						}else{
							JSONObject jsonObj = new JSONObject();
							jsonObj.put("error03", "服务器保存头像失败！");
							ActionContext.getContext().put("data", jsonObj);
							return "success";
						}
					}else{
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("error02", "上传文件失败！");
						ActionContext.getContext().put("data", jsonObj);
						return "success";
					}
				}else{
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("error02", "上传文件失败！");
					ActionContext.getContext().put("data", jsonObj);
					return "success";
				}
			}
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
	public File clearFile(File f) {
		File fs[] = f.getParentFile().listFiles();
		int fileNum = f.getParentFile().list().length;
		for(int i = 0;i<fileNum;i++){
			if(fs[i].isDirectory()){
				clearFile(fs[i]);
			}else{
				fs[i].delete();
			}
		}
		return null;
	}
}
