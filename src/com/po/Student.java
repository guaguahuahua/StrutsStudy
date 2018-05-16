package com.po;

/**
 * 学生的持久化对象
 * @author Administrator
 *
 */
public class Student {
	private int stuId;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuPhone;
	
	public void setStuId(int stuId) {
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
	
	public static void main(String []args){
		System.out.println(Integer.bitCount(5));

	}
}
