package com.karthi.school.main;

public class Section extends Entity{
  private Character section;
  private Integer clss;
  private Integer sectionID;
  private Integer batchID;

  public void setSection(Character name){
    this.section = name;
  }

  public Character getSection(){
    return section;
  }

  public void setClss(Integer clss){
    this.clss = clss;
  }

  public Integer getClss(){
    return clss;
  }

  public void setSectionID(Integer sectionID){
    this.sectionID = sectionID;
  }

  public Integer getSectionID(){
    return sectionID;
  }

  public void setBatchID(Integer batchID){
    this.batchID = batchID;
  }

  public Integer getBatchID(){
    return batchID;
  }

  public String toString(){
    return section.toString();
  }
}
