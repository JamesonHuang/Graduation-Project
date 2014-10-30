package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.BgInfo;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.BgInfoService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class BgInfoServiceImpl implements BgInfoService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(BgInfo bgInfo, Map<String, Object> param) throws Exception {
		dao.add(bgInfo);
	}

	@Override
	public void delete(BgInfo bgInfo, Map<String, Object> param) throws Exception {
		dao.delete(bgInfo);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(BgInfo bgInfo, Map<String, Object> param) throws Exception {
		dao.update(bgInfo);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<BgInfo> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<BgInfo> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<BgInfo> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public BgInfo get(BgInfo bgInfo, Map<String, Object> param) throws Exception {
		return (BgInfo) dao.get(BgInfo.class, bgInfo.getInfoId());
	}

	@Override
	public List<BgInfo> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from BgInfo";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<BgInfo> conditionSelectAll(BgInfo bgInfo, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from BgInfo bgInfo where 1=1 ");

		if (StringTools.notEmpty(bgInfo.getInfoId())) {
			hql.append("and bgInfo.infoId = :bgInfo_infoId ");
			paramMap.put("bgInfo_infoId", bgInfo.getInfoId());
		}

		if (StringTools.notEmpty(bgInfo.getAdminId())) {
			hql.append("and bgInfo.adminId = :bgInfo_adminId ");
			paramMap.put("bgInfo_adminId", bgInfo.getAdminId());
		}

		if (StringTools.notEmpty(bgInfo.getInfoTypeId())) {
			hql.append("and bgInfo.infoTypeId = :bgInfo_infoTypeId ");
			paramMap.put("bgInfo_infoTypeId", bgInfo.getInfoTypeId());
		}

		if (StringTools.trimNotEmpty(bgInfo.getInfoCon())) {
			hql.append("and bgInfo.infoCon like :bgInfo_infoCon ");
			paramMap.put("bgInfo_infoCon", "%" + bgInfo.getInfoCon().trim() + "%");
		}

		if (StringTools.trimNotEmpty(bgInfo.getInfoTitle())) {
			hql.append("and bgInfo.infoTitle like :bgInfo_infoTitle ");
			paramMap.put("bgInfo_infoTitle", "%" + bgInfo.getInfoTitle().trim() + "%");
		}

		if (StringTools.notEmpty(bgInfo.getInfoDateBegin()) && StringTools.notEmpty(bgInfo.getInfoDateEnd())) {
			hql.append("and bgInfo.infoDate >= :bgInfo_infoDateBegin ");
			hql.append("and bgInfo.infoDate <= :bgInfo_infoDateEnd ");
			paramMap.put("bgInfo_infoDateBegin", bgInfo.getInfoDateBegin());
			paramMap.put("bgInfo_infoDateEnd", bgInfo.getInfoDateEnd());
		}

		if (StringTools.notEmpty(bgInfo.getInfoHits())) {
			hql.append("and bgInfo.infoHits = :bgInfo_infoHits ");
			paramMap.put("bgInfo_infoHits", bgInfo.getInfoHits());
		}

		List<BgInfo> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, BgInfo bgInfo, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from BgInfo bgInfo where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from BgInfo bgInfo where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(bgInfo.getInfoId())) {
			condition.append("and bgInfo.infoId = :bgInfo_infoId ");
			paramMap.put("bgInfo_infoId", bgInfo.getInfoId());
		}

		if (StringTools.notEmpty(bgInfo.getAdminId())) {
			condition.append("and bgInfo.adminId = :bgInfo_adminId ");
			paramMap.put("bgInfo_adminId", bgInfo.getAdminId());
		}

		if (StringTools.notEmpty(bgInfo.getInfoTypeId())) {
			condition.append("and bgInfo.infoTypeId = :bgInfo_infoTypeId ");
			paramMap.put("bgInfo_infoTypeId", bgInfo.getInfoTypeId());
		}

		if (StringTools.trimNotEmpty(bgInfo.getInfoCon())) {
			condition.append("and bgInfo.infoCon like :bgInfo_infoCon ");
			paramMap.put("bgInfo_infoCon", "%" + bgInfo.getInfoCon().trim() + "%");
		}

		if (StringTools.trimNotEmpty(bgInfo.getInfoTitle())) {
			condition.append("and bgInfo.infoTitle like :bgInfo_infoTitle ");
			paramMap.put("bgInfo_infoTitle", "%" + bgInfo.getInfoTitle().trim() + "%");
		}

		if (StringTools.notEmpty(bgInfo.getInfoDateBegin()) && StringTools.notEmpty(bgInfo.getInfoDateEnd())) {
			condition.append("and bgInfo.infoDate >= :bgInfo_infoDateBegin ");
			condition.append("and bgInfo.infoDate <= :bgInfo_infoDateEnd ");
			paramMap.put("bgInfo_infoDateBegin", bgInfo.getInfoDateBegin());
			paramMap.put("bgInfo_infoDateEnd", bgInfo.getInfoDateEnd());
		}

		if (StringTools.notEmpty(bgInfo.getInfoHits())) {
			condition.append("and bgInfo.infoHits = :bgInfo_infoHits ");
			paramMap.put("bgInfo_infoHits", bgInfo.getInfoHits());
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<BgInfo> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}