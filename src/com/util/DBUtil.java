package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 生成数据库的连接和数据的查询
 * @author Administrator
 *
 */
public class DBUtil {
	//单例模式
	private DBUtil() {
	}
	private static DBUtil util=new DBUtil();
	
	public static DBUtil getInstance() {
		return util;
	}
	//当前的数据库驱动并没有添加jar包
	private String className="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/students?serverTimezone=GMT";
	private String user="root";
	private String password="111111";
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 获得数据库的连接
	 * @return
	 */
	public Connection getConnection() {
		
		try {
			//反射的方式加载数据库的驱动类
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
	 * 数据操纵
	 * 依次的将数据放入到sql中，这块的参数必须和sql语句中的顺序排列，否则执行错误
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
	 * 数据库的查询工作
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
	 * 关闭数据库连接
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
