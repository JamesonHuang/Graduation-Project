package com.rh.ssh.service;

import java.util.List;
import java.util.Map;
import com.rh.ssh.model.TbDevice;
import com.rh.ssh.utils.PageModel;

public interface TbDeviceService {
	
	Map<String, Object> initAdd(Map<String, Object> param) throws Exception;

	void add(TbDevice tbDevice, Map<String, Object> param) throws Exception;

	void delete(TbDevice tbDevice, Map<String, Object> param) throws Exception;

	Map<String, Object> initUpdate(Map<String, Object> param) throws Exception;

	void update(TbDevice tbDevice, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initAddAll(Map<String, Object> param) throws Exception;

	void addAll(List<TbDevice> list, Map<String, Object> param) throws Exception;
	
	void deleteAll(List<TbDevice> list, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception;
	
	void mergeAll(List<TbDevice> list, Map<String, Object> param) throws Exception;

	TbDevice get(TbDevice tbDevice, Map<String, Object> param) throws Exception;
	
	List<TbDevice> selectAll(Map<String, Object> param) throws Exception;
	
	Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception;
	
	List<TbDevice> conditionSelectAll(TbDevice tbDevice, Map<String, Object> param) throws Exception;
	
	Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception;
	
	PageModel pageQuery(PageModel pageModel, TbDevice tbDevice, Map<String, Object> param) throws Exception;
}