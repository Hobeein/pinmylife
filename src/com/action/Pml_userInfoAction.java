package com.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Picture;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.PictureServicesImp;
import com.services.PictureServicesInterface;
import com.services.UserInfoServicesImp;
import com.services.UserInfoServicesInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Pml_userInfoAction extends ActionSupport {
	
	
	public String userInfoFB(){
		Map session = ServletActionContext.getContext().getSession();
		PictureServicesInterface picif = new PictureServicesImp();
		Integer userId = (Integer) session.get("userId");
		JSONArray jsonArr = new JSONArray();
		if(userId==null||userId.equals("")){
			/*HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("error", "ÓÃ»§ÉÐÎ´µÇÂ¼£¬ÇëµÇÂ¼ÔÙÊÔ¡£");*/
			JSONObject ObjJson = new JSONObject();
			ObjJson.put("error", "error");
			jsonArr.add(ObjJson);
			ActionContext.getContext().put("data", jsonArr);
			return "success";
		}else{
			List piclist = picif.queryPictureById(userId);
			for(Iterator iter = piclist.iterator();iter.hasNext();){
				JSONObject jsonObj = new JSONObject();
				Picture pic = (Picture) iter.next();
				if(pic.getPictureId()!=null){
					jsonObj.put("pictureId", pic.getPictureId());
					jsonObj.put("userId", pic.getUserInfo().getUserId());
					jsonObj.put("piclink", pic.getPiclink());
					jsonObj.put("bewrite", pic.getBewrite());
					jsonObj.put("uploaddate", pic.getUploaddate());
					jsonObj.put("picvisitable", pic.getPicvisitable());
					jsonObj.put("likes", pic.getLikes());
					jsonArr.add(jsonObj);
				}
			}
			ActionContext.getContext().put("data", jsonArr);
			return "success";
		}
	}
}
