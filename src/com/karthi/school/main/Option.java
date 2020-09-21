package com.karthi.school.main;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Option {
  JSONObject options;

  public Option(String key){
    JSONParser parser = new JSONParser();
    try{
      Object object = parser.parse(new FileReader("src\\com\\karthi\\school\\resources\\configOptions"));
      JSONObject json = (JSONObject)object;
      options = (JSONObject)json.get(key);
      
    }catch(Exception e){
      e.printStackTrace();
    }
      
  }

  public ArrayList<String> getOption(String key){
    ArrayList<String> option = new ArrayList<String>();
    JSONArray result = (JSONArray)options.get(key);
    for(Object obj:result){
      option.add((String)obj);
    }
    return option;
  }

  public ArrayList<Object> getUpdateOption(String key){
    ArrayList<Object> option = new ArrayList<Object>();
    JSONArray result = (JSONArray)options.get(key);
    for(Object obj:result){
      option.add(obj);
    }
    return option;
  }
}
