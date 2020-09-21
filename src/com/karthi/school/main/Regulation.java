package com.karthi.school.main;

public class Regulation extends Entity{
  private String regulationName;
  private Integer regulationID;
  
  public void setRegulationName(String name){
    regulationName = name;
  }

  public String getRegulationName(){
    return regulationName;
  }

  public void setRegulationID(Integer id){
    regulationID = id;
  }

  public Integer getRegulationID(){
    return regulationID;
  }

}
