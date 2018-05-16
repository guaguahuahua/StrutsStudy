package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * �������ݿ�����Ӻ����ݵĲ�ѯ
 * @author Administrator
 *
 */
public class DBUtil {
	//����ģʽ
	private DBUtil() {
	}
	private static DBUtil util=new DBUtil();
	
	public static DBUtil getInstance() {
		return util;
	}
	//��ǰ�����ݿ�������û�����jar��
	private String className="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/students?serverTimezone=GMT";
	private String user="root";
	private String password="111111";
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * ������ݿ������
	 * @return
	 */
	public Connection getConnection() {
		
		try {
			//����ķ�ʽ�������ݿ��������
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;
	}

	/**
	 * ���ݲ���
	 * ���εĽ����ݷ��뵽sql�У����Ĳ��������sql����е�˳�����У�����ִ�д���
	 * @param sql
	 * @param params
	 */
	public void update(String sql, List<Object>params) {
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null && params.size()>0) {
				for(int i=0; i<params.size(); i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݿ�Ĳ�ѯ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet query(String sql, List<Object>params) {
		
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null && params.size()>0) {
				for(int i=0; i<params.size(); i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void close() {
		
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String []args) {
		DBUtil uitl=new DBUtil();
		util.getConnection();
	}
	
}
