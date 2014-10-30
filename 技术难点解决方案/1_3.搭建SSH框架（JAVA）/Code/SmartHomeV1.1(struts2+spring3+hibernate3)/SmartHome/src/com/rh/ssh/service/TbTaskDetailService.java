package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbTaskDetail;
import com.rh.ssh.utils.PageModel;

public interface TbTaskDetailService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;

	void delete(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception;

	TbTaskDetail get(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;
	
	List<TbTaskDetail> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbTaskDetail> conditionSelectAll(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception;
}