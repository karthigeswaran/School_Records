package com.karthi.school.screens;

import java.awt.Toolkit;
import java.util.Scanner;

import com.karthi.school.recordHandler.UserRecordHandler;

public class LoginScreen extends Screen {
  private static final String DISPLAY_INFO = "School Records Application.";

  public LoginScreen(Scanner scanner) {
    super(scanner, DISPLAY_INFO);

  }

  @Override
  protected void run() {
    System.out.print("Enter user name: ");
    String userName = scanner.next();
    System.out.print("Enter password: ");
    String password = scanner.next();
    UserRecordHandler userRecord = new UserRecordHandler();
    int option = userRecord.verifyUser(userName,password);
    switch(option){
      case 1:
        System.out.println("Admin user.\nRedirecting to admin menu...");
        AdminScreen adminScreen = new AdminScreen(scanner);
        adminScreen.runner();
        break;
      case 2:
        System.out.println("Student user.\nRedirecting to student menu...");
        StudentScreen studentScreen = new StudentScreen(scanner);
        studentScreen.runner();
        break;
      default:
        System.out.println("User undefined. Contact Admin.");
        Toolkit.getDefaultToolkit().beep();
    } 
  }
}
