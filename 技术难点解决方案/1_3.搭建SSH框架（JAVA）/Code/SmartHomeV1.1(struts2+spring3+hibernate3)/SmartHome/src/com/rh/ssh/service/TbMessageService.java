package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbMessage;
import com.rh.ssh.utils.PageModel;

public interface TbMessageService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbMessage tbMessage, Map<String, Object> param) throws Exception;

	void delete(TbMessage tbMessage, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbMessage tbMessage, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbMessage> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbMessage> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbMessage> list, Map<String, Object> param) throws Exception;

	TbMessage get(TbMessage tbMessage, Map<String, Object> param) throws Exception;
	
	List<TbMessage> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbMessage> conditionSelectAll(TbMessage tbMessage, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbMessage tbMessage, Map<String, Object> param) throws Exception;
}