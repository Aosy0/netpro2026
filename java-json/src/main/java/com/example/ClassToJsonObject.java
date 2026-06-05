package com.example;

import org.json.JSONObject;

public class ClassToJsonObject {
  public static void main(String[] args) {
    UserEntity user = new UserEntity("iwai", 20, true);
    System.out.println(user.toJSON().toString(2));
  }
}

class UserEntity {
  String name;
  int age;
  boolean student;

  public UserEntity(String name, int age, boolean student) {
    this.name = name;
    this.age = age;
    this.student = student;
  }

  public JSONObject toJSON() {
    JSONObject json = new JSONObject();
    json.put("name", name);
    json.put("age", age);
    json.put("student", student);
    return json;
  }
}