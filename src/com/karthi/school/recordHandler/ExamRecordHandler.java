package com.karthi.school.recordHandler;

import java.sql.SQLException;
import java.util.Calendar;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Exam;

public class ExamRecordHandler extends RecordHandler {
  Exam exam;
  @Override
  public Result create(Entity obj) {
    exam = (Exam)obj;
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
      int batchID = getBatchId();
      int regulationID = getRegulationId();
      if(batchID==0||regulationID==0){
        result.setStatus(false);
        result.addMsg("Class or regulation not found");
        closeConnection();
        return result;
      }
      exam.setBatchID(batchID);
      exam.setRegulationID(regulationID);

      command = "INSERT INTO exam "+
                "(batch_id,exam_name,regulation_id) "+
                "VALUE("+
                exam.getBatchID()+",'"+
                exam.getExamName()+"',"+
                exam.getRegulationID()+");";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to create exam. ");
      }else{
        result.setStatus(true);
        result.addMsg("Created exam successfully. ");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while creating exam. ");
    }
    return result;
  }

  @Override
  public Result delete(Entity obj) {
    exam = (Exam)obj;
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
      int batchID = getBatchId();
      int regulationID = getRegulationId();
      if(batchID==0||regulationID==0){
        result.setStatus(false);
        result.addMsg("Class or regulation not found");
        closeConnection();
        return result;
      }
      exam.setBatchID(batchID);
      exam.setRegulationID(regulationID);

      command = "DELETE FROM exam "+
                "WHERE "+
                " batch_id = "+exam.getBatchID()+","+
                " AND exam_name = '"+exam.getExamName()+"',"+
                " AND regulation_id = "+exam.getRegulationID()+");";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to delete exam. ");
      }else{
        result.setStatus(true);
        result.addMsg("Deleted exam successfully. ");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while deleting exam. ");
    }
    return result;
  }

  @Override
  public Result verify(Entity obj) {
    exam = (Exam)obj;
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
      int batchID = getBatchId();
      int regulationID = getRegulationId();
      if(batchID==0||regulationID==0){
        result.setStatus(false);
        result.addMsg("Class or regulation not found");
        closeConnection();
        return result;
      }
      exam.setBatchID(batchID);
      exam.setRegulationID(regulationID);

      command = "SELECT exam_id FROM exam "+
                "WHERE "+
                " batch_ID = "+exam.getBatchID()+","+
                " AND exam_name = '"+exam.getExamName()+"',"+
                " AND regulation_id = "+exam.getRegulationID()+");";

      resultSet = statement.executeQuery(command);
      if(resultSet.next()){
        result.setStatus(true);
        result.addMsg("record exists. ");
      }else{
        result.setStatus(true);
        result.addMsg("Record doesn't exist. ");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while verifying exam. ");
    }
    return result;
  }
  
  private Integer getBatchId() throws SQLException{
    int clss = exam.getClss();
    String year = ((Integer)Calendar.getInstance().get(Calendar.YEAR)).toString();
    command = "SELECT batch_id "+
              "FROM batch "+
              "WHERE class ="+clss+" and year = '"+year+"';"; 
    resultSet = statement.executeQuery(command);
    if(resultSet.next()){
      return resultSet.getInt("batch_id");
    }
    return 0;
  }

  private Integer getRegulationId() throws SQLException{
    String name = exam.getRegulationName();
    command = "SELECT regulation_id "+
              "FROM regulation "+
              "WHERE year = '"+name+"';"; 
    resultSet = statement.executeQuery(command);
    if(resultSet.next()){
      return resultSet.getInt("regulation_id");
    }
    return 0;
  }

  @Override
  public Result read(Entity obj) {
    return null;
  }

  @Override
  public Result update(Entity obj, String updateOption) {
    return null;
  }
}
