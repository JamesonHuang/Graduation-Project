package com.rh.ssh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DaoService {

	void add(Object obj) throws Exception;

	void delete(Object obj) throws Exception;

	void update(Object obj) throws Exception;

	void merge(Object obj) throws Exception;

	void addAll(List list) throws Exception;

	void updateAll(List list) throws Exception;

	void mergeAll(List list) throws Exception;

	void deleteAll(List list) throws Exception;

	Object get(Class entityClass, Serializable id) throws Exception;

	int executeHQL(String hql) throws Exception;

	int executeHQL(String hql, String param, Object value) throws Exception;

	int executeHQL(String hql, Map<String, Object> param) throws Exception;

	List find(String hql) throws Exception;

	List find(String hql, String param, Object value) throws Exception;

	List find(String hql, Map<String, Object> param) throws Exception;

	Object findFirst(String hql) throws Exception;

	Object findFirst(String hql, String param, Object value) throws Exception;

	Object findFirst(String hql, Map<String, Object> param) throws Exception;

	List findLimit(String hql, int first, int max) throws Exception;

	List findLimit(String hql, String param, Object value, int first, int max) throws Exception;

	List findLimit(String hql, Map<String, Object> param, int first, int max) throws Exception;

	Object findUnique(String hql) throws Exception;

	Object findUnique(String hql, String param, Object value) throws Exception;

	Object findUnique(String hql, Map<String, Object> param) throws Exception;

	int executeSQL(String sql) throws Exception;

	int executeSQL(String sql, String param, Object value) throws Exception;

	int executeSQL(String sql, Map<String, Object> param) throws Exception;

	List executeSQLQuery(String sql) throws Exception;

	List executeSQLQuery(String sql, String param, Object value) throws Exception;

	List executeSQLQuery(String sql, Map<String, Object> param) throws Exception;
}