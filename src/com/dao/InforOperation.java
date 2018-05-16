package com.dao;

import java.util.List;

import com.po.Student;

public interface InforOperation {
	
	/**
	 * ��ѯ���е�ѧ��
	 * @return
	 */
	public List<Student> queryAll();
	/**
	 * ͨ��ѧ����Id��ѯ
	 * @param id
	 * @return
	 */
	public Student queryById(int id);
	/**
	 * �����ݿ������һ����¼
	 * @param s
	 */
	public void insertStu(Student s);
	/**
	 * ɾ��һ��ѧ������Ϣ
	 * @param id
	 */
	public void delStu(int id);
	/**
	 * �޸�һ��ѧ������Ϣ
	 * @param s
	 */
	public void modifyStu(Student s);
}
