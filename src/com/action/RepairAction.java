package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.impl.RepairDaoImple;
import com.opensymphony.xwork2.ActionSupport;
import com.po.Repair;

public class RepairAction extends ActionSupport{
	
	private RepairDaoImple rdi=new RepairDaoImple();
	/**
	 * �ͻ��ύ����
	 * @return
	 */
	public String submit() {
		HttpServletRequest repairRequest=ServletActionContext.getRequest();
		String equipName=repairRequest.getParameter("equipName");
		String problem=repairRequest.getParameter("problem");
		String phone=repairRequest.getParameter("phone");
		String address=repairRequest.getParameter("address");
		Repair r=new Repair();
		r.setProblem(problem);
		r.setEquipName(equipName);
		r.setPhone(phone);
		r.setAddress(address);
		rdi.submit(r);
		return SUCCESS;
	}
	
	/**
	 * �ͻ��鿴�Լ��Ķ���
	 * @return
	 */
	public String checkMyOrder() {
		
		
		return SUCCESS;
	}
	
	private String listId;
	private String equipName;
	private String problem;
	private String phone;
	private String address;
	
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}	
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
