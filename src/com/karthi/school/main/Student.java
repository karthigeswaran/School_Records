package com.karthi.school.main;

public class Student extends Entity{
	private String name;
	private Integer clss;
	private Character section;
	private String dob;
	private Integer studentID;

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

	public void setDOB(String dob) {
		this.dob = dob;
	}

	public String getDOB(){
		return dob;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	public Integer getStudentID(){
		return studentID;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Student Name: ");
		sb.append(name);
		sb.append("\nClass: ");
		sb.append(clss);
		sb.append("\nSection: ");
		sb.append(section);
		sb.append("\nDate of Birth: ");
		sb.append(dob);
		sb.append("\nstudentID number: ");
		sb.append(studentID);
		return sb.toString();
	}
}
