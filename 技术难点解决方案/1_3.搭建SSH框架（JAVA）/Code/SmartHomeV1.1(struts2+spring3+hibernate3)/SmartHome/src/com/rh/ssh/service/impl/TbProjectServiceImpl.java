package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbProject;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbProjectService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbProjectServiceImpl implements TbProjectService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbProject tbProject, Map<String, Object> param) throws Exception {
		dao.add(tbProject);
	}

	@Override
	public void delete(TbProject tbProject, Map<String, Object> param) throws Exception {
		dao.delete(tbProject);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbProject tbProject, Map<String, Object> param) throws Exception {
		dao.update(tbProject);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbProject> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbProject> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbProject> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbProject get(TbProject tbProject, Map<String, Object> param) throws Exception {
		return (TbProject) dao.get(TbProject.class, tbProject.getProId());
	}

	@Override
	public List<TbProject> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbProject";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbProject> conditionSelectAll(TbProject tbProject, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbProject tbProject where 1=1 ");

		if (StringTools.notEmpty(tbProject.getProId())) {
			hql.append("and tbProject.proId = :tbProject_proId ");
			paramMap.put("tbProject_proId", tbProject.getProId());
		}

		if (StringTools.trimNotEmpty(tbProject.getProName())) {
			hql.append("and tbProject.proName like :tbProject_proName ");
			paramMap.put("tbProject_proName", "%" + tbProject.getProName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbProject.getProIntro())) {
			hql.append("and tbProject.proIntro like :tbProject_proIntro ");
			paramMap.put("tbProject_proIntro", "%" + tbProject.getProIntro().trim() + "%");
		}

		if (StringTools.notEmpty(tbProject.getUserId())) {
			hql.append("and tbProject.userId = :tbProject_userId ");
			paramMap.put("tbProject_userId", tbProject.getUserId());
		}

		List<TbProject> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbProject tbProject, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbProject tbProject where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbProject tbProject where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbProject.getProId())) {
			condition.append("and tbProject.proId = :tbProject_proId ");
			paramMap.put("tbProject_proId", tbProject.getProId());
		}

		if (StringTools.trimNotEmpty(tbProject.getProName())) {
			condition.append("and tbProject.proName like :tbProject_proName ");
			paramMap.put("tbProject_proName", "%" + tbProject.getProName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbProject.getProIntro())) {
			condition.append("and tbProject.proIntro like :tbProject_proIntro ");
			paramMap.put("tbProject_proIntro", "%" + tbProject.getProIntro().trim() + "%");
		}

		if (StringTools.notEmpty(tbProject.getUserId())) {
			condition.append("and tbProject.userId = :tbProject_userId ");
			paramMap.put("tbProject_userId", tbProject.getUserId());
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbProject> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}