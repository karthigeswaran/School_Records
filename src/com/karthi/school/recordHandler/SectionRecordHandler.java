package com.karthi.school.recordHandler;

import java.sql.SQLException;
import java.util.Calendar;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Section;

public class SectionRecordHandler extends RecordHandler {
  Section section;

  @Override
  public Result create(Entity obj) {
    section = (Section)obj;
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
      
      section.setBatchID(getBatchId());
      command = "INSERT INTO section"+
                "(name,batch_id) "+
                "VALUE ( '"+
                section.getSection()+"', "+
                section.getBatchID()+
                " );";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to create new section");
      }
      else{
        result.setStatus(true);
        result.addMsg("Successfully created");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error occured while creating section record");
    }
    return result;
  }

  @Override
  public Result delete(Entity obj) {
    section = (Section)obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }
      command = "DELETE FROM section"+
                "WHERE section_id = "+section.getSectionID()+
                " ;";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to delete section");
      }
      else{
        result.setStatus(true);
        result.addMsg("Successfully deleted");
      }
      closeConnection();
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error occured while deleting section record");
    }
    return result;
  }

  @Override
  public Result verify(Entity obj) {
    section = (Section)obj;
    Result result =new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("DataBase Connection failed. Contact engineer");
        closeConnection();
        return result;
      }

      int n = getBatchId();
      if(n==0){
        result.setStatus(false);
        result.addMsg("Class does not exist.");
        closeConnection();
        return result;
      }
      section.setBatchID(n);
      command = "SELECT section_id "+
                "FROM section "+
                "WHERE batch_id = "+section.getBatchID()+
                " AND name = "+section.getSection()+";";
      resultSet = statement.executeQuery(command);
      if(resultSet.next()){
        section.setSectionID(resultSet.getInt(1));
        result.setStatus(true);
        result.addMsg("Section exist from given class");
      }else{
        result.setStatus(false);
        result.addMsg("Section not found");
      }
    }catch(Exception e){
      result.setStatus(false);
      result.addMsg("Error while verifying section details");
    }
    return result;
  }

  private Integer getBatchId() throws SQLException{
    Integer clss = section.getClss();
    String year = ((Integer)Calendar.getInstance().get(Calendar.YEAR)).toString();
    command = "SELECT batch_id " +
              "FROM batch "+
              "WHERE class = "+clss+" and year = '"+year+"' ;"; 
    resultSet = statement.executeQuery(command);
    if(resultSet.next()){
      return resultSet.getInt("batch_id");
    }
    return 0;
  } 
    
  @Override
  public Result read(Entity obj) {
    return result;
  }

  @Override
  public Result update(Entity obj, String updateOption) {
    return result;
  }
  
}
