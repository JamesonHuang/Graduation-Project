package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbTask;
import com.rh.ssh.utils.PageModel;

public interface TbTaskService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbTask tbTask, Map<String, Object> param) throws Exception;

	void delete(TbTask tbTask, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbTask tbTask, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbTask> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbTask> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbTask> list, Map<String, Object> param) throws Exception;

	TbTask get(TbTask tbTask, Map<String, Object> param) throws Exception;
	
	List<TbTask> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbTask> conditionSelectAll(TbTask tbTask, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbTask tbTask, Map<String, Object> param) throws Exception;
}