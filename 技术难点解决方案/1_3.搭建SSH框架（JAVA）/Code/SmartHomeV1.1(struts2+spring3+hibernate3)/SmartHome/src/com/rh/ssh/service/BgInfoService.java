package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.BgInfo;
import com.rh.ssh.utils.PageModel;

public interface BgInfoService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(BgInfo bgInfo, Map<String, Object> param) throws Exception;

	void delete(BgInfo bgInfo, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(BgInfo bgInfo, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<BgInfo> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<BgInfo> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<BgInfo> list, Map<String, Object> param) throws Exception;

	BgInfo get(BgInfo bgInfo, Map<String, Object> param) throws Exception;
	
	List<BgInfo> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<BgInfo> conditionSelectAll(BgInfo bgInfo, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, BgInfo bgInfo, Map<String, Object> param) throws Exception;
}