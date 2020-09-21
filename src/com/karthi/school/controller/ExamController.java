package com.karthi.school.controller;

import java.util.Scanner;

import com.karthi.school.main.Entity;
import com.karthi.school.main.Exam;
import com.karthi.school.recordHandler.RecordHandler;

public class ExamController extends Controller {

  public ExamController(Scanner scanner, RecordHandler recordHandler) {
    super(scanner, recordHandler);
  }

  @Override
  public void inputHandler(String option, Entity obj) {
    Exam exam = (Exam)obj;
    if(option.equals("Exam Name")){
      exam.setExamName(scanner.next());
    }else if(option.equals("class")){
      exam.setClss(getInteger());
    }else if(option.equals("Regulation Name")){
      exam.setRegulationName(scanner.next());
    }
  }

  @Override
  public Result create(Entity obj) {
    return recordHandler.create(obj);
  }

  @Override
  public Result read(Entity obj) {
    return null;
  }

  @Override
  public Result update(Entity obj, String updateOption) {
    return null;
  }

  @Override
  public Result delete(Entity obj) {
    return recordHandler.delete(obj);
  }

  @Override
  protected Result verify(Entity obj) {
    return null;
  }
  
}
