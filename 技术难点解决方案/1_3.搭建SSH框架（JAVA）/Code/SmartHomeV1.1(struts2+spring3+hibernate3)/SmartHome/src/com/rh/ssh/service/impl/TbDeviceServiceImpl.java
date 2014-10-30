package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbDevice;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbDeviceService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbDeviceServiceImpl implements TbDeviceService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbDevice tbDevice, Map<String, Object> param) throws Exception {
		dao.add(tbDevice);
	}

	@Override
	public void delete(TbDevice tbDevice, Map<String, Object> param) throws Exception {
		dao.delete(tbDevice);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbDevice tbDevice, Map<String, Object> param) throws Exception {
		dao.update(tbDevice);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbDevice> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbDevice> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbDevice> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbDevice get(TbDevice tbDevice, Map<String, Object> param) throws Exception {
		return (TbDevice) dao.get(TbDevice.class, tbDevice.getDeviceId());
	}

	@Override
	public List<TbDevice> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbDevice";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbDevice> conditionSelectAll(TbDevice tbDevice, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbDevice tbDevice where 1=1 ");

		if (StringTools.notEmpty(tbDevice.getDeviceId())) {
			hql.append("and tbDevice.deviceId = :tbDevice_deviceId ");
			paramMap.put("tbDevice_deviceId", tbDevice.getDeviceId());
		}

		if (StringTools.trimNotEmpty(tbDevice.getDeviceName())) {
			hql.append("and tbDevice.deviceName like :tbDevice_deviceName ");
			paramMap.put("tbDevice_deviceName", "%" + tbDevice.getDeviceName().trim() + "%");
		}

		if (StringTools.notEmpty(tbDevice.getUserId())) {
			hql.append("and tbDevice.userId = :tbDevice_userId ");
			paramMap.put("tbDevice_userId", tbDevice.getUserId());
		}

		if (StringTools.notEmpty(tbDevice.getDeviceKey())) {
			hql.append("and tbDevice.deviceKey = :tbDevice_deviceKey ");
			paramMap.put("tbDevice_deviceKey", tbDevice.getDeviceKey());
		}

		if (StringTools.notEmpty(tbDevice.getIsOnline())) {
			hql.append("and tbDevice.isOnline = :tbDevice_isOnline ");
			paramMap.put("tbDevice_isOnline", tbDevice.getIsOnline());
		}

		List<TbDevice> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbDevice tbDevice, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbDevice tbDevice where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbDevice tbDevice where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbDevice.getDeviceId())) {
			condition.append("and tbDevice.deviceId = :tbDevice_deviceId ");
			paramMap.put("tbDevice_deviceId", tbDevice.getDeviceId());
		}

		if (StringTools.trimNotEmpty(tbDevice.getDeviceName())) {
			condition.append("and tbDevice.deviceName like :tbDevice_deviceName ");
			paramMap.put("tbDevice_deviceName", "%" + tbDevice.getDeviceName().trim() + "%");
		}

		if (StringTools.notEmpty(tbDevice.getUserId())) {
			condition.append("and tbDevice.userId = :tbDevice_userId ");
			paramMap.put("tbDevice_userId", tbDevice.getUserId());
		}

		if (StringTools.notEmpty(tbDevice.getDeviceKey())) {
			condition.append("and tbDevice.deviceKey = :tbDevice_deviceKey ");
			paramMap.put("tbDevice_deviceKey", tbDevice.getDeviceKey());
		}

		if (StringTools.notEmpty(tbDevice.getIsOnline())) {
			condition.append("and tbDevice.isOnline = :tbDevice_isOnline ");
			paramMap.put("tbDevice_isOnline", tbDevice.getIsOnline());
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbDevice> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}