package com.rh.ssh.action;

import java.util.List;
import com.rh.ssh.model.TbMessageType;
import com.rh.ssh.service.TbMessageTypeService;
import com.rh.ssh.utils.PageModel;

public class TbMessageTypeAction extends BaseAction {

	private TbMessageTypeService service;
	private TbMessageType tbMessageType;
	private List<TbMessageType> list;
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
			service.add(tbMessageType, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			service.delete(tbMessageType, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initUpdate() {
		try {
			tbMessageType = service.get(tbMessageType, null);
			request.setAttribute("tbMessageType", tbMessageType);
		} catch (Exception e) {
			return ERROR;
		}
		return "initUpdate";
	}

	public String update() {
		try {
			service.update(tbMessageType, null);
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
			list = service.conditionSelectAll(tbMessageType, null);
			request.setAttribute("list", list);
			request.setAttribute("tbMessageType", tbMessageType);
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
			pageModel = service.pageQuery(pageModel, tbMessageType, null);
			request.setAttribute("tbMessageType", tbMessageType);
			request.setAttribute("pageModel", pageModel);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}
	
	public void setService(TbMessageTypeService service) {
		this.service = service;
	}
	
	public TbMessageType getTbMessageType() {
		return tbMessageType;
	}

	public void setTbMessageType(TbMessageType tbMessageType) {
		this.tbMessageType = tbMessageType;
	}
	
	public List<TbMessageType> getList() {
		return list;
	}

	public void setList(List<TbMessageType> list) {
		this.list = list;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
}