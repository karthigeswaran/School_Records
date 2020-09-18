package com.karthi.school.controller;

import java.util.Date;
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
    if(option == "name"){
      student.setName(scanner.next());
    }else if(option == "class"){
      student.setClss(getInteger());
    }else if(option == "section"){
      student.setSection(getCharacter());
    }else if(option == "dob(yyyy-mm-dd)"){
      student.setDOB(new Date(scanner.next()));
    }else if(option == "id"){
      student.setID(getInteger());
    }

  }

  @Override
  public Result create(Entity obj) {
    return recordHandler.create(obj);
  }

  @Override
  public Result read(Entity obj) {
    return recordHandler.read(obj);
  }

  @Override
  public Result update(Entity obj) {
    return recordHandler.update(obj);
  }

  @Override
  public Result delete(Entity obj) {
    return recordHandler.delete(obj);
  }

  
}
