package com.dao;

import com.po.Admin;

public interface AdminOperation {
	//���ݹ���Ա�������в��ң�������ݿ��д��ڣ�����true�����򷵻�false
	public Admin queryByName(String adName);
	
}
