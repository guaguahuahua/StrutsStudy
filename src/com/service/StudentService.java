package com.service;

import java.util.List;

import com.dao.impl.Operations;
import com.po.Student;

public class StudentService {
	private Operations o=new Operations();
	
	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student>queryAll(){
		return o.queryAll();
	}
	
	/**
	 * 通过学生的id查询
	 * @param id
	 * @return
	 */
	public Student queryById(int id) {
		return o.queryById(id);
	}
	
	/**
	 * 插入一条学生的信息
	 * @param s
	 */
	public void insertStu(Student s) {
		o.insertStu(s);
	}
	
	/**
	 * 删除一条学生信息
	 * @param id
	 */
	public void delStu(int id) {
		o.delStu(id);
	}
	
	/**
	 * 修改已有的学生信息，
	 * @param s
	 */
	public  void modify(Student s) {
		o.modifyStu(s);
	}
	
	/**
	 * 这块对前面写的方法进行测试
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
