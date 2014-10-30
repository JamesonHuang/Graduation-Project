package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.BgInfotype;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.BgInfotypeService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class BgInfotypeServiceImpl implements BgInfotypeService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		dao.add(bgInfotype);
	}

	@Override
	public void delete(BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		dao.delete(bgInfotype);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		dao.update(bgInfotype);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<BgInfotype> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<BgInfotype> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<BgInfotype> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public BgInfotype get(BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		return (BgInfotype) dao.get(BgInfotype.class, bgInfotype.getInfoTypeId());
	}

	@Override
	public List<BgInfotype> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from BgInfotype";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<BgInfotype> conditionSelectAll(BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from BgInfotype bgInfotype where 1=1 ");

		if (StringTools.notEmpty(bgInfotype.getInfoTypeId())) {
			hql.append("and bgInfotype.infoTypeId = :bgInfotype_infoTypeId ");
			paramMap.put("bgInfotype_infoTypeId", bgInfotype.getInfoTypeId());
		}

		if (StringTools.trimNotEmpty(bgInfotype.getInfoTypeName())) {
			hql.append("and bgInfotype.infoTypeName like :bgInfotype_infoTypeName ");
			paramMap.put("bgInfotype_infoTypeName", "%" + bgInfotype.getInfoTypeName().trim() + "%");
		}

		List<BgInfotype> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, BgInfotype bgInfotype, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from BgInfotype bgInfotype where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from BgInfotype bgInfotype where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(bgInfotype.getInfoTypeId())) {
			condition.append("and bgInfotype.infoTypeId = :bgInfotype_infoTypeId ");
			paramMap.put("bgInfotype_infoTypeId", bgInfotype.getInfoTypeId());
		}

		if (StringTools.trimNotEmpty(bgInfotype.getInfoTypeName())) {
			condition.append("and bgInfotype.infoTypeName like :bgInfotype_infoTypeName ");
			paramMap.put("bgInfotype_infoTypeName", "%" + bgInfotype.getInfoTypeName().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<BgInfotype> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}