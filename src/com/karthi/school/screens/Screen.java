package com.karthi.school.screens;

import java.util.Scanner;

abstract public class Screen {
  Scanner scanner;
  String displayInfo;
  
  public Screen(Scanner scanner,String displayInfo){
    this.scanner = scanner;
    this.displayInfo = displayInfo;
  }
  
  protected void display(){
    if(displayInfo.equals("")){
      throw new RuntimeException("Display message is empty. Unable to display.");
    }
    System.out.println(displayInfo);
  }
  
  abstract protected void run();

  public void runner(){
    display();
    run();
  }

  protected int getInteger(){
    scanner.nextLine();
    return scanner.nextInt();
  }
}
