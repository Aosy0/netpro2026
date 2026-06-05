package com.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArraySample {
  public static void main(String[] args) {
    JSONArray hobbies = new JSONArray();
    hobbies.put("reading");
    hobbies.put("coding");
    hobbies.put("gaming");

    JSONObject user = new JSONObject();
    user.put("username", "student01");
    // 第2引数で, JsonArray型のhobbiesを渡す
    user.put("hobbies", hobbies);

    System.out.println(user.toString(2));
  }
}