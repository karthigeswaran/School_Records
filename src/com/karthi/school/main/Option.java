package com.karthi.school.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Option {
  private ArrayList<String> option;
  
  public Option(String key){
    option = new ArrayList<String>();
    JSONParser parser = new JSONParser();
    try{
      Object object = parser.parse(new FileReader("src\\com\\karthi\\school\\resources\\configOptions"));
      JSONObject json = (JSONObject)object;
      JSONArray jsonArray = (JSONArray)json.get(key);
      for(int i=0; i<jsonArray.size(); i++){
        option.add((String)jsonArray.get(i));
      }
    }catch(Exception e){
      e.printStackTrace();
    }
      
  }

  public ArrayList<String> getOption(){
    return option;
  }
}
