package com.rh.ssh.action;

import java.util.List;
import com.rh.ssh.model.BgInfotype;
import com.rh.ssh.service.BgInfotypeService;
import com.rh.ssh.utils.PageModel;

public class BgInfotypeAction extends BaseAction {

	private BgInfotypeService service;
	private BgInfotype bgInfotype;
	private List<BgInfotype> list;
	private PageModel pageModel;
	
	public String initAdd() {
		try {
			service.initAdd(null);
		} catch (Exception e) {
			return ERROR;
		}
		return "initAdd";
	}

	public String add() {
		try {
			service.add(bgInfotype, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			service.delete(bgInfotype, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initUpdate() {
		try {
			bgInfotype = service.get(bgInfotype, null);
			request.setAttribute("bgInfotype", bgInfotype);
		} catch (Exception e) {
			return ERROR;
		}
		return "initUpdate";
	}

	public String update() {
		try {
			service.update(bgInfotype, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initAddAll() {
		try {
			service.initAddAll(null);
		} catch (Exception e) {
			return ERROR;
		}
		return "initAddAll";
	}

	public String addAll() {
		try {
			service.addAll(list, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String deleteAll() {
		try {
			service.deleteAll(list, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initMergeAll() {
		try {
			list = service.selectAll(null);
			request.setAttribute("list", list);
		} catch (Exception e) {
			return ERROR;
		}
		return "initMergeAll";
	}

	public String mergeAll() {
		try {
			service.mergeAll(list, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String selectAll() {
		try {
			list = service.selectAll(null);
			request.setAttribute("list", list);
		} catch (Exception e) {
			return ERROR;
		}
		return "selectAll";
	}

	public String initConditionSelectAll() {
		try {
			service.initConditionSelectAll(null);
		} catch (Exception e) {
			return ERROR;
		}
		return "conditionSelectAll";
	}

	public String conditionSelectAll() {
		try {
			list = service.conditionSelectAll(bgInfotype, null);
			request.setAttribute("list", list);
			request.setAttribute("bgInfotype", bgInfotype);
		} catch (Exception e) {
			return ERROR;
		}
		return "conditionSelectAll";
	}

	public String initPageQuery() {
		try {
			service.initPageQuery(null);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}

	public String pageQuery() {
		try {
			pageModel = service.pageQuery(pageModel, bgInfotype, null);
			request.setAttribute("bgInfotype", bgInfotype);
			request.setAttribute("pageModel", pageModel);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}
	
	public void setService(BgInfotypeService service) {
		this.service = service;
	}
	
	public BgInfotype getBgInfotype() {
		return bgInfotype;
	}

	public void setBgInfotype(BgInfotype bgInfotype) {
		this.bgInfotype = bgInfotype;
	}
	
	public List<BgInfotype> getList() {
		return list;
	}

	public void setList(List<BgInfotype> list) {
		this.list = list;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
}