package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbUser;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbUserService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbUserServiceImpl implements TbUserService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbUser tbUser, Map<String, Object> param) throws Exception {
		dao.add(tbUser);
	}

	@Override
	public void delete(TbUser tbUser, Map<String, Object> param) throws Exception {
		dao.delete(tbUser);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbUser tbUser, Map<String, Object> param) throws Exception {
		dao.update(tbUser);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbUser> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbUser> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbUser> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbUser get(TbUser tbUser, Map<String, Object> param) throws Exception {
		return (TbUser) dao.get(TbUser.class, tbUser.getUserId());
	}

	@Override
	public List<TbUser> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbUser";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbUser> conditionSelectAll(TbUser tbUser, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbUser tbUser where 1=1 ");

		if (StringTools.notEmpty(tbUser.getUserId())) {
			hql.append("and tbUser.userId = :tbUser_userId ");
			paramMap.put("tbUser_userId", tbUser.getUserId());
		}

		if (StringTools.trimNotEmpty(tbUser.getUserName())) {
			hql.append("and tbUser.userName like :tbUser_userName ");
			paramMap.put("tbUser_userName", "%" + tbUser.getUserName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbUser.getUserPwd())) {
			hql.append("and tbUser.userPwd like :tbUser_userPwd ");
			paramMap.put("tbUser_userPwd", "%" + tbUser.getUserPwd().trim() + "%");
		}

		if (StringTools.notEmpty(tbUser.getWeiboKey())) {
			hql.append("and tbUser.weiboKey = :tbUser_weiboKey ");
			paramMap.put("tbUser_weiboKey", tbUser.getWeiboKey());
		}

		if (StringTools.notEmpty(tbUser.getQqKey())) {
			hql.append("and tbUser.qqKey = :tbUser_qqKey ");
			paramMap.put("tbUser_qqKey", tbUser.getQqKey());
		}

		if (StringTools.trimNotEmpty(tbUser.getUserImg())) {
			hql.append("and tbUser.userImg like :tbUser_userImg ");
			paramMap.put("tbUser_userImg", "%" + tbUser.getUserImg().trim() + "%");
		}

		List<TbUser> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbUser tbUser, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbUser tbUser where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbUser tbUser where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbUser.getUserId())) {
			condition.append("and tbUser.userId = :tbUser_userId ");
			paramMap.put("tbUser_userId", tbUser.getUserId());
		}

		if (StringTools.trimNotEmpty(tbUser.getUserName())) {
			condition.append("and tbUser.userName like :tbUser_userName ");
			paramMap.put("tbUser_userName", "%" + tbUser.getUserName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbUser.getUserPwd())) {
			condition.append("and tbUser.userPwd like :tbUser_userPwd ");
			paramMap.put("tbUser_userPwd", "%" + tbUser.getUserPwd().trim() + "%");
		}

		if (StringTools.notEmpty(tbUser.getWeiboKey())) {
			condition.append("and tbUser.weiboKey = :tbUser_weiboKey ");
			paramMap.put("tbUser_weiboKey", tbUser.getWeiboKey());
		}

		if (StringTools.notEmpty(tbUser.getQqKey())) {
			condition.append("and tbUser.qqKey = :tbUser_qqKey ");
			paramMap.put("tbUser_qqKey", tbUser.getQqKey());
		}

		if (StringTools.trimNotEmpty(tbUser.getUserImg())) {
			condition.append("and tbUser.userImg like :tbUser_userImg ");
			paramMap.put("tbUser_userImg", "%" + tbUser.getUserImg().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbUser> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}