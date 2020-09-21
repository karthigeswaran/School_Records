package com.karthi.school.main;

public class Admin extends Entity{
  private String userName;
  private String password;
  
  public Admin(String userName, String password){
    this.userName = userName;
    this.password = password;
  }

  public String getUserName(){
    return userName;
  }

  public String getPassword(){
    return password;
  }

  public void setUserName(String userName){
    this.userName = userName;
  }

  public boolean setPassword(String newPassword, String oldPassword){
    if(oldPassword.equals(password)){
      password = newPassword;
      return true;
    }
    return false;
  }
}
