package com.rh.ssh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.rh.ssh.model.TbTask;
import com.rh.ssh.dao.DaoService;
import com.rh.ssh.service.TbTaskService;
import com.rh.ssh.utils.StringTools;
import com.rh.ssh.utils.BeanTools;
import com.rh.ssh.utils.PageModel;

public class TbTaskServiceImpl implements TbTaskService {

	private DaoService dao;

	public void setDao(DaoService dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> initAdd(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void add(TbTask tbTask, Map<String, Object> param) throws Exception {
		dao.add(tbTask);
	}

	@Override
	public void delete(TbTask tbTask, Map<String, Object> param) throws Exception {
		dao.delete(tbTask);
	}

	@Override
	public Map<String, Object> initUpdate(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void update(TbTask tbTask, Map<String, Object> param) throws Exception {
		dao.update(tbTask);
	}

	@Override
	public Map<String, Object> initAddAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void addAll(List<TbTask> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.addAll(list);
	}

	@Override
	public void deleteAll(List<TbTask> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.deleteAll(list);
	}

	@Override
	public Map<String, Object> initMergeAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public void mergeAll(List<TbTask> list, Map<String, Object> param) throws Exception {
		BeanTools.checkListItem(list);
		dao.mergeAll(list);
	}

	@Override
	public TbTask get(TbTask tbTask, Map<String, Object> param) throws Exception {
		return (TbTask) dao.get(TbTask.class, tbTask.getTaskId());
	}

	@Override
	public List<TbTask> selectAll(Map<String, Object> param) throws Exception {
		String hql = "from TbTask";
		return dao.find(hql);
	}

	@Override
	public Map<String, Object> initConditionSelectAll(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public List<TbTask> conditionSelectAll(TbTask tbTask, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from TbTask tbTask where 1=1 ");

		if (StringTools.notEmpty(tbTask.getTaskId())) {
			hql.append("and tbTask.taskId = :tbTask_taskId ");
			paramMap.put("tbTask_taskId", tbTask.getTaskId());
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskName())) {
			hql.append("and tbTask.taskName like :tbTask_taskName ");
			paramMap.put("tbTask_taskName", "%" + tbTask.getTaskName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskType())) {
			hql.append("and tbTask.taskType like :tbTask_taskType ");
			paramMap.put("tbTask_taskType", "%" + tbTask.getTaskType().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskFromPro())) {
			hql.append("and tbTask.taskFromPro like :tbTask_taskFromPro ");
			paramMap.put("tbTask_taskFromPro", "%" + tbTask.getTaskFromPro().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskFromTask())) {
			hql.append("and tbTask.taskFromTask like :tbTask_taskFromTask ");
			paramMap.put("tbTask_taskFromTask", "%" + tbTask.getTaskFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskDate())) {
			hql.append("and tbTask.taskDate like :tbTask_taskDate ");
			paramMap.put("tbTask_taskDate", "%" + tbTask.getTaskDate().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskTomatoesCount())) {
			hql.append("and tbTask.taskTomatoesCount like :tbTask_taskTomatoesCount ");
			paramMap.put("tbTask_taskTomatoesCount", "%" + tbTask.getTaskTomatoesCount().trim() + "%");
		}

		List<TbTask> list = dao.find(hql.toString(), paramMap);
		return list;
	}

	@Override
	public Map<String, Object> initPageQuery(Map<String, Object> param) throws Exception {
		return null;
	}

	@Override
	public PageModel pageQuery(PageModel pageModel, TbTask tbTask, Map<String, Object> param) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer queryHQL = new StringBuffer("from TbTask tbTask where 1=1 ");
		StringBuffer countHQL = new StringBuffer("select count(*) from TbTask tbTask where 1=1 ");
		StringBuffer condition = new StringBuffer();

		if (StringTools.notEmpty(tbTask.getTaskId())) {
			condition.append("and tbTask.taskId = :tbTask_taskId ");
			paramMap.put("tbTask_taskId", tbTask.getTaskId());
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskName())) {
			condition.append("and tbTask.taskName like :tbTask_taskName ");
			paramMap.put("tbTask_taskName", "%" + tbTask.getTaskName().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskType())) {
			condition.append("and tbTask.taskType like :tbTask_taskType ");
			paramMap.put("tbTask_taskType", "%" + tbTask.getTaskType().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskFromPro())) {
			condition.append("and tbTask.taskFromPro like :tbTask_taskFromPro ");
			paramMap.put("tbTask_taskFromPro", "%" + tbTask.getTaskFromPro().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskFromTask())) {
			condition.append("and tbTask.taskFromTask like :tbTask_taskFromTask ");
			paramMap.put("tbTask_taskFromTask", "%" + tbTask.getTaskFromTask().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskDate())) {
			condition.append("and tbTask.taskDate like :tbTask_taskDate ");
			paramMap.put("tbTask_taskDate", "%" + tbTask.getTaskDate().trim() + "%");
		}

		if (StringTools.trimNotEmpty(tbTask.getTaskTomatoesCount())) {
			condition.append("and tbTask.taskTomatoesCount like :tbTask_taskTomatoesCount ");
			paramMap.put("tbTask_taskTomatoesCount", "%" + tbTask.getTaskTomatoesCount().trim() + "%");
		}

		queryHQL.append(condition);
		countHQL.append(condition);
		int count = ((Long) dao.findUnique(countHQL.toString(), paramMap)).intValue();
		pageModel.init(count);
		List<TbTask> list = dao.findLimit(queryHQL.toString(), paramMap, pageModel.getBeginQueryNumber(), pageModel.getPageSize());
		pageModel.setList(list);
		return pageModel;
	}
}