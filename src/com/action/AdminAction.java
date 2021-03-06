package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.impl.AdminDao;
import com.opensymphony.xwork2.ActionSupport;
import com.po.Admin;

public class AdminAction extends ActionSupport{
	
	private AdminDao adao=new AdminDao();
	
	public String login() {
		//接收页面传来的登录信息
		HttpServletRequest adRequest=ServletActionContext.getRequest();
		//获得登录人姓名，密码
		String name=adRequest.getParameter("adName");
		String password=adRequest.getParameter("password");
		System.out.println(name);
		//查询该人数据库中是否存在
		Admin admin=adao.queryByName(name);
		//如果人不存在
		if(admin.getAdName()==null) {
			return "notExist";
		}else {
		//如果人存在，检查密码
			if(admin.getPassword().equals(password)) {
				HttpSession session=ServletActionContext.getRequest().getSession();
				session.setAttribute("name", name);
				return "success";
			}else {
				return "accessDeny";
			}
		}	
	}
}
