package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class HttpPostJson {
  public static void main(String[] args) {
    try {
      JSONObject student = new JSONObject();
      student.put("id", 101);
      student.put("name", "Taro Yamada");
      student.put("email", "taro@example.com");

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("https://httpbin.org/post"))
          .header("Content-Type", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(student.toString()))
          .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      System.out.println("ステータスコード: " + response.statusCode());
      System.out.println("レスポンスボディ");
      System.out.println(response.body());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}