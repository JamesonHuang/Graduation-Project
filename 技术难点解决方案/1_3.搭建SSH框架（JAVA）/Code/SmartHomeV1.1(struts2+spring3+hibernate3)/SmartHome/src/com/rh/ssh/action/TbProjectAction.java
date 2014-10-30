package com.rh.ssh.action;

import java.util.List;
import com.rh.ssh.model.TbProject;
import com.rh.ssh.service.TbProjectService;
import com.rh.ssh.utils.PageModel;

public class TbProjectAction extends BaseAction {

	private TbProjectService service;
	private TbProject tbProject;
	private List<TbProject> list;
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
			service.add(tbProject, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			service.delete(tbProject, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initUpdate() {
		try {
			tbProject = service.get(tbProject, null);
			request.setAttribute("tbProject", tbProject);
		} catch (Exception e) {
			return ERROR;
		}
		return "initUpdate";
	}

	public String update() {
		try {
			service.update(tbProject, null);
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
			list = service.conditionSelectAll(tbProject, null);
			request.setAttribute("list", list);
			request.setAttribute("tbProject", tbProject);
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
			pageModel = service.pageQuery(pageModel, tbProject, null);
			request.setAttribute("tbProject", tbProject);
			request.setAttribute("pageModel", pageModel);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}
	
	public void setService(TbProjectService service) {
		this.service = service;
	}
	
	public TbProject getTbProject() {
		return tbProject;
	}

	public void setTbProject(TbProject tbProject) {
		this.tbProject = tbProject;
	}
	
	public List<TbProject> getList() {
		return list;
	}

	public void setList(List<TbProject> list) {
		this.list = list;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
}