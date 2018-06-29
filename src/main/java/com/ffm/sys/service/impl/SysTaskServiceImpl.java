package com.ffm.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ffm.common.db.SQLUtil;
import com.ffm.common.dict.STATUS;
import com.ffm.common.model.DataGrid;
import com.ffm.common.util.PKUtil;
import com.ffm.common.util.SysUtil;
import com.ffm.sys.dao.SysTaskDAO;
import com.ffm.sys.dto.SysTaskDTO;
import com.ffm.sys.model.SysTask;
import com.ffm.sys.service.SysTaskService;
import com.ffm.sys.task.SysTaskCore;

@Service
public class SysTaskServiceImpl implements SysTaskService {
	private SysTaskDAO dao;

	public void setDao(SysTaskDAO dao) {
		this.dao = dao;
	}

	@Override
	public DataGrid querySysTaskByPage(int page, int size) {
		String sql = "select TASKID,TASKNAME,TASKSTARTTIME,TASKTIMES,TASKPER,TASKPATH,TASKSTATUS,";
		sql += "(select DICTVALUE from FFM_SYS_DICTIONARYDETAIL where DID=";
		sql += "(select ID from FFM_SYS_DICTIONARY where DICTCODE='status' and STATE='";
		sql += STATUS.Y + "') and DICTCODE=TASKSTATUS)TASKSTATUSVALUE from FFM_SYS_SYSTASK";
		int count = SQLUtil.queryCount(sql);
		List<SysTaskDTO> list = SQLUtil.queryByPage(sql, SysTaskDTO.class, size, page);
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(count);
		dataGrid.setRows(list);
		return dataGrid;
	}

	@Override
	public void saveSysTask(List<SysTask> sysTasks) {
		for (int i = 0; i < sysTasks.size(); i++) {
			SysTask sysTask = sysTasks.get(i);
			Integer id = PKUtil.generatePK("SYS_SYSTASK");
			sysTask.setTaskId(id);
		}
		this.dao.insert(sysTasks);
	}

	@Override
	public void modifySysTask(List<SysTask> sysTasks) {
		this.dao.update(sysTasks);
	}

	@Override
	public void removeSysTask(SysTask sysTask) {
		this.dao.delete(sysTask);
	}

	@Override
	public void runSysTask(SysTask sysTask) {
		String sql = "select TASKID,TASKSTARTTIME,TASKTIMES,TASKPER,TASKPATH,TASKSTATUS from FFM_SYS_SYSTASK where TASKID=" + sysTask.getTaskId();
		List<SysTask> list = SQLUtil.query(sql, SysTask.class);
		if (list.size() == 1) {
			if (!"1".equals(list.get(0).getTaskStatus())) {
				return;
			}
			String path = list.get(0).getTaskPath();
			try {
				Object object = SysUtil.getInstance(Class.forName(path));
				SysTaskCore task = (SysTaskCore) object;
				task.doTask();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}