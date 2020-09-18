package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

import com.karthi.school.view.*;
import com.karthi.school.main.Option;
import com.karthi.school.main.Student;
import com.karthi.school.recordHandler.StudentRecordHandler;
import com.karthi.school.controller.StudentController;

public class ModifyStudentScreen extends Screen {
  private final static String DISPLAY_INFO = "Student Records.";
  Student student = new Student();
  Option option = new Option("Student");
  StudentRecordHandler studentRecordHandler = new StudentRecordHandler();
  StudentController studentController = new StudentController(scanner, studentRecordHandler);
  public ModifyStudentScreen(Scanner scanner) {
    super(scanner, DISPLAY_INFO);
  }

  @Override
  protected void run() {
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new student record\n2.Fetch a student record\n3.update a student record\n4.Delete a student record\n5.Exit\nEnter option: ");
      Integer opt = getInteger();
      switch(opt){
        case 1:
          CreateView<Student> createView = new CreateView<Student>(option, studentController, student, scanner);
          createView.run();
          break;
        case 2:
          ReadView<Student> readView = new ReadView<Student>(option, studentController, student, scanner);
          readView.run();
          break;
        case 3:
          UpdateView<Student> updateView = new UpdateView<Student>(option, studentController, student, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView<Student> deleteView = new DeleteView<Student>(option, studentController, student, scanner);
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
