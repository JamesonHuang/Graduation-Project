package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.BgInfoimg;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.BgInfoimgService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class BgInfoimgServiceImpl implements BgInfoimgService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		dao.add(bgInfoimg);
	}

	@Override
	public void delete(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		dao.delete(bgInfoimg);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		dao.update(bgInfoimg);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<BgInfoimg> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public BgInfoimg get(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		return (BgInfoimg) dao.get(BgInfoimg.class, bgInfoimg.getInfoImgId());
	}

	@Override
	public List<BgInfoimg> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from BgInfoimg";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<BgInfoimg> conditionSelectAll(BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from BgInfoimg bgInfoimg where 1=1 ");

		if (StringTools.notEmpty(bgInfoimg.getInfoImgId())) {
			hql.append("and bgInfoimg.infoImgId = :bgInfoimg_infoImgId ");
			paramMap.put("bgInfoimg_infoImgId", bgInfoimg.getInfoImgId());
		}

		if (StringTools.notEmpty(bgInfoimg.getInfoId())) {
			hql.append("and bgInfoimg.infoId = :bgInfoimg_infoId ");
			paramMap.put("bgInfoimg_infoId", bgInfoimg.getInfoId());
		}

		if (StringTools.trimNotEmpty(bgInfoimg.getInfoImgName())) {
			hql.append("and bgInfoimg.infoImgName like :bgInfoimg_infoImgName ");
			paramMap.put("bgInfoimg_infoImgName", "%" + bgInfoimg.getInfoImgName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(bgInfoimg.getInfoImgPath())) {
			hql.append("and bgInfoimg.infoImgPath like :bgInfoimg_infoImgPath ");
			paramMap.put("bgInfoimg_infoImgPath", "%" + bgInfoimg.getInfoImgPath().trim() + "%");
		}

		List<BgInfoimg> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, BgInfoimg bgInfoimg, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from BgInfoimg bgInfoimg where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from BgInfoimg bgInfoimg where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(bgInfoimg.getInfoImgId())) {
			condition.append("and bgInfoimg.infoImgId = :bgInfoimg_infoImgId ");
			paramMap.put("bgInfoimg_infoImgId", bgInfoimg.getInfoImgId());
		}

		if (StringTools.notEmpty(bgInfoimg.getInfoId())) {
			condition.append("and bgInfoimg.infoId = :bgInfoimg_infoId ");
			paramMap.put("bgInfoimg_infoId", bgInfoimg.getInfoId());
		}

		if (StringTools.trimNotEmpty(bgInfoimg.getInfoImgName())) {
			condition.append("and bgInfoimg.infoImgName like :bgInfoimg_infoImgName ");
			paramMap.put("bgInfoimg_infoImgName", "%" + bgInfoimg.getInfoImgName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(bgInfoimg.getInfoImgPath())) {
			condition.append("and bgInfoimg.infoImgPath like :bgInfoimg_infoImgPath ");
			paramMap.put("bgInfoimg_infoImgPath", "%" + bgInfoimg.getInfoImgPath().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<BgInfoimg> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}