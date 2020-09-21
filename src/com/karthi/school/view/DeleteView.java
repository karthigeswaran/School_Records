package com.karthi.school.view;

import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.controller.Result;
import com.karthi.school.main.Option;
import com.karthi.school.main.Entity;


public class DeleteView<T>{
  Option option;
  Controller controller;
  Entity obj;
  Scanner scanner;

  public DeleteView(Option option, Controller controller, Entity obj, Scanner scanner) {
    this.option = option;
    this.controller = controller;
    this.obj = obj;
    this.scanner = scanner;
  }

  public void run() {
    for(String opt:option.getOption("deleteOptions")){
      System.out.print("Enter "+opt+": ");
      controller.inputHandler(opt,obj);
    }
    Result result = controller.delete(obj);
    System.out.println(result.getMsg());
  }

}
