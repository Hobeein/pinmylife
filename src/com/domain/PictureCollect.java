package com.domain;

/**
 * PictureCollect entity. @author MyEclipse Persistence Tools
 */

public class PictureCollect implements java.io.Serializable {

	// Fields

	private Integer collectId;
	private Picture picture;
	private UserInfo userInfo;

	// Constructors

	/** default constructor */
	public PictureCollect() {
	}

	/** full constructor */
	public PictureCollect(Integer collectId, Picture picture, UserInfo userInfo) {
		this.collectId = collectId;
		this.picture = picture;
		this.userInfo = userInfo;
	}

	// Property accessors

	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}