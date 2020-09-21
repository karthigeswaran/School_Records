package com.karthi.school.controller;

import java.util.Scanner;

import com.karthi.school.main.Entity;
import com.karthi.school.main.Section;
import com.karthi.school.recordHandler.RecordHandler;

public class SectionController extends Controller {
  
  public SectionController(Scanner scanner, RecordHandler recordHandler) {
    super(scanner, recordHandler);
  }

  @Override
  public void inputHandler(String option, Entity obj) {
    Section section = (Section) obj;
    if(option.equals("class")){
      section.setClss(getInteger());
    }else if(option.equals("section")){
      section.setSection(getCharacter());
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
