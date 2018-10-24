package com.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

public class Pml_MainPageAction extends ActionSupport {
	private int firstRe;
	private int maxRe;
	
	
	public int getFirstRe() {
		return firstRe;
	}


	public void setFirstRe(int firstRe) {
		this.firstRe = firstRe;
	}


	public int getMaxRe() {
		return maxRe;
	}


	public void setMaxRe(int maxRe) {
		this.maxRe = maxRe;
	}


	public String mainPageFB() {
		PictureServicesInterface picif = new PictureServicesImp();
		UserInfoServicesInterface uisif = new UserInfoServicesImp();
		List list = picif.queryPictureForPage(getFirstRe(), getMaxRe());
		JSONArray dataArray = new JSONArray();
		for(Iterator iter=list.iterator();iter.hasNext();){
			JSONObject data = new JSONObject();
			Picture pic = (Picture) iter.next();
			if(pic.getPictureId()!=null){
				List userlist = uisif.userInfoQueryById(pic.getUserInfo().getUserId());
				UserInfo uif = (UserInfo) userlist.get(0);
				data.put("pictureId", pic.getPictureId());
				data.put("userId", pic.getUserInfo().getUserId());
				data.put("username", uif.getUsername());
				data.put("piclink", pic.getPiclink());
				data.put("bewrite", pic.getBewrite());
				data.put("uploaddate", pic.getUploaddate());
				data.put("picvisitable", pic.getPicvisitable());
				data.put("likes", pic.getLikes());
				dataArray.add(data);
			}
		}
		ActionContext.getContext().put("data", dataArray);
		return "Success";
	}
}
