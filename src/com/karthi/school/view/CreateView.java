package com.karthi.school.view;

import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.controller.Result;
import com.karthi.school.Option;

public class CreateView<T> {
  Option option;
  Controller controller;
  T t;
  Scanner scanner;

  public CreateView(Option option, Controller controller, T t, Scanner scanner) {
    this.controller = controller;
    this.option = option;
    this.t = t;
    this.scanner = scanner;
  }

  public void run() {
    boolean status = false;
    do{
      for(String opt:option.getOption()){
        System.out.print("Enter "+opt+": ");
        controller.inputHandler(opt,t);
      }
      Result result = controller.create(t);
      status = result.getStatus();
      System.out.println(result.getMsg());
    }while(!status);
  }
  
}
