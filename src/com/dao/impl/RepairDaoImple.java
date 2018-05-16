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
	 * �����ݿ��ύ����
	 */
	@Override
	public void submit(Repair r) {
		// TODO Auto-generated method stub
		util.getConnection();
		String sql="insert into repair values(?, ?, ?, ?, ?)";
		List<Object> params=new ArrayList<Object>();
		//���Ȼ�õ�ǰ���ĵ���
		listId=queryMax();
		r.setListId(listId);
		//�������
		params.add(r.getListId());
		params.add(r.getEquipName());
		params.add(r.getProblem());
		params.add(r.getPhone());
		params.add(r.getAddress());
		util.update(sql, params);
		util.close();
	}

	/**
	 * ��ѯ���ݿ��е���󶩵����
	 */
	public String queryMax() {
		util.getConnection();
		String sql="select max(listId) from repair";
		String listId="";
		ResultSet rs=util.query(sql, null);
		try {
			String id = "";
			//�жϲ�ѯ����Ƿ�Ϊ��
			if(rs.next()) {
				//���ʹ�õı�ǩ������������������Ϊʹ���˾ۼ�����
				id=rs.getString(1);				
			}
			//������ݿ���Ϊ��ʱ��Ĭ�ϵ�listId�Ǵ�1��ʼ�ģ������ı�ų���Ϊ8λ
			if(id==null || id.equals("")) {
				id="00000001";
			}
			//��ԭ������������1
			int newId=Integer.parseInt(id);
			newId=newId+1;			
			listId=newId+"";
			//ת����Ϊ����Ϊ8�Ķ�����
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
