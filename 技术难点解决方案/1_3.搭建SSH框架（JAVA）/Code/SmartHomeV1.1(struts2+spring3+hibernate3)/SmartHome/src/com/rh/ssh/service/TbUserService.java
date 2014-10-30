package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbUser;
import com.rh.ssh.utils.PageModel;

public interface TbUserService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbUser tbUser, Map<String, Object> param) throws Exception;

	void delete(TbUser tbUser, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbUser tbUser, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbUser> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbUser> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbUser> list, Map<String, Object> param) throws Exception;

	TbUser get(TbUser tbUser, Map<String, Object> param) throws Exception;
	
	List<TbUser> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbUser> conditionSelectAll(TbUser tbUser, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbUser tbUser, Map<String, Object> param) throws Exception;
}