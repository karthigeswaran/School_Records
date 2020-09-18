package com.karthi.school.recordHandler;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import java.sql.*;

public abstract  class RecordHandler {
	Result result = new Result();
	static final String JDBC_driver  = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/schooldb";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "root";

	Connection connection;

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
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	abstract public Result create(Entity obj);
	abstract public Result read(Entity obj);
	abstract public Result update(Entity obj);
	abstract public Result delete(Entity obj);
  
}
