package com.dao;

import com.po.Admin;

public interface AdminOperation {
	//根据管理员姓名进行查找，如果数据库中存在，返回true，否则返回false
	public Admin queryByName(String adName);
	
}
