package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbProject;
import com.rh.ssh.utils.PageModel;

public interface TbProjectService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbProject tbProject, Map<String, Object> param) throws Exception;

	void delete(TbProject tbProject, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbProject tbProject, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbProject> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbProject> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbProject> list, Map<String, Object> param) throws Exception;

	TbProject get(TbProject tbProject, Map<String, Object> param) throws Exception;
	
	List<TbProject> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbProject> conditionSelectAll(TbProject tbProject, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbProject tbProject, Map<String, Object> param) throws Exception;
}