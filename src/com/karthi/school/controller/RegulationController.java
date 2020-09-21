package com.karthi.school.controller;

import java.util.Scanner;

import com.karthi.school.main.Entity;
import com.karthi.school.recordHandler.RecordHandler;
import com.karthi.school.main.Regulation;

public class RegulationController extends Controller {

  public RegulationController(Scanner scanner, RecordHandler recordHandler) {
    super(scanner, recordHandler);
  }

  @Override
  public void inputHandler(String option, Entity obj) {
    Regulation regulation = (Regulation) obj;
    if(option.equals("Regulation Name")){
      regulation.setRegulationName(scanner.next());
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
