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
	
	//ʹ��struts���
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
	
	
	
	//�����ǶԶ����ݿ��һ�����ʵĹ���
	private StudentService ss=new StudentService();
	private int stuId;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuPhone;
	
	public void setStuId(int stuId) {
		System.out.println("���ܵ�����ͼ�����ݣ�");
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
	 * ѧ����¼�Ĺ���
	 * @return
	 */
	public String login() {
		Student s=ss.queryById(stuId);
		if(s.getStuName()!=null && s.getStuId()!=0) {
			System.out.println("����Ǵ�ӡ�˵�¼�˵���Ϣ");
			System.out.println(s.getStuName()+", "+s.getStuId()+", "+s.getStuSex());
			return S;
		}else {
			return E;
		}
	}
	
	/**
	 * ��ѯ����ѧ������Ϣ
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
	 * ����ҳ���ϴ��ݵ�ѧ��id��ɾ��һ��ѧ������Ϣ
	 * @return
	 */
	public String deleteStudent() {
		
		System.out.println("������ɾ��ѧ������");
		System.out.println("ʹ��action���Եõ���idΪ��"+stuId);
		HttpServletRequest delRequest=ServletActionContext.getRequest();
		String id=delRequest.getParameter("stuId");
		System.out.println("ʹ��request��õ�id:"+id);
		Student s=ss.queryById(stuId);
		if(s.getStuName()!=null) {
			ss.delStu(stuId);
			return "deleteSuccess";			
		}else {
			return E;
		}
	}
	
	/**
	 * ����ѧ����Id���в�ѯ
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
	 * �޸�ѧ����Ϣ����
	 * @return
	 */
	public String update() {
		System.out.println("�������ͼ�ĸ��£�����޸ĵ�ѧ������ϢΪ��");
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
				
		//���Ȳ�ѯid�Ƿ���ڣ����������ô���ء����ʧ�ܡ�
		Student s=ss.queryById(stuId);
		//����û������id�Ѿ����ڣ���鲻��ʹ��s==null��Ϊ�жϣ���Ϊ������������ݿ��Ԫ�أ���ô���ص�Ҳ���ǿն��󣬶��Ǹ�������ΪĬ��ֵ�Ķ���
		if(s.getStuName()!=null) {
			System.out.println("ѧ�����ڣ�"+s.getStuName());
			return "alreadyExist";
		}else {
			System.out.println("ѧ�����ڣ�"+s.getStuName());
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
