package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class HttpDeleteSample {
  public static void main(String[] args) {
    try {
      JSONObject json = new JSONObject();
      json.put("id", 101);

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("https://httpbin.org/delete"))
          .header("Content-Type", "application/json")
          .method("DELETE", HttpRequest.BodyPublishers.ofString(json.toString()))
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