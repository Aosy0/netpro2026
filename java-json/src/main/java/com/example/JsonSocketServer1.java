package com.example;

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class JsonSocketServer1 {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(12345);
      System.out.println("Server started...");

      Socket socket = serverSocket.accept();
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      JSONObject json = new JSONObject();
      json.put("message", "Hello from Server");
      json.put("status", "OK");

      out.println(json.toString());
      socket.close();
      serverSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}