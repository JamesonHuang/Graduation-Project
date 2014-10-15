package com.rh.hibernate.dao;
import org.hibernate.HibernateException;  
import org.hibernate.Session;  
  
public interface BaseDao {  
  
    public void saveObject(Object obj) throws HibernateException;  
  
    public Session getSession();  
  
    public void setSession(Session session);  
}  