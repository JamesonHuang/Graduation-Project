package com.rh.ssh.model;

import java.io.Serializable;

public class TbUser implements Serializable {

	private Integer userId; // userId
	private String userName; // userName
	private String userPwd; // userPwd
	private Integer weiboKey; // weiboKey
	private Integer qqKey; // qqKey
	private String userImg; // userImg

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getWeiboKey() {
		return weiboKey;
	}

	public void setWeiboKey(Integer weiboKey) {
		this.weiboKey = weiboKey;
	}

	public Integer getQqKey() {
		return qqKey;
	}

	public void setQqKey(Integer qqKey) {
		this.qqKey = qqKey;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
}