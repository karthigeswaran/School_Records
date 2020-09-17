package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

import com.karthi.school.view.studentView.*;
import com.karthi.school.Student;

public class ModifyStudentScreen extends Screen {
  private final static String DISPLAY_INFO = "Student Records.";
  Student student;
  public ModifyStudentScreen(Scanner scanner) {
    super(scanner, DISPLAY_INFO);
    
  }

  @Override
  protected void run() {
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new student record\n2.Fetch a student record\n3.update a student record\n4.Delete a student record\n5.Exit\nEnter option: ");
      int option = getInteger();
      switch(option){
        case 1:
          CreateStudentView createView = new CreateStudentView(null, null, student, scanner);
          createView.run();
          break;
        case 2:
          ReadStudentView readView = new ReadStudentView(null, null, student, scanner);
          readView.run();
          break;
        case 3:
          UpdateStudentView updateView = new UpdateStudentView(null, null, student, scanner);
          updateView.run();
          break;
        case 4:
          DeleteStudentView deleteView = new DeleteStudentView(null, null, student, scanner);
          deleteView.run();
          break;
        case 5:
          runFlag = false;
          break;
        default:
          System.out.println("Invalid option.");
          Toolkit.getDefaultToolkit().beep();
      }
    }
  }
  

}
