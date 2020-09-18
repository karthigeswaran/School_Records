package com.karthi.school.main;

import java.util.Date;

public class Student extends Entity{
	private String name;
	private Integer clss;
	private Character section;
	private Date dob;
	private Integer id;

	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setClss(Integer clss) {
		this.clss = clss;
	}

	public Integer getClss(){
		return clss;
	}

	public void setSection(Character section) {
		this.section = section;
	}
	
	public Character getSection(){
		return section;
	}

	public void setDOB(Date dob) {
		this.dob = dob;
	}

	public Date getDOB(){
		return dob;
	}

	public void setID(Integer id) {
		this.id = id;
	}
	
	public Integer getID(){
		return id;
	}
  
}
