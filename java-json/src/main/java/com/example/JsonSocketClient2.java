package com.example;

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class JsonSocketClient2 {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 12345);

      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      JSONObject send = new JSONObject();
      send.put("name", "iwai");
      out.println(send.toString());

      JSONObject response = new JSONObject(in.readLine());
      System.out.println("Server response\n" + response.toString(2));

      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}