package com.example;

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class JsonSocketServer2 {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(12345);
      Socket socket = serverSocket.accept();

      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      JSONObject received = new JSONObject(in.readLine());
      System.out.println("Client sent\n" + received.toString(2));

      JSONObject reply = new JSONObject();
      reply.put("response", "Hello, " + received.getString("name"));
      out.println(reply.toString());

      socket.close();
      serverSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}