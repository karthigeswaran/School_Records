package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

import com.karthi.school.view.*;
import com.karthi.school.Option;
import com.karthi.school.Student;
import com.karthi.school.controller.StudentController;

public class ModifyStudentScreen extends Screen {
  private final static String DISPLAY_INFO = "Student Records.";
  Student student = new Student();
  Option option = new Option("Student");
  StudentRecordHandler studentRecordHandler = new StudentRecordHandler()
  StudentController studentController = new StudentController(scanner, studentRecordHandler);
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
          CreateView<Student> createView = new CreateView(null, null, student, scanner);
          createView.run();
          break;
        case 2:
          ReadView readView = new ReadView(null, null, student, scanner);
          readView.run();
          break;
        case 3:
          UpdateView updateView = new UpdateView(null, null, student, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView deleteView = new DeleteView(null, null, student, scanner);
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
