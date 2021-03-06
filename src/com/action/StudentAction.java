package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.po.Student;
import com.service.StudentService;

public class StudentAction extends ActionSupport{
	
	private static final String S="success";
	private static final String E="error";
	
	//使用struts框架
	private String name;
	
	public String execute() {
		
		if("dante".equals(name)) {
			return "success"; 
		}else {
			System.out.println("eee");
			return "eee";
		}
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	//下面是对对数据库的一个访问的过程
	private StudentService ss=new StudentService();
	private int stuId;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuPhone;
	
	public void setStuId(int stuId) {
		System.out.println("接受到了视图的数据：");
		this.stuId=stuId;
	}
	public int getStuId() {
		return stuId;
	}
	
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int age) {
		this.stuAge = age;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String phone) {
		this.stuPhone = phone;
	}
	

	/**
	 * 学生登录的过程
	 * @return
	 */
	public String login() {
		Student s=ss.queryById(stuId);
		if(s.getStuName()!=null && s.getStuId()!=0) {
			System.out.println("这块是打印了登录人的信息");
			System.out.println(s.getStuName()+", "+s.getStuId()+", "+s.getStuSex());
			return S;
		}else {
			return E;
		}
	}
	
	/**
	 * 查询所有学生的信息
	 * @return
	 */
	public String query() {
		
		List<Student> allStudents=ss.queryAll();
		if(allStudents!=null && allStudents.size()>0) {
			HttpServletRequest stuRequest=ServletActionContext.getRequest();
			stuRequest.setAttribute("studentList", allStudents);
			return "querySuccess";
		}else {
			return "error";	
		}		
	}
	

	/**
	 * 根据页面上传递的学生id，删除一个学生的信息
	 * @return
	 */
	public String deleteStudent() {
		
		System.out.println("这里是删除学生动作");
		System.out.println("使用action属性得到的id为："+stuId);
		HttpServletRequest delRequest=ServletActionContext.getRequest();
		String id=delRequest.getParameter("stuId");
		System.out.println("使用request获得的id:"+id);
		Student s=ss.queryById(stuId);
		if(s.getStuName()!=null) {
			ss.delStu(stuId);
			return "deleteSuccess";			
		}else {
			return E;
		}
	}
	
	/**
	 * 根据学生的Id进行查询
	 * @return
	 */
	public String queryById() {
		
		Student s=ss.queryById(stuId);
		if(s!=null) {
			HttpServletRequest queryRequest=ServletActionContext.getRequest();
			queryRequest.setAttribute("student", s);
			return "querySuccess";
		}else {
			return E;
		}
	}
	
	/**
	 * 修改学生信息动作
	 * @return
	 */
	public String update() {
		System.out.println("这块是视图的更新，获得修改的学生的信息为：");
		System.out.println(stuId+", "+stuName+", "+stuSex+", "+stuAge);
		Student s=new Student();
		s.setStuId(stuId);
		s.setStuName(stuName);
		s.setStuSex(stuSex);
		s.setStuAge(stuAge);
		s.setStuPhone(stuPhone);
		ss.modify(s);
		return "updateSuccess";
	}	
	
	public String addStudent() {
				
		//首先查询id是否存在，如果存在那么返回“添加失败”
		Student s=ss.queryById(stuId);
		//如果用户输入的id已经存在，这块不能使用s==null作为判断，因为如果不存在数据库的元素，那么返回的也不是空对象，而是各项属性为默认值的对象
		if(s.getStuName()!=null) {
			System.out.println("学生存在："+s.getStuName());
			return "alreadyExist";
		}else {
			System.out.println("学生存在："+s.getStuName());
			s.setStuId(stuId);		
			s.setStuName(stuName);
			s.setStuSex(stuSex);
			s.setStuAge(stuAge);
			s.setStuPhone(stuPhone);
			ss.insertStu(s);
			return "addSuccess";			
		}
	}
	
	
	
	
	
	
	
	
	
}
