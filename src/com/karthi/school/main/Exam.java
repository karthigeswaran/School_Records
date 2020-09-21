package com.karthi.school.main;

public class Exam extends Entity{
  private Integer examID;
  private String examName;
  private Integer batchID;
  private Integer regulationID;
  private Integer clss;
  private String regulationName;

  public void setExamID(Integer examID){
    this.examID = examID;
  }

  public Integer getExamID(){
    return examID;
  }

  public void setExamName(String examName){
    this.examName = examName;
  }

  public String getExamName(){
    return examName;
  }

  public void setBatchID(Integer batchID){
    this.batchID = batchID;
  }

  public Integer getBatchID(){
    return batchID;
  }

  public void setRegulationID(Integer regulationID){
    this.regulationID = regulationID;
  }

  public Integer getRegulationID(){
    return regulationID;
  }

  public void setClss(Integer clss){
    this.clss = clss;
  }

  public Integer getClss(){
    return clss;
  }
  public void setRegulationName(String regulationName){
    this.regulationName = regulationName;
  }

  public String getRegulationName(){
    return regulationName;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Exam name: ");
    sb.append(examName);
    sb.append("\nclass: ");
    sb.append(clss);
    sb.append("\nRegulation Name: ");
    sb.append(regulationName);
    return sb.toString();
  }
}
