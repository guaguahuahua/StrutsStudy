package com.dao;

public interface MaintainerDao {

	/**
	 * 维修工查看所有的未处理的订单
	 */
	public void queryAllOrders();
	
	/**
	 * 维修工查看自己处理过的订单
	 */
	public void queryMyHandles();
}
