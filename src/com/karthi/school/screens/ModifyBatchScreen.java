package com.karthi.school.screens;

import java.util.Scanner;
import java.awt.Toolkit;

import com.karthi.school.view.*;
import com.karthi.school.main.Option;
import com.karthi.school.main.Batch;
import com.karthi.school.recordHandler.BatchRecordHandler;
import com.karthi.school.controller.BatchController;

public class ModifyBatchScreen extends Screen {
  private final static String DISPLAY_INFO = "Batch Records.";
  Batch batch = new Batch();
  BatchRecordHandler batchRecordHandler = new BatchRecordHandler();
  BatchController batchController = new BatchController(scanner, batchRecordHandler);
  Option option = new Option("Batch");
  
  public ModifyBatchScreen(Scanner scanner, String displayInfo) {
    super(scanner, displayInfo);
  }

  @Override
  protected void run() {
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new batch record\n2.Fetch a batch record\n3.update a batch record\n4.Delete a batch record\n5.Exit\nEnter option: ");
      Integer opt = getInteger();
      switch(opt){
        case 1:
          CreateView<Batch> createView = new CreateView<Batch>(option, batchController, batch, scanner);
          createView.run();
          break;
        case 2:
          ReadView<Batch> readView = new ReadView<Batch>(option, batchController, batch, scanner);
          readView.run();
          //System.out.println("Modify Attendance for this batch?(y/n)");
          /*
          if(scanner.next().equals("y")){
            ResultScreen resultScreen = new ResultScreen()
          }
          boolean flag
          */
          break;
        case 3:
          UpdateView<Batch> updateView = new UpdateView<Batch>(option, batchController, batch, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView<Batch> deleteView = new DeleteView<Batch>(option, batchController, batch, scanner);
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
