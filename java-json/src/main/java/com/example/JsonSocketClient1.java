package com.example;

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class JsonSocketClient1 {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 12345);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      String received = in.readLine();
      JSONObject json = new JSONObject(received);

      System.out.println("Received\n" + json.toString(2));
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}