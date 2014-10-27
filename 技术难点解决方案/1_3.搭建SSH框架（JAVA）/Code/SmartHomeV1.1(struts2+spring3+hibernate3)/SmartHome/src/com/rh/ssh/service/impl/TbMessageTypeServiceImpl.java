package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbMessageType;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbMessageTypeService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbMessageTypeServiceImpl implements TbMessageTypeService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		dao.add(tbMessageType);
	}

	@Override
	public void delete(TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		dao.delete(tbMessageType);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		dao.update(tbMessageType);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbMessageType> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbMessageType> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbMessageType> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbMessageType get(TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		return (TbMessageType) dao.get(TbMessageType.class, tbMessageType.getMessageTypeId());
	}

	@Override
	public List<TbMessageType> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbMessageType";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbMessageType> conditionSelectAll(TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbMessageType tbMessageType where 1=1 ");

		if (StringTools.notEmpty(tbMessageType.getMessageTypeId())) {
			hql.append("and tbMessageType.messageTypeId = :tbMessageType_messageTypeId ");
			paramMap.put("tbMessageType_messageTypeId", tbMessageType.getMessageTypeId());
		}

		if (StringTools.trimNotEmpty(tbMessageType.getMessageTypeName())) {
			hql.append("and tbMessageType.messageTypeName like :tbMessageType_messageTypeName ");
			paramMap.put("tbMessageType_messageTypeName", "%" + tbMessageType.getMessageTypeName().trim() + "%");
		}

		List<TbMessageType> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbMessageType tbMessageType, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbMessageType tbMessageType where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbMessageType tbMessageType where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbMessageType.getMessageTypeId())) {
			condition.append("and tbMessageType.messageTypeId = :tbMessageType_messageTypeId ");
			paramMap.put("tbMessageType_messageTypeId", tbMessageType.getMessageTypeId());
		}

		if (StringTools.trimNotEmpty(tbMessageType.getMessageTypeName())) {
			condition.append("and tbMessageType.messageTypeName like :tbMessageType_messageTypeName ");
			paramMap.put("tbMessageType_messageTypeName", "%" + tbMessageType.getMessageTypeName().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbMessageType> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}