package com.example;

import org.json.JSONObject;

public class NestedJsonObject {
  public static void main(String[] args) {
    JSONObject address = new JSONObject();
    address.put("city", "Tokyo");
    address.put("zip", "100-0001");

    JSONObject person = new JSONObject();
    person.put("name", "Masayuki");
    // 第2引数で, JSONObject型のaddressを渡す
    person.put("address", address);

    System.out.println(person.toString(2));
  }
}