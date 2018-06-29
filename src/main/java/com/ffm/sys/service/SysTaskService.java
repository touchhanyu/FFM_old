package com.ffm.sys.service;

import java.util.List;

import com.ffm.common.model.DataGrid;
import com.ffm.sys.model.SysTask;

public interface SysTaskService {
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	DataGrid querySysTaskByPage(int page, int size);

	void saveSysTask(List<SysTask> sysTasks);

	void modifySysTask(List<SysTask> sysTasks);

	void removeSysTask(SysTask sysTask);

	void runSysTask(SysTask sysTask);
}