package com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Picture entity. @author MyEclipse Persistence Tools
 */

public class Picture implements java.io.Serializable {

	// Fields

	private Integer pictureId;
	private UserInfo userInfo;
	private String piclink;
	private String bewrite;
	private String uploaddate;
	private String picvisitable;
	private Integer likes;
	private Set pictureCollects = new HashSet(0);

	// Constructors

	/** default constructor */
	public Picture() {
	}

	/** minimal constructor */
	public Picture(Integer pictureId, UserInfo userInfo, String piclink, String uploaddate) {
		this.pictureId = pictureId;
		this.userInfo = userInfo;
		this.piclink = piclink;
		this.uploaddate = uploaddate;
	}

	/** full constructor */
	public Picture(Integer pictureId, UserInfo userInfo, String piclink, String bewrite, String uploaddate,
			String picvisitable, Integer likes, Set pictureCollects) {
		this.pictureId = pictureId;
		this.userInfo = userInfo;
		this.piclink = piclink;
		this.bewrite = bewrite;
		this.uploaddate = uploaddate;
		this.picvisitable = picvisitable;
		this.likes = likes;
		this.pictureCollects = pictureCollects;
	}

	// Property accessors

	public Integer getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getPiclink() {
		return this.piclink;
	}

	public void setPiclink(String piclink) {
		this.piclink = piclink;
	}

	public String getBewrite() {
		return this.bewrite;
	}

	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}

	public String getUploaddate() {
		return this.uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getPicvisitable() {
		return this.picvisitable;
	}

	public void setPicvisitable(String picvisitable) {
		this.picvisitable = picvisitable;
	}

	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Set getPictureCollects() {
		return this.pictureCollects;
	}

	public void setPictureCollects(Set pictureCollects) {
		this.pictureCollects = pictureCollects;
	}

}