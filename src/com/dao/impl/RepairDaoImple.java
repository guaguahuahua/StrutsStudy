package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.RepairDao;
import com.po.Repair;
import com.util.DBUtil;

public class RepairDaoImple implements RepairDao{
	
	private DBUtil util=DBUtil.getInstance();
	private String listId;
	/**
	 * 向数据库提交订单
	 */
	@Override
	public void submit(Repair r) {
		// TODO Auto-generated method stub
		util.getConnection();
		String sql="insert into repair values(?, ?, ?, ?, ?)";
		List<Object> params=new ArrayList<Object>();
		//首先获得当前最大的单号
		listId=queryMax();
		r.setListId(listId);
		//传入参数
		params.add(r.getListId());
		params.add(r.getEquipName());
		params.add(r.getProblem());
		params.add(r.getPhone());
		params.add(r.getAddress());
		util.update(sql, params);
		util.close();
	}

	/**
	 * 查询数据库中的最大订单编号
	 */
	public String queryMax() {
		util.getConnection();
		String sql="select max(listId) from repair";
		String listId="";
		ResultSet rs=util.query(sql, null);
		try {
			String id = "";
			//判断查询结果是否为空
			if(rs.next()) {
				//这块使用的标签，而不是属性名，因为使用了聚集函数
				id=rs.getString(1);				
			}
			//如果数据库中为空时，默认的listId是从1开始的，订单的编号长度为8位
			if(id==null || id.equals("")) {
				id="00000001";
			}
			//在原来基础上增加1
			int newId=Integer.parseInt(id);
			newId=newId+1;			
			listId=newId+"";
			//转换成为长度为8的订单号
			while(listId.length()<8) {
				listId="0"+listId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return listId;
	}
	
	@Override
	public void insertIntoRepairStatus(Repair r) {
		// TODO Auto-generated method stub
		util.getConnection();
		String sql="insert into repair_status values(?, ?, ?, ?, ?)";
		List<Object> params=new ArrayList<Object>();
		params.add(r.getListId());
		params.add(r.getProblem());
	}
	
	public static void main(String []args) {
		RepairDaoImple rpdi=new RepairDaoImple();
		Repair r=new Repair();
		r.setProblem("shis");
		r.setPhone("789890");
		r.setAddress("sdfs");
		rpdi.submit(r);
	}

}
