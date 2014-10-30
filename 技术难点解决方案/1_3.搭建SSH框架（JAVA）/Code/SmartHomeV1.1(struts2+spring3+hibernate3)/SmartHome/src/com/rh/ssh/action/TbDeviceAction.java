package com.rh.ssh.action;

import java.util.List;
import com.rh.ssh.model.TbDevice;
import com.rh.ssh.service.TbDeviceService;
import com.rh.ssh.utils.PageModel;

public class TbDeviceAction extends BaseAction {

	private TbDeviceService service;
	private TbDevice tbDevice;
	private List<TbDevice> list;
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
			service.add(tbDevice, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			service.delete(tbDevice, null);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String initUpdate() {
		try {
			tbDevice = service.get(tbDevice, null);
			request.setAttribute("tbDevice", tbDevice);
		} catch (Exception e) {
			return ERROR;
		}
		return "initUpdate";
	}

	public String update() {
		try {
			service.update(tbDevice, null);
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
			list = service.conditionSelectAll(tbDevice, null);
			request.setAttribute("list", list);
			request.setAttribute("tbDevice", tbDevice);
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
			pageModel = service.pageQuery(pageModel, tbDevice, null);
			request.setAttribute("tbDevice", tbDevice);
			request.setAttribute("pageModel", pageModel);
		} catch (Exception e) {
			return ERROR;
		}
		return "pageQuery";
	}
	
	public void setService(TbDeviceService service) {
		this.service = service;
	}
	
	public TbDevice getTbDevice() {
		return tbDevice;
	}

	public void setTbDevice(TbDevice tbDevice) {
		this.tbDevice = tbDevice;
	}
	
	public List<TbDevice> getList() {
		return list;
	}

	public void setList(List<TbDevice> list) {
		this.list = list;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
}