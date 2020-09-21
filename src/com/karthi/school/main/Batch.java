package com.karthi.school.main;

public class Batch extends Entity{
  private Integer clss;
  private Integer batchID;
  private String year;
  
  public void setClss(Integer clss){
    this.clss = clss;
  }

  public Integer getClss(){
    return clss;
  }

  public void getBatchID(Integer batchID){
    this.batchID = batchID;
  }

  public Integer setBatchID(){
    return batchID;
  }

  public void setYear(String year){
    this.year = year;
  }

  public String getYear(){
    return year;
  }
}
