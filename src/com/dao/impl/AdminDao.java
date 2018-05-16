package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.AdminOperation;
import com.po.Admin;
import com.util.DBUtil;

public class AdminDao implements AdminOperation{
	
	DBUtil util=DBUtil.getInstance();
	ResultSet rs;
	@Override
	public Admin queryByName(String adName) {
		//��ȡ����
		util.getConnection();
		String sql="select * from admin_table where adName=?";
		List<Object>params=new ArrayList<Object>();
		params.add(adName);
		//��ѯ���
		rs=util.query(sql, params);
		//���ս����������ݿ��в����ڣ���ôҲ�᷵��һ����������ǽ��������ֵ�Ƕ���Ĭ�ϵĿ�ֵ
		Admin ad=new Admin();
		try {
			while(rs.next()) {
				ad.setAdName(rs.getString("adName"));
				ad.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ad;
	}
	
	
	
	public static void main(String []args) {
		AdminDao ad=new AdminDao();
		Admin res=ad.queryByName("ukoo");
		System.out.println(res.getAdName()+", "+res.getPassword());
	}
}
