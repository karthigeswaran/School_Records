package com.karthi.school.recordHandler;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import java.sql.*;

public abstract  class RecordHandler {
	Result result;
	Connection connection;
  Statement statement;
	ResultSet resultSet;
	String command;
  
	static final String JDBC_driver  = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/schooldb";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";

	protected Connection openConnection(){
		try{
			Class.forName(JDBC_driver);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}

	protected Boolean closeConnection(){
		try{
			if(resultSet!=null){
				resultSet.close();
			}
			statement.close();
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	abstract public Result create(Entity obj);
	abstract public Result read(Entity obj);
	abstract public Result update(Entity obj,String updateOption);
	abstract public Result delete(Entity obj);
	abstract public Result verify(Entity obj);
  
}
