package com.dao;

import com.po.Repair;

public interface RepairDao {
	/**
	 * �ύά�޶���
	 * @return
	 */
	public void submit(Repair r);
	
	/**
	 * ��ѯ���ݿ�������ά�޶����ţ�������ʹ�����ִ����в�ѯ
	 */
	public String queryMax();
	
	
	/**
	 * ��ά�޹��鿴����ͼ��
	 */
	public void insertIntoRepairStatus(Repair r);
}
