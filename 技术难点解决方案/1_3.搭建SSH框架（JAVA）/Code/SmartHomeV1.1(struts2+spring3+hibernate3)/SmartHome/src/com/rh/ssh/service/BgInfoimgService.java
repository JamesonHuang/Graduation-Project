package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.BgInfoimg;
import com.rh.ssh.utils.PageModel;

public interface BgInfoimgService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;

	void delete(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception;

	BgInfoimg get(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;
	
	List<BgInfoimg> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<BgInfoimg> conditionSelectAll(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception;
}