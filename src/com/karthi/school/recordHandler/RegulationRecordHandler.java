package com.karthi.school.recordHandler;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Regulation;

public class RegulationRecordHandler extends RecordHandler {
  Regulation regulation;
  @Override
  public Result create(Entity obj) {
    regulation = (Regulation)obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("Datebase connection error. ");
        closeConnection();
        return result;
      }
      statement = connection.createStatement();
      command = "INSERT INTO regulation(year) "+
                "VALUE('"+regulation.getRegulationName()+"');";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("regulation creation failed.");
      }else{
        result.setStatus(true);
        result.addMsg("Successfully created regulation.");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while creating regulation.");
    }
    return result;
  }

  @Override
  public Result delete(Entity obj) {
    regulation = (Regulation)obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection == null){
        result.setStatus(false);
        result.addMsg("Database connection error.");
        closeConnection();
        return result;
      }

      statement = connection.createStatement();
      command = "DELETE FROM regulation"+
                "WHERE year = '"+regulation.getRegulationName()+"';";
      int rowCount = statement.executeUpdate(command);
      if(rowCount==0){
        result.setStatus(false);
        result.addMsg("Unable to delete regulation.");
      }else{
        result.setStatus(true);
        result.addMsg("Successfully deleted regulation.");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while deleting regulation.");
    }
    return result;
  }

  @Override
  public Result verify(Entity obj) {
    regulation = (Regulation)obj;
    result = new Result();
    try{
      connection = openConnection();
      if(connection==null){
        result.setStatus(false);
        result.addMsg("Database connection error.");
        closeConnection();
        return result;
      }

      statement = connection.createStatement();
      command = "SELECT regulation_id "+
                "FROM regulation "+
                "WHERE year = '"+regulation.getRegulationName()+"';";
      resultSet = statement.executeQuery(command);
      if(resultSet.next()){
        regulation.setRegulationID(resultSet.getInt(1));
        result.setStatus(true);
        result.addMsg("Regulation exists.");
      }else{
        result.setStatus(false);
        result.addMsg("Regulation doesn't exists.");
      }
      closeConnection();
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while verifying regulation.");
    }
    return result;
  }

  @Override
  public Result read(Entity obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Result update(Entity obj, String updateOption) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
