import java.io.*;
import java.util.Scanner;

public class CopyFileExample {
  public static void main(String[] args) {
    File inputFile = new File("input.txt");
    File outputFile = new File("output.txt");

    try (Scanner scanner = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter(outputFile)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        writer.println(line);
      }
    } catch (FileNotFoundException e) {
      System.err.println("ファイルが見つかりません: " + e.getMessage());
    }
  }
}