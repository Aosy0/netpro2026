package com.example;

import org.json.JSONObject;

public class ParseFromString {
  public static void main(String[] args) {
    // 文字列中の""は, \でエスケープする必要がある
    String jsonString = "{\"title\":\"Java\",\"pages\":350}";
    JSONObject book = new JSONObject(jsonString);

    System.out.println("Title: " + book.getString("title"));
    System.out.println("Pages: " + book.getInt("pages"));
  }
}