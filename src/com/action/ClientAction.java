package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport{

	/**
	 * �ͻ���¼
	 * @return
	 */
	public String clientLogin() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("cName", cName);
		return "loginSuccess";
	}
	
	
	private String cName;
	private String password;
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
