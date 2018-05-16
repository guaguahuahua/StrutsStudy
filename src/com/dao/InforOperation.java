package com.dao;

import java.util.List;

import com.po.Student;

public interface InforOperation {
	
	/**
	 * 查询所有的学生
	 * @return
	 */
	public List<Student> queryAll();
	/**
	 * 通过学生的Id查询
	 * @param id
	 * @return
	 */
	public Student queryById(int id);
	/**
	 * 向数据库中添加一条记录
	 * @param s
	 */
	public void insertStu(Student s);
	/**
	 * 删除一条学生的信息
	 * @param id
	 */
	public void delStu(int id);
	/**
	 * 修改一条学生的信息
	 * @param s
	 */
	public void modifyStu(Student s);
}
