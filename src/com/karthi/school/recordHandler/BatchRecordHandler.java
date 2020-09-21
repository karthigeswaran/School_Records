package com.karthi.school.recordHandler;

import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Batch;

public class BatchRecordHandler extends RecordHandler {
  Batch batch;

  @Override
  public Result create(Entity obj) {
    batch = (Batch) obj;
    result = new Result();
    try{
      connection = openConnection();
      
    }catch(Exception e){
      e.printStackTrace();
      result.setStatus(false);
      result.addMsg("Error while creating batch");
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

  @Override
  public Result delete(Entity obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Result verify(Entity obj) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
