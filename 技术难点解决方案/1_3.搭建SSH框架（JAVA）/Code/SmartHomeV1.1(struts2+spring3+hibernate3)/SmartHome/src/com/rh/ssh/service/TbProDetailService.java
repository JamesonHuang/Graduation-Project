package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbProDetail;
import com.rh.ssh.utils.PageModel;

public interface TbProDetailService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbProDetail tbProDetail, Map<String, Object> param) throws Exception;

	void delete(TbProDetail tbProDetail, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbProDetail tbProDetail, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbProDetail> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbProDetail> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbProDetail> list, Map<String, Object> param) throws Exception;

	TbProDetail get(TbProDetail tbProDetail, Map<String, Object> param) throws Exception;
	
	List<TbProDetail> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbProDetail> conditionSelectAll(TbProDetail tbProDetail, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbProDetail tbProDetail, Map<String, Object> param) throws Exception;
}