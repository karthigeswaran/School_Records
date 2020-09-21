package com.karthi.school.view;

import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Option;

public class ReadView<T> {
  Option option;
  Controller controller;
  Entity obj;
  Scanner scanner;
  Result result;
  
  public ReadView(Option option, Controller controller,Entity obj, Scanner scanner) {
    this.option = option;
    this.controller = controller;
    this.obj = obj;
    this.scanner = scanner;
  }

  public void run() {
    for(String opt:option.getOption("readOptions")){
      System.out.print("Enter "+opt+": ");
      controller.inputHandler(opt,obj);
    }
    Result result = controller.read(obj);
    System.out.println(result.getMsg());
    if(result.getStatus()){
      System.out.println(obj);
    }
  }

}
