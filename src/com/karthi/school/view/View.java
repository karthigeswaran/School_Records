package com.karthi.school.view;

import java.util.Scanner;

import com.karthi.school.controller.Controller;
import com.karthi.school.main.Option;

abstract public class View<T> {
  Option option;
  Controller controller;
  T t;
  Scanner scanner;

  public View(Option option,Controller controller,T t,Scanner scanner){
    this.option = option;
    this.controller = controller;
    this.t = t;
    this.scanner = scanner;
  }

  abstract public void run();
}