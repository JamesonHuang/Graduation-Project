/**  
* @Title: 		UserManagerImpl.java
* @Package: 		com.rh.struts.serviceImpl
* @Description: 	TODO(用一句话描述该文件做什么)
* @author: 		rh_Jameson  
* @date:			2014年10月15日 上午11:39:29
*
*/ 
package com.rh.struts.serviceImpl;

import org.hibernate.HibernateException;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
  
import com.rh.hibernate.beans.User;  
import com.rh.hibernate.dao.BaseDao;  
import com.rh.hibernate.daoImpl.HibernateSessionFactory;  
import com.rh.hibernate.daoImpl.UserDao;  
import com.rh.struts.forms.UserForm;  
import com.rh.struts.service.UserManager;  
  
public class UserManagerImpl implements UserManager {  
  
    private BaseDao dao;  
  
    private Session session;  
  
    public UserManagerImpl() {  
        dao = new UserDao();  
    }  
  
    @Override  
    public void regUser(UserForm userForm) throws HibernateException {  
        session = HibernateSessionFactory.currentSession();  
        dao.setSession(session);  
        // 获取事务  
        Transaction ts = session.beginTransaction();  
        // 构造User对象  
        User user = new User();  
        user.setUsername(userForm.getUsername());  
        user.setPassword(userForm.getPassword());  
        user.setGender(userForm.getGender());  
        // 保存User对象  
        dao.saveObject(user);  
        // 提交事务  
        ts.commit();  
        // 关闭Session  
        HibernateSessionFactory.closeSession();  
    }  
  
} 
