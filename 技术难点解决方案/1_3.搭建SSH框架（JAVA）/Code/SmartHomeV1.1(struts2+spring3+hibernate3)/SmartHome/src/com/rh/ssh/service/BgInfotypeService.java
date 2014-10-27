package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.BgInfotype;
import com.rh.ssh.utils.PageModel;

public interface BgInfotypeService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(BgInfotype bgInfotype, Map<String, Object> param) throws Exception;

	void delete(BgInfotype bgInfotype, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(BgInfotype bgInfotype, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<BgInfotype> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<BgInfotype> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<BgInfotype> list, Map<String, Object> param) throws Exception;

	BgInfotype get(BgInfotype bgInfotype, Map<String, Object> param) throws Exception;
	
	List<BgInfotype> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<BgInfotype> conditionSelectAll(BgInfotype bgInfotype, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, BgInfotype bgInfotype, Map<String, Object> param) throws Exception;
}