/**  
 * @Title: 		User.java
 * @Package: 		com.rh.hibernate.beans
 * @Description: 	TODO(用一句话描述该文件做什么)
 * @author: 		rh_Jameson  
 * @date:			2014年10月15日 下午2:37:04
 *
 */
package com.rh.hibernate.beans;

/**
 * @author rh
 *
 */
public class User {
	private String username;
	private String password;
	private int userId;
	private int gender;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
}
