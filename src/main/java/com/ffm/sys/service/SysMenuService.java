package com.ffm.sys.service;

import java.util.List;

import com.ffm.sys.model.Menu;
import com.ffm.sys.model.SysUser;

public interface SysMenuService {

	List<Menu> showMenuList();

	/**
	 * 菜单权限管理
	 * 
	 * @param ids
	 * @param user
	 */
	void menuAuthority(String ids, SysUser user);
}