package com.karthi.school;

import java.util.Scanner;

import com.karthi.school.screens.LoginScreen;

public class App{
  Scanner scanner = new Scanner(System.in);
  public static void main(String[] args){
    App app = new App();
    LoginScreen loginScreen = new LoginScreen(app.scanner);
    loginScreen.runner();
    app.scanner.close();
  }
}