package com.dao;

import com.po.Repair;

public interface RepairDao {
	/**
	 * 提交维修订单
	 * @return
	 */
	public void submit(Repair r);
	
	/**
	 * 查询数据库中最大的维修订单号，订单号使用数字串进行查询
	 */
	public String queryMax();
	
	
	/**
	 * 向维修工查看的视图中
	 */
	public void insertIntoRepairStatus(Repair r);
}
