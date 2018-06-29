package com.ffm.sys.controller;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffm.common.db.SQLUtil;
import com.ffm.common.dict.STATUS;
import com.ffm.sys.model.Menu;
import com.ffm.sys.model.SysUser;
import com.ffm.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu")
public class MenuTreeAction {
	private String data;
	private String pid;
	private String id;
	@Autowired
	private SysMenuService service;

	public void setService(SysMenuService service) {
		this.service = service;
	}

	/**
	 * 查询各模块菜单
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/panelInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> panelInfo() throws IOException {
		String sql = "select * from FFM_SYS_MENU where PID is null order by MORDER";
		List<Menu> list = SQLUtil.query(sql, Menu.class);
		return list;
	}

	/**
	 * 菜单管理展示所有菜单
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/sysMenu", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> sysMenu() throws IOException {
		String sql = "select distinct m1.ID,m1.TEXT,m1.ICON,m1.MORDER,(case when m2.ID is not null then 'closed' else 'open' end)STATE from ";
		sql += "(select * from FFM_SYS_MENU where PID";
		if (this.id == null) {
			sql += " is null";
		} else {
			sql += "=" + this.id;
		}
		sql += " and STATE='" + STATUS.Y;
		sql += "')m1 left join FFM_SYS_MENU m2 on m1.ID=m2.PID and m1.STATE=m2.STATE order by m1.MORDER";
		List<Menu> list = SQLUtil.query(sql, Menu.class);
		return list;
	}

	/**
	 * 查询模块下菜单明细
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/menusList", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> menusList() throws IOException {
		if (this.id == null)
			this.id = this.pid;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SysUser user = (SysUser) session.getAttribute("user");
		String sql = "select distinct m1.ID,m1.TEXT,m1.ICON,m1.PATH,m1.MORDER,(case when m2.ID is not null then 'closed' else 'open' end)STATE from (select * from FFM_SYS_MENU where PID='"
				+ this.id + "' and STATE='" + STATUS.Y + "'";
		if (!"0".equals(user.getAuthority())) {// 最高权限
			// sql += " and ID in(select MENUID from FFM_SYS_AUTHORITY where
			// USERID=" + user.getId()+ ")";
		}
		sql += ")m1 left join FFM_SYS_MENU m2 on m1.ID=m2.PID and m1.STATE=m2.STATE order by m1.MORDER";
		List<Menu> list = SQLUtil.query(sql, Menu.class);
		return list;
	}

	/**
	 * 菜单信息维护
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/menuEdit", method = RequestMethod.POST)
	@ResponseBody
	public void menuEdit() throws IOException {

	}

	/**
	 * 用户菜单权限管理
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/menuPermission", method = RequestMethod.POST)
	@ResponseBody
	public void menuPermission() throws IOException {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SysUser user = (SysUser) session.getAttribute("user");
		if (this.data != null && !"".equals(this.data)) {
			service.menuAuthority(this.data, user);
		}
	}

	@RequestMapping(value = "/showMenuList", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> showMenuList() throws IOException {
		List<Menu> menus = this.service.showMenuList();
		return menus;
	}
}