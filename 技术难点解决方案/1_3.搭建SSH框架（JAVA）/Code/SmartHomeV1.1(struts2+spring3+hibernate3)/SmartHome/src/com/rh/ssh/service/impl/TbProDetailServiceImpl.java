package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbProDetail;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbProDetailService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbProDetailServiceImpl implements TbProDetailService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		dao.add(tbProDetail);
	}

	@Override
	public void delete(TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		dao.delete(tbProDetail);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		dao.update(tbProDetail);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbProDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbProDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbProDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbProDetail get(TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		return (TbProDetail) dao.get(TbProDetail.class, tbProDetail.getProDetailId());
	}

	@Override
	public List<TbProDetail> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbProDetail";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbProDetail> conditionSelectAll(TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbProDetail tbProDetail where 1=1 ");

		if (StringTools.notEmpty(tbProDetail.getProDetailId())) {
			hql.append("and tbProDetail.proDetailId = :tbProDetail_proDetailId ");
			paramMap.put("tbProDetail_proDetailId", tbProDetail.getProDetailId());
		}

		if (StringTools.trimNotEmpty(tbProDetail.getProDetailFromTask())) {
			hql.append("and tbProDetail.proDetailFromTask like :tbProDetail_proDetailFromTask ");
			paramMap.put("tbProDetail_proDetailFromTask", "%" + tbProDetail.getProDetailFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbProDetail.getProDetailCon())) {
			hql.append("and tbProDetail.proDetailCon like :tbProDetail_proDetailCon ");
			paramMap.put("tbProDetail_proDetailCon", "%" + tbProDetail.getProDetailCon().trim() + "%");
		}

		List<TbProDetail> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbProDetail tbProDetail, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbProDetail tbProDetail where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbProDetail tbProDetail where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbProDetail.getProDetailId())) {
			condition.append("and tbProDetail.proDetailId = :tbProDetail_proDetailId ");
			paramMap.put("tbProDetail_proDetailId", tbProDetail.getProDetailId());
		}

		if (StringTools.trimNotEmpty(tbProDetail.getProDetailFromTask())) {
			condition.append("and tbProDetail.proDetailFromTask like :tbProDetail_proDetailFromTask ");
			paramMap.put("tbProDetail_proDetailFromTask", "%" + tbProDetail.getProDetailFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbProDetail.getProDetailCon())) {
			condition.append("and tbProDetail.proDetailCon like :tbProDetail_proDetailCon ");
			paramMap.put("tbProDetail_proDetailCon", "%" + tbProDetail.getProDetailCon().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbProDetail> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}