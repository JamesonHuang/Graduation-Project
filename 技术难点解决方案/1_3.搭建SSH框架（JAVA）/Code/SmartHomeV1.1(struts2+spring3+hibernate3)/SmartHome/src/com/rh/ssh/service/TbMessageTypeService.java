package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbMessageType;
import com.rh.ssh.utils.PageModel;

public interface TbMessageTypeService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbMessageType tbMessageType, Map<String, Object> param) throws Exception;

	void delete(TbMessageType tbMessageType, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbMessageType tbMessageType, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbMessageType> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbMessageType> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbMessageType> list, Map<String, Object> param) throws Exception;

	TbMessageType get(TbMessageType tbMessageType, Map<String, Object> param) throws Exception;
	
	List<TbMessageType> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbMessageType> conditionSelectAll(TbMessageType tbMessageType, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbMessageType tbMessageType, Map<String, Object> param) throws Exception;
}