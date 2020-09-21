package com.karthi.school.screens;

import java.util.Scanner;
import java.awt.Toolkit;

import com.karthi.school.view.*;
import com.karthi.school.main.Option;
import com.karthi.school.main.Exam;
import com.karthi.school.recordHandler.ExamRecordHandler;
import com.karthi.school.controller.ExamController;

public class ModifyExamScreen extends Screen{
  private final static String DISPLAY_INFO = "Exam Records.";
  Exam exam = new Exam();
  ExamRecordHandler examRecordHandler = new ExamRecordHandler();
  ExamController examController = new ExamController(scanner, examRecordHandler);
  Option option = new Option("Exam");
  
  public ModifyExamScreen(Scanner scanner) {
    super(scanner,DISPLAY_INFO);
  }

  @Override
  protected void run() {
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new exam record\n2.Fetch a exam record\n3.update a exam record\n4.Delete a exam record\n5.Exit\nEnter option: ");
      Integer opt = getInteger();
      switch(opt){
        case 1:
          CreateView<Exam> createView = new CreateView<Exam>(option, examController, exam, scanner);
          createView.run();
          break;
        case 2:
          ReadView<Exam> readView = new ReadView<Exam>(option, examController, exam, scanner);
          readView.run();
          //System.out.println("Modify Attendance for this exam?(y/n)");
          /*
          if(scanner.next().equals("y")){
            ResultScreen resultScreen = new ResultScreen()
          }
          boolean flag
          */
          break;
        case 3:
          UpdateView<Exam> updateView = new UpdateView<Exam>(option, examController, exam, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView<Exam> deleteView = new DeleteView<Exam>(option, examController, exam, scanner);
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
