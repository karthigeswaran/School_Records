package com.karthi.school.recordHandler;

//importing java classes
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//importing local classes
import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Student;

public class StudentRecordHandler extends RecordHandler {
  Student student;
  
  @Override
  public Result create(Entity obj) {
    student = (Student)obj;
    result = new Result();
    try{
      //connection establishment
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }

      //creating statement
      statement = connection.createStatement();
      Integer sectionID = getSectionId();
      if(sectionID == 0){
        result.setStatus(false);
        result.addMsg("No matching class or section details. add or try with different input.");
        closeConnection();
        return result;
      }
      String name = student.getName();
      java.util.Date dob = new SimpleDateFormat("yyyy-mm-dd").parse(student.getDOB());
      Date date = new Date(dob.getTime()); 
      command = "INSERT INTO student "+
                "VALUE("
                +student.getStudentID()+",'"
                +name+"','"
                +date+"',"
                +sectionID+");";
      
      //exceuting statement
      int rowCount = statement.executeUpdate(command);
      if(rowCount == 0){
        result.setStatus(false);
        result.addMsg("unable to create new student. Try again later.");
        closeConnection();
        return result;
      }else{
        result.setStatus(true);
        result.addMsg("Successfully created the student"); 
      }

      //create a new user
      Result userRecordResult = new UserRecordHandler().createStudent(student);
      if(userRecordResult.getStatus()){
        result.setStatus(true);
        result.addMsg("Successfully added the student");
      }
      else{
        result.setStatus(false);
        result.addMsg("Unable to add record");
      }
      
      result.merge(userRecordResult);

      //closing connection...
      closeConnection();
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while creating student record");
    }
    return result;
  }

  @Override
  public Result read(Entity obj) {
    student = (Student) obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }
      
      statement = connection.createStatement();
      command = "SELECT student.name,student.dob,section.name,batch.class "+ 
                "FROM student "+
                "INNER JOIN section "
                +"ON student.current_section_id=section.section_id "+
                "INNER JOIN batch "
                +"ON section.batch_id=batch.batch_id "
                +"where student_id ="+student.getStudentID()+";";
      resultSet = statement.executeQuery(command);
      if(resultSet.next()){
        student.setName(resultSet.getString(1));
        student.setDOB(resultSet.getString(2));
        student.setSection(resultSet.getString(3).toCharArray()[0]);
        student.setClss(resultSet.getInt(4));
      }else{
        result.setStatus(false);
        result.addMsg("Unable to find student with given ID.");
        closeConnection();
        return result;
      }

      result.setStatus(true);
      result.addMsg("Read successfull");
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while reading student record");
    }
    return result;
  }

  @Override
  public Result update(Entity obj,String updateOption) {
    student = (Student) obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }
      statement = connection.createStatement();
      if(updateOption.equals("name")){
        String name = student.getName();
        command = "UPDATE student"+
                  " SET name = '"+name+"'"+
                  " WHERE student_id = "+student.getStudentID()+" ;";
      }else if(updateOption.equals("dob(yyyy-mm-dd)")){
        java.util.Date dob = new SimpleDateFormat("yyyy-mm-dd").parse(student.getDOB());
        Date date = new Date(dob.getTime()); 
        command = "UPDATE student"+
                  " SET dob = '"+date+"'"+
                  " WHERE student_id = "+student.getStudentID()+";";
      }else if(updateOption.equals("class and section")){
        command = "SELECT section_id "+
                  " FROM section "+
                  " INNER JOIN batch "+
                  " ON batch.batch_id = section.batch_id"+ 
                  " WHERE section.name = '"+student.getSection()+
                  "' AND class = "+student.getClss()+" ;";
        resultSet = statement.executeQuery(command);
        if(resultSet.next()){
          int sectionID = resultSet.getInt(1);
          command = "UPDATE student"+
                    " SET current_section_id = "+sectionID+
                    " WHERE student_id = "+student.getStudentID()+";";
        }else{
          result.setStatus(false);
          result.addMsg("No class record found for student class and section. ");
          closeConnection();
          return result;
        }
        resultSet.close(); 
      }
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
          result.addMsg("Unable to update student record");
          closeConnection();
          return result;
      }
      result.setStatus(true);
      result.addMsg("Update successfull.");
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while updating student record");
    }
    return result;
  }

  @Override
  public Result delete(Entity obj) {
    student = (Student) obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }
      statement = connection.createStatement();
      command = "DELETE FROM student "+
                "WHERE student_id = "+student.getStudentID()+" ;";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to delete student");
      }else{
        result.setStatus(true);
        result.addMsg("student delete successfull");
      }
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while deleting student record");
    }
    return result;
  }

  @Override
  public Result verify(Entity obj){
    student = (Student)obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }
      statement = connection.createStatement();
      command = "SELECT * FROM student WHERE student_id = "+student.getStudentID()+";";
      resultSet = statement.executeQuery(command);
      if(resultSet.next()){
        result.setStatus(true);
        result.addMsg("Student exists");
      }else{
        result.setStatus(false);
        result.addMsg("Student does not exist. ");
      }
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while verifying student record");
    }
    return result;
  }

  private Integer getSectionId() throws SQLException{
    int clss = student.getClss();
    String year = ((Integer)Calendar.getInstance().get(Calendar.YEAR)).toString();
    char section = student.getSection();
    command = "select section_id from section inner join batch on section.batch_id = batch.batch_id where class ="+clss+" and year = '"+year+"' and name ='"+ section +"';"; 
    resultSet = statement.executeQuery(command);
    if(resultSet.next()){
      return resultSet.getInt("section_id");
    }
    return 0;
  }
  
}