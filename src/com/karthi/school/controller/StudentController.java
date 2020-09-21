package com.karthi.school.controller;

import java.util.Scanner;

import com.karthi.school.main.Entity;
import com.karthi.school.main.Student;
import com.karthi.school.recordHandler.RecordHandler;

public class StudentController extends Controller {
  
  public StudentController(Scanner scanner, RecordHandler recordHandler) {
    super(scanner, recordHandler);
  }

  @Override
  public void inputHandler(String option, Entity obj) {
    Student student = (Student) obj;
    if(option.equals("name")){
      student.setName(scanner.next());
    }else if(option.equals("class")){
      student.setClss(getInteger());
    }else if(option.equals("section")){
      student.setSection(getCharacter());
    }else if(option.equals("dob(yyyy-mm-dd)")){
     student.setDOB(scanner.next());
    }else if(option.equals("studentID")){
      student.setStudentID(getInteger());
    }else if(option.equals("class and section")){
      System.out.println("Enter class: ");
      student.setClss(getInteger());
      System.out.println("Enter section: ");
      student.setSection(getCharacter());
    }
  }

  @Override
  public Result create(Entity obj) {
    Result result = verify(obj);
    if(!result.getStatus()){
      result.setStatus(true);
      result.merge(recordHandler.create(obj));
    }else{
      result.addMsg("Entry exists. ");
    }
    return result;
  }

  @Override
  public Result read(Entity obj) {
    Result result = verify(obj);
    if(result.getStatus()){
      result.merge(recordHandler.read(obj));
    }else{
      result.addMsg("Entry does not exists. ");
    }
    return result;
  }

  @Override
  public Result update(Entity obj,String updateOption) {
    Result result = verify(obj);
    if(result.getStatus()){
      result.merge(recordHandler.update(obj,updateOption));
    }else{
      result.addMsg("Entry does not exists. ");
    }
    return result;
  }

  @Override
  public Result delete(Entity obj) {
    Result result = verify(obj);
    if(result.getStatus()){
      result.merge(recordHandler.delete(obj));
    }else{
      result.addMsg("Entry does not exists. ");
    }
    return result;
  }

  @Override
  protected Result verify(Entity obj){
    return recordHandler.verify(obj);
  }
}
