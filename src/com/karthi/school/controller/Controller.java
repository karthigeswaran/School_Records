package com.karthi.school.controller;

import java.util.Scanner;

import com.karthi.school.recordHandler.RecordHandler;
import com.karthi.school.main.Entity;

public abstract class Controller{
  String option;
  Scanner scanner;
  RecordHandler recordHandler;
  
  public Controller(Scanner scanner,RecordHandler recordHandler){
    this.scanner = scanner;
    this.recordHandler = recordHandler;
  }

  protected Integer getInteger(){
    scanner.nextLine();
    return scanner.nextInt();
  }

  protected Character getCharacter(){
    return scanner.next().toCharArray()[0];
  }

  public abstract void inputHandler(String option,Entity obj);
  public abstract Result create(Entity obj);
  public abstract Result read(Entity obj);
  public abstract Result update(Entity obj);
  public abstract Result delete(Entity obj);
  
}
