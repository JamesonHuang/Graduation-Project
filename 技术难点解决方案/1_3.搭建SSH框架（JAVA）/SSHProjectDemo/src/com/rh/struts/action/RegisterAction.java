/**  
* @Title: 		RegisterAction.java
* @Package: 		com.rh.struts.action
* @Description: 	TODO(用一句话描述该文件做什么)
* @author: 		rh_Jameson  
* @date:			2014年10月15日 上午11:33:57
*
*/ 
package com.rh.struts.action;  

import com.opensymphony.xwork2.ActionSupport;  
import com.rh.struts.forms.UserForm;
import com.rh.struts.service.UserManager;  
import com.rh.struts.serviceImpl.UserManagerImpl;  
  
public class RegisterAction extends ActionSupport {  
  
    private static final long serialVersionUID = 1L;  
  
    private UserForm user;  
  
    private UserManager userManager;  
  
    public UserForm getUser() {  
        return user;  
    }  
  
    public void setUser(UserForm user) {  
        this.user = user;  
    }  
  
    public UserManager getUserManager() {  
        return userManager;  
    }  
  
    public void setUserManager(UserManager userManager) {  
        this.userManager = userManager;  
    }  
  
    public String execute() {  
        try {  
            this.setUserManager(new UserManagerImpl());  
            userManager.regUser(user);  
            return SUCCESS;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }  
  
}  
