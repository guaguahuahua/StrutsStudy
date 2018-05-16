package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.InforOperation;
import com.po.Student;
import com.util.DBUtil;

/**
 * ʵ�ֲ����Ľӿ�
 * @author Administrator
 *
 */
public class Operations implements InforOperation{

	//������ݿ�����
	private static DBUtil util=DBUtil.getInstance();
	private String sql;
	private ResultSet rs;
	
	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		//���û�н��շ��ص�����conn����Ϊ��DBUtil�д��ڽ��ն���conn�����÷���֮����DBUtil���ܹ�������ݿ�����
		//��������ݲ�ѯ�����ݲ��ݵĹ�����Ҫ�Ļ�����ͨ������DBUtil���еķ�������ʵ��
		util.getConnection();
		sql="select * from student_infor;";
		rs=util.query(sql, null);
		List<Student> list=new ArrayList<Student>();
		
		try {
			while(rs.next()) {
				Student s=new Student();
				s.setStuId(rs.getInt("stuId"));
				s.setStuName(rs.getString("stuName"));
				s.setStuSex(rs.getString("stuSex"));
				s.setStuAge(rs.getInt("stuAge"));
				s.setStuPhone(rs.getString("stuPhone"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return list;
	}

	
	@Override
	public Student queryById(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from student_infor where stuId= ?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		Student s=new Student();
		try {
			while(rs.next()) {
				s.setStuId(rs.getInt("stuId"));
				s.setStuName(rs.getString("stuName"));
				s.setStuSex(rs.getString("stuSex"));
				s.setStuAge(rs.getInt("stuAge"));
				s.setStuPhone(rs.getString("stuPhone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void insertStu(Student s) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into student_infor values(?, ?, ?, ?, ?)";
		List<Object> params=new ArrayList<Object>();
		params.add(s.getStuId());
		params.add(s.getStuName());
		params.add(s.getStuSex());
		params.add(s.getStuAge());
		params.add(s.getStuPhone());
		util.update(sql, params);
		util.close();
	}

	@Override
	public void delStu(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from student_infor where stuId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	/**
	 * ���������ѧ����Ϣ�е������ڱ��в����ڣ���ô�����޸��κ���Ϣ
	 */
	@Override
	public void modifyStu(Student s) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update student_infor set stuName=?, stuSex=?, stuAge=?, stuPhone=? where stuId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(s.getStuName());
		params.add(s.getStuSex());
		params.add(s.getStuAge());
		params.add(s.getStuPhone());
		params.add(s.getStuId());
		util.update(sql, params);
		util.close();
	}

	public static void main(String []args) {
		Student s=new Student();
		s.setStuId(005);
		s.setStuName("hik");
		s.setStuSex("male");
		s.setStuAge(120);
		s.setStuPhone("1231232");
		
		Operations op=new Operations();
//		op.insertStu(s);
//		op.modifyStu(s);
//		op.delStu(5);
		Student s1=op.queryById(5);
		System.out.println(s1.getStuName()+", "+s1.getStuSex());
//		List<Student> res=op.queryAll();
//		for(Student K:res) {
//			System.out.println(K.getStuName()+", "+K.getStuSex());
//		}
	}
}
