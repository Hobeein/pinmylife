package com.domain;

/**
 * UserFollow entity. @author MyEclipse Persistence Tools
 */

public class UserFollow implements java.io.Serializable {

	// Fields

	private Integer followId;
	private UserInfo userInfo;
	private String followingUsername;

	// Constructors

	/** default constructor */
	public UserFollow() {
	}

	/** full constructor */
	public UserFollow(Integer followId, UserInfo userInfo, String followingUsername) {
		this.followId = followId;
		this.userInfo = userInfo;
		this.followingUsername = followingUsername;
	}

	// Property accessors

	public Integer getFollowId() {
		return this.followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getFollowingUsername() {
		return this.followingUsername;
	}

	public void setFollowingUsername(String followingUsername) {
		this.followingUsername = followingUsername;
	}

}