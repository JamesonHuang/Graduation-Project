package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbTaskDetail;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbTaskDetailService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbTaskDetailServiceImpl implements TbTaskDetailService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		dao.add(tbTaskDetail);
	}

	@Override
	public void delete(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		dao.delete(tbTaskDetail);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		dao.update(tbTaskDetail);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbTaskDetail> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbTaskDetail get(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		return (TbTaskDetail) dao.get(TbTaskDetail.class, tbTaskDetail.getTaskDetailId());
	}

	@Override
	public List<TbTaskDetail> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbTaskDetail";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbTaskDetail> conditionSelectAll(TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbTaskDetail tbTaskDetail where 1=1 ");

		if (StringTools.notEmpty(tbTaskDetail.getTaskDetailId())) {
			hql.append("and tbTaskDetail.taskDetailId = :tbTaskDetail_taskDetailId ");
			paramMap.put("tbTaskDetail_taskDetailId", tbTaskDetail.getTaskDetailId());
		}

		if (StringTools.trimNotEmpty(tbTaskDetail.getTaskDetailFromTask())) {
			hql.append("and tbTaskDetail.taskDetailFromTask like :tbTaskDetail_taskDetailFromTask ");
			paramMap.put("tbTaskDetail_taskDetailFromTask", "%" + tbTaskDetail.getTaskDetailFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTaskDetail.getTaskDetailCon())) {
			hql.append("and tbTaskDetail.taskDetailCon like :tbTaskDetail_taskDetailCon ");
			paramMap.put("tbTaskDetail_taskDetailCon", "%" + tbTaskDetail.getTaskDetailCon().trim() + "%");
		}

		List<TbTaskDetail> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbTaskDetail tbTaskDetail, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbTaskDetail tbTaskDetail where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbTaskDetail tbTaskDetail where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbTaskDetail.getTaskDetailId())) {
			condition.append("and tbTaskDetail.taskDetailId = :tbTaskDetail_taskDetailId ");
			paramMap.put("tbTaskDetail_taskDetailId", tbTaskDetail.getTaskDetailId());
		}

		if (StringTools.trimNotEmpty(tbTaskDetail.getTaskDetailFromTask())) {
			condition.append("and tbTaskDetail.taskDetailFromTask like :tbTaskDetail_taskDetailFromTask ");
			paramMap.put("tbTaskDetail_taskDetailFromTask", "%" + tbTaskDetail.getTaskDetailFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTaskDetail.getTaskDetailCon())) {
			condition.append("and tbTaskDetail.taskDetailCon like :tbTaskDetail_taskDetailCon ");
			paramMap.put("tbTaskDetail_taskDetailCon", "%" + tbTaskDetail.getTaskDetailCon().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbTaskDetail> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}