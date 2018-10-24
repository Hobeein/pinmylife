package com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private UserInfo userInfo;
	private String username;
	private String password;
	private String sex;
	private String sexvisitable;
	private String email;
	private String phone;
	private String signature;
	private String portrait;
	private Set pictures = new HashSet(0);
	private Set userInfos = new HashSet(0);
	private Set pictureCollects = new HashSet(0);
	private Set userFollows = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Integer userId, UserInfo userInfo, String password, String sex, String sexvisitable) {
		this.userId = userId;
		this.userInfo = userInfo;
		this.password = password;
		this.sex = sex;
		this.sexvisitable = sexvisitable;
	}

	/** full constructor */
	public UserInfo(Integer userId, UserInfo userInfo, String username, String password, String sex,
			String sexvisitable, String email, String phone, String signature, String portrait, Set pictures,
			Set userInfos, Set pictureCollects, Set userFollows) {
		this.userId = userId;
		this.userInfo = userInfo;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.sexvisitable = sexvisitable;
		this.email = email;
		this.phone = phone;
		this.signature = signature;
		this.portrait = portrait;
		this.pictures = pictures;
		this.userInfos = userInfos;
		this.pictureCollects = pictureCollects;
		this.userFollows = userFollows;
	}

	// Property accessors
	
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSexvisitable() {
		return this.sexvisitable;
	}

	public void setSexvisitable(String sexvisitable) {
		this.sexvisitable = sexvisitable;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPortrait() {
		return this.portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Set getPictures() {
		return this.pictures;
	}

	public void setPictures(Set pictures) {
		this.pictures = pictures;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

	public Set getPictureCollects() {
		return this.pictureCollects;
	}

	public void setPictureCollects(Set pictureCollects) {
		this.pictureCollects = pictureCollects;
	}

	public Set getUserFollows() {
		return this.userFollows;
	}

	public void setUserFollows(Set userFollows) {
		this.userFollows = userFollows;
	}

}