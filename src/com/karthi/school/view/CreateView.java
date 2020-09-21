package com.karthi.school.view;

import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.controller.Result;
import com.karthi.school.main.Option;
import com.karthi.school.main.Entity;

public class CreateView<T> {
  Option option;
  Controller controller;
  Entity obj;
  Scanner scanner;

  public CreateView(Option option, Controller controller, Entity obj, Scanner scanner) {
    this.controller = controller;
    this.option = option;
    this.obj = obj;
    this.scanner = scanner;
  }

  public void run() {
    boolean status = false;
    do{
      for(String opt:option.getOption("createOptions")){
        System.out.print("Enter "+opt+": ");
        controller.inputHandler(opt,obj);
      }
      Result result = controller.create(obj);
      status = result.getStatus();
      System.out.println(result.getMsg());
    }while(!status);
  }
  
}
