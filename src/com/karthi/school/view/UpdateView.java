package com.karthi.school.view;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.controller.Result;
import com.karthi.school.main.Entity;
import com.karthi.school.main.Option;


public class UpdateView<T> {
  Option option;
  Controller controller;
  Entity obj;
  Scanner scanner;
  
  public UpdateView(Option option, Controller controller, Entity obj, Scanner scanner) {  
    this.option = option;
    this.controller = controller;
    this.obj = obj;
    this.scanner = scanner;
  }

  public void run(){
    ArrayList<Object> optionList = option.getUpdateOption("updateOptions");
    
    String optionOne = (String)optionList.get(0);
    System.out.print("Enter "+optionOne+": ");
    controller.inputHandler(optionOne,obj);
    
    //get update option from user
    @SuppressWarnings("unchecked")
    Map<String,String> optionMap = (Map<String,String>)optionList.get(1);
    System.out.println("Update options");
    for(String key:optionMap.keySet()){
      System.out.println(key+":"+optionMap.get(key));
    }
    System.out.print("Enter option: ");
    boolean runFlag = true;
    String updateOption = "";
    while(runFlag){
      updateOption = optionMap.get(scanner.next());
      if(updateOption==null){
        System.out.println("Enter valid option.");
      }else{
        runFlag = false;
      }
    }
    System.out.print("Enter "+updateOption+": ");
    controller.inputHandler(updateOption,obj);
    Result result = controller.update(obj,updateOption);
    System.out.println(result.getMsg());
  }
}
