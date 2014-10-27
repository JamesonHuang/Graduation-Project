package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbMessage;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbMessageService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbMessageServiceImpl implements TbMessageService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbMessage tbMessage, Map<String, Object> param) throws Exception {
		dao.add(tbMessage);
	}

	@Override
	public void delete(TbMessage tbMessage, Map<String, Object> param) throws Exception {
		dao.delete(tbMessage);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbMessage tbMessage, Map<String, Object> param) throws Exception {
		dao.update(tbMessage);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbMessage> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbMessage> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbMessage> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbMessage get(TbMessage tbMessage, Map<String, Object> param) throws Exception {
		return (TbMessage) dao.get(TbMessage.class, tbMessage.getMessageId());
	}

	@Override
	public List<TbMessage> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbMessage";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbMessage> conditionSelectAll(TbMessage tbMessage, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbMessage tbMessage where 1=1 ");

		if (StringTools.notEmpty(tbMessage.getMessageId())) {
			hql.append("and tbMessage.messageId = :tbMessage_messageId ");
			paramMap.put("tbMessage_messageId", tbMessage.getMessageId());
		}

		if (StringTools.notEmpty(tbMessage.getMessageTypeId())) {
			hql.append("and tbMessage.messageTypeId = :tbMessage_messageTypeId ");
			paramMap.put("tbMessage_messageTypeId", tbMessage.getMessageTypeId());
		}

		if (StringTools.trimNotEmpty(tbMessage.getMessageCon())) {
			hql.append("and tbMessage.messageCon like :tbMessage_messageCon ");
			paramMap.put("tbMessage_messageCon", "%" + tbMessage.getMessageCon().trim() + "%");
		}

		List<TbMessage> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbMessage tbMessage, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbMessage tbMessage where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbMessage tbMessage where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbMessage.getMessageId())) {
			condition.append("and tbMessage.messageId = :tbMessage_messageId ");
			paramMap.put("tbMessage_messageId", tbMessage.getMessageId());
		}

		if (StringTools.notEmpty(tbMessage.getMessageTypeId())) {
			condition.append("and tbMessage.messageTypeId = :tbMessage_messageTypeId ");
			paramMap.put("tbMessage_messageTypeId", tbMessage.getMessageTypeId());
		}

		if (StringTools.trimNotEmpty(tbMessage.getMessageCon())) {
			condition.append("and tbMessage.messageCon like :tbMessage_messageCon ");
			paramMap.put("tbMessage_messageCon", "%" + tbMessage.getMessageCon().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbMessage> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}