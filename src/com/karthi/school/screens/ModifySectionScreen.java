package com.karthi.school.screens;

import java.util.Scanner;

import java.awt.Toolkit;

import com.karthi.school.view.*;
import com.karthi.school.main.Option;
import com.karthi.school.main.Section;
import com.karthi.school.recordHandler.SectionRecordHandler;
import com.karthi.school.controller.SectionController;

public class ModifySectionScreen extends Screen{
  private final static String DISPLAY_INFO = "Section Records.";
  Section section = new Section();
  SectionRecordHandler sectionRecordHandler = new SectionRecordHandler();
  SectionController sectionController = new SectionController(scanner, sectionRecordHandler);
  Option option = new Option("Section");
  
	public ModifySectionScreen(Scanner scanner) {
    super(scanner,DISPLAY_INFO);
  }

  @Override
  protected void run(){
    boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new section record\n2.Fetch a section record\n3.update a section record\n4.Delete a section record\n5.Exit\nEnter option: ");
      Integer opt = getInteger();
      switch(opt){
        case 1:
          CreateView<Section> createView = new CreateView<Section>(option, sectionController, section, scanner);
          createView.run();
          break;
        case 2:
          ReadView<Section> readView = new ReadView<Section>(option, sectionController, section, scanner);
          readView.run();
          //System.out.println("Modify Attendance for this section?(y/n)");
          /*
          if(scanner.next().equals("y")){
            ResultScreen resultScreen = new ResultScreen()
          }
          boolean flag
          */
          break;
        case 3:
          UpdateView<Section> updateView = new UpdateView<Section>(option, sectionController, section, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView<Section> deleteView = new DeleteView<Section>(option, sectionController, section, scanner);
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
