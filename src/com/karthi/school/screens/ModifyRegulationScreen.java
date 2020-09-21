package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

import com.karthi.school.view.*;
import com.karthi.school.main.Option;
import com.karthi.school.main.Regulation;
import com.karthi.school.recordHandler.RegulationRecordHandler;
import com.karthi.school.controller.RegulationController;

public class ModifyRegulationScreen extends Screen{
	private final static String DISPLAY_INFO = "Regulation Records.";
  Regulation regulation = new Regulation();
  RegulationRecordHandler regulationRecordHandler = new RegulationRecordHandler();
  RegulationController regulationController = new RegulationController(scanner, regulationRecordHandler);
  Option option = new Option("Regulation");
	
	public ModifyRegulationScreen(Scanner scanner) {
		super(scanner, DISPLAY_INFO);
	}

	@Override
	protected void run() {
		boolean runFlag = true;
    while(runFlag){
      System.out.print("1.Create a new regulation record\n2.Fetch a regulation record\n3.update a regulation record\n4.Delete a regulation record\n5.Exit\nEnter option: ");
      Integer opt = getInteger();
      switch(opt){
        case 1:
          CreateView<Regulation> createView = new CreateView<Regulation>(option, regulationController, regulation, scanner);
          createView.run();
          break;
        case 2:
          ReadView<Regulation> readView = new ReadView<Regulation>(option, regulationController, regulation, scanner);
          readView.run();
          System.out.println("Modify Subject for this regulation?(y/n)");
          /*
          if(scanner.next().equals("y")){
            ResultScreen resultScreen = new ResultScreen()
          }
          boolean flag
          */
          break;
        case 3:
          UpdateView<Regulation> updateView = new UpdateView<Regulation>(option, regulationController, regulation, scanner);
          updateView.run();
          break;
        case 4:
          DeleteView<Regulation> deleteView = new DeleteView<Regulation>(option, regulationController, regulation, scanner);
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
