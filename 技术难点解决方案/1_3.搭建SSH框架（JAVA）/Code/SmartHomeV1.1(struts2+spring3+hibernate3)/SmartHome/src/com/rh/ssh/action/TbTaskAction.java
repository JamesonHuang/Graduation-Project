package com.rh.ssh.action;

import java.util.List;
import com.rh.ssh.model.TbTask;
import com.rh.ssh.service.TbTaskService;
import com.rh.ssh.utils.PageModel;

public class TbTaskAction extends BaseAction {

	private TbTaskService service;
	private TbTask tbTask;
	private List<TbTask> list;
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
			service.add(tbTask, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			service.delete(tbTask, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initUpdate() {
		try {
			tbTask = service.get(tbTask, null);
			request.setAttribute("tbTask", tbTask);
		} catch (Exception e) {
			return ERROR;
		}
		return "initUpdate";
	}

	public String update() {
		try {
			service.update(tbTask, null);
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
			list = service.conditionSelectAll(tbTask, null);
			request.setAttribute("list", list);
			request.setAttribute("tbTask", tbTask);
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
			pageModel = service.pageQuery(pageModel, tbTask, null);
			request.setAttribute("tbTask", tbTask);
			request.setAttribute("pageModel", pageModel);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}
	
	public void setService(TbTaskService service) {
		this.service = service;
	}
	
	public TbTask getTbTask() {
		return tbTask;
	}

	public void setTbTask(TbTask tbTask) {
		this.tbTask = tbTask;
	}
	
	public List<TbTask> getList() {
		return list;
	}

	public void setList(List<TbTask> list) {
		this.list = list;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
}