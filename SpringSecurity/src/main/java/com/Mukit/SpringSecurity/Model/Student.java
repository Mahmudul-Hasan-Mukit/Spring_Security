package com.Mukit.SpringSecurity.Model;

public class Student {
	private int id;
	private String name;
	private String Dept;
	
	
	public Student(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		Dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Dept=" + Dept + "]";
	}
	

}
