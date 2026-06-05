package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class DoubleNumberHttpServer {

  public static void main(String[] args) throws IOException {
    var server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/api/double", exchange -> {
      String query = exchange.getRequestURI().getQuery();
      int number = 0;

      if (query != null && query.startsWith("number=")) {
        try {
          number = Integer.parseInt(query.substring(7));
        } catch (NumberFormatException e) {
          // デフォルト値0を使用
        }
      }

      String response = String.valueOf(number * 2);
      byte[] responseBytes = response.getBytes();

      exchange.getResponseHeaders().set("Content-Type", "text/plain");
      exchange.sendResponseHeaders(200, responseBytes.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(responseBytes);
      }
    });
    server.setExecutor(null);
    server.start();
    System.out.println("Server: http://localhost:8000/api/double?number=10");
  }
}