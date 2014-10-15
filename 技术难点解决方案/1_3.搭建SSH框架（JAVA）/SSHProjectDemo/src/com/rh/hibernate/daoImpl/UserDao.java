package com.rh.hibernate.daoImpl;

import org.hibernate.HibernateException;  
import org.hibernate.Session;    
import com.rh.hibernate.dao.BaseDao;  
  
public class UserDao implements BaseDao {  
  
    private Session session;  
  
    @Override  
    public Session getSession() {  
        return session;  
    }  
  
    @Override  
    public void setSession(Session session) {  
        this.session = session;  
    }  
  
    @Override  
    public void saveObject(Object obj) throws HibernateException {  
        session.save(obj);  
    }  
  
}  