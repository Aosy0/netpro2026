package com.example;

import org.json.JSONObject;

public class JsonSample {
  public static void main(String[] args) {
    JSONObject obj = new JSONObject();
    obj.put("name", "Iwai");
    obj.put("age", 20);
    System.out.println(obj.toString(2));
  }
}