package com.karthi.school.recordHandler;

import java.sql.*;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Student;

public class StudentRecordHandler extends RecordHandler {
  Student student;
  Connection connection;
  Statement statement;
  ResultSet resultSet;
  String command;

  @Override
  public Result create(Entity obj) {
    student = (Student)obj;
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        return result;
      }
      statement = connection.createStatement();
      
      command = "SELECT  FROM batch WHERE "
      resultSet = 
    }
    return null;
  }

  @Override
  public Result read(Entity obj) {
    
    return null;
  }

  @Override
  public Result update(Entity obj) {
    
    return null;
  }

  @Override
  public Result delete(Entity obj) {
    
    return null;
  }
  
}
