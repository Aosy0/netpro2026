package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPostSample {
  public static void main(String[] args) {
    try {
      String form = "username=student&password=12345";

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("https://httpbin.org/post"))
          .header("Content-Type", "application/x-www-form-urlencoded")
          .POST(HttpRequest.BodyPublishers.ofString(form))
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