package com.karthi.school.recordHandler;

import java.sql.ResultSet;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Admin;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Student;

import java.sql.*;

public class UserRecordHandler {
	Result result = new Result();
	static final String JDBC_driver  = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/schooldb";

  //  Database credentials
  static final String USER = "root";
	static final String PASS = "root";
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String command;

	public int verifyUser(String userName, String password) {
		int userPrivelages = 0;
		try{
			connection = openConnection();
			statement = connection.createStatement();
			command = "SELECT is_admin FROM user WHERE user_name = '"+userName+"' AND password = '"+password+"';";
			resultSet = statement.executeQuery(command);
			if(resultSet.next()){
			userPrivelages = resultSet.getInt(1);
			}
			closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userPrivelages;
	}

	public Result createAdmin(Admin admin){
		try{
			connection = openConnection();
			statement = connection.createStatement();
			command = "INSERT INTO user VALUES("+admin.getUserName()+","+admin.getPassword()+",1);";
			int rowCount = statement.executeUpdate(command);
			statement.close();
			closeConnection();
			if(rowCount == 0){
				result.setStatus(false);
				result.addMsg("Admin user already exist");
				return result;
			}
			else{
				result.setStatus(true);
				result.addMsg("Succesfully created admin user.");
			}
		}catch(Exception e){
			result.setStatus(false);
			result.addMsg(e.getMessage());
		}
		return result;
	}

	public Result createStudent(Student student){
		try{
			connection = openConnection();
			statement = connection.createStatement();
			command = "INSERT INTO user VALUES('"+student.getStudentID()+"','"+student.getDOB()+"',2);";
			int rowCount = statement.executeUpdate(command);
			statement.close();
			closeConnection();
			if(rowCount == 0){
				result.setStatus(false);
				result.addMsg("Student user already exist");
				return result;
			}
			else{
				result.setStatus(true);
				result.addMsg("Succesfully created student user.");
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setStatus(false);
			result.addMsg(e.getMessage());
		}
		return result;
	}

	public Result update(Entity obj) {
		
		return result;
	}

	public Result delete(Entity obj) {
		
		return result;
	}
	
	private Connection openConnection(){
		try{
			Class.forName(JDBC_driver);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}

	private Boolean closeConnection(){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
