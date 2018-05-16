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
		//����ҳ�洫���ĵ�¼��Ϣ
		HttpServletRequest adRequest=ServletActionContext.getRequest();
		//��õ�¼������������
		String name=adRequest.getParameter("adName");
		String password=adRequest.getParameter("password");
		System.out.println(name);
		//��ѯ�������ݿ����Ƿ����
		Admin admin=adao.queryByName(name);
		//����˲�����
		if(admin.getAdName()==null) {
			return "notExist";
		}else {
		//����˴��ڣ��������
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
