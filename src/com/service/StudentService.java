package com.service;

import java.util.List;

import com.dao.impl.Operations;
import com.po.Student;

public class StudentService {
	private Operations o=new Operations();
	
	/**
	 * ��ѯ����ѧ����Ϣ
	 * @return
	 */
	public List<Student>queryAll(){
		return o.queryAll();
	}
	
	/**
	 * ͨ��ѧ����id��ѯ
	 * @param id
	 * @return
	 */
	public Student queryById(int id) {
		return o.queryById(id);
	}
	
	/**
	 * ����һ��ѧ������Ϣ
	 * @param s
	 */
	public void insertStu(Student s) {
		o.insertStu(s);
	}
	
	/**
	 * ɾ��һ��ѧ����Ϣ
	 * @param id
	 */
	public void delStu(int id) {
		o.delStu(id);
	}
	
	/**
	 * �޸����е�ѧ����Ϣ��
	 * @param s
	 */
	public  void modify(Student s) {
		o.modifyStu(s);
	}
	
	/**
	 * ����ǰ��д�ķ������в���
	 * @param args
	 */
	public static void main(String []args) {
		Student s=new Student();
		s.setStuId(005);
		s.setStuName("huahua");
		s.setStuSex("female");
		s.setStuAge(27);
		s.setStuPhone("2222");
		StudentService ss=new StudentService();
		ss.delStu(5);;
		
	}
	
}
