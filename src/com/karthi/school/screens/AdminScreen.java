package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

public class AdminScreen extends Screen{
  private final static String DISPLAY_INFO = "Welcome Admin.";
  
  public AdminScreen(Scanner scanner){
    super(scanner,DISPLAY_INFO);
  }
  
  @Override
  protected void run() {
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Modify Student\n2.Modify Section\n3.Modify Exam\n4.Modify Regulation\n5.Modify Batch\n6.Exit\nEnter option: ");
      int option = getInteger();
      switch(option){
        case 1:
          System.out.println("Accessing Student Records...");
          ModifyStudentScreen studentScreen = new ModifyStudentScreen(scanner);
          studentScreen.runner();
          break;
        case 2:
          System.out.println("Accessing Section Records...");
          ModifySectionScreen sectionScreen = new ModifySectionScreen(scanner);
          sectionScreen.runner();
          break;
        case 3:
          System.out.println("Accessing Exam Records...");
          ModifyExamScreen examScreen = new ModifyExamScreen(scanner);
          examScreen.runner();
          break;
        case 4:
          System.out.println("Accessing Regulation Records...");
          ModifyRegulationScreen regulationScreen = new ModifyRegulationScreen(scanner);
          regulationScreen.runner();
          break;
        case 5:
          System.out.println("Accessing Batch Records...");
          ModifyBatchScreen batchScreen = new ModifyBatchScreen(scanner);
          regulationScreen.runner();
          break;
        case 6:
          runFlag = false;
          break;
        default:
          System.out.println("Enter valid option");
          Toolkit.getDefaultToolkit().beep();
      }
    } 
  }
}
