package com.example;

import org.json.JSONObject;

public class CreateJsonObject {
  public static void main(String[] args) {
    JSONObject person = new JSONObject();
    person.put("name", "Taro"); // "name": "Taro"
    person.put("age", 21); // "age": 2
    person.put("student", true); // "student": true

    System.out.println(person.toString(2));
  }
}