package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 */
public class OmikujiHttpServer {

  public static void main(String[] args) throws IOException {
    // ポート8000でサーバーを起動
    var server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/api/omikuji", new OmikujiHandler());
    server.setExecutor(null); // デフォルトのスレッドプール
    server.start();
    System.out.println("🚀 OmikujiServer is running on http://localhost:8000/api/omikuji");
  }

  static class OmikujiHandler implements HttpHandler {
    // おみくじの候補リスト（必ず「大吉・中吉・小吉・吉・末吉・凶」の6つを含むこと）
    private static final List<String> FORTUNES = List.of(
        "大吉", "中吉", "小吉", "吉", "末吉", "凶");

    // おみくじごとのメッセージ（キーと完全一致させること）
    private static final Map<String, String> MESSAGES = Map.of(
        "大吉", "最高の運気。何をやっても吉。",
        "中吉", "穏やかな幸運。焦らず進め。",
        "小吉", "徐々に良くなる兆しあり。",
        "吉", "平凡な日常。小さな喜びを見つけて。",
        "末吉", "行動次第で吉も凶も。慎重に。",
        "凶", "用心せよ。無理は禁物。");

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      // --- 1. メソッドチェック ---
      if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
        // GET 以外なら 405 を返して終了
        exchange.sendResponseHeaders(405, -1);
        return;
      }

      // --- 2. ランダムにおみくじを選択 (『凶』は 1% の確率で返す) ---
      String fortune = selectFortuneWithProbability();
      // TODO: selectFortuneWithProbability() を実装し、以下のいずれかを返すこと
      // 「大吉」「中吉」「小吉」「吉」「末吉」「凶」
      // ・「凶」は全体の 1% の確率
      // ・他の 5 つは残りの 99% を等分してランダム

      // --- 3. メッセージを取得 ---
      String message = MESSAGES.getOrDefault(fortune, "");

      // --- 4. JSON を組み立て ---
      /*
       * 以下のキーを持つ JSONObject を作成すること
       * {
       * "status" : 200,
       * "fortune": fortune,
       * "message": message
       * }
       */
      JSONObject json = new JSONObject();
      // TODO: json.put("status", ...);
      // TODO: json.put("fortune", ...);
      // TODO: json.put("message", ...);
      json.put("status", 200);
      json.put("fortune", fortune);
      json.put("message", message);

      // --- 5. レスポンスを書き出し ---
      byte[] responseBytes = json.toString().getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
      exchange.sendResponseHeaders(200, responseBytes.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(responseBytes);
      }
    }

    /**
     * 〈補助メソッド〉
     * 1% の確率で「凶」を返し、残り 99% を 5 つに等分して返すロジック。
     * このメソッドを完成させること。
     */
    private String selectFortuneWithProbability() {
      // TODO:
      // 1) ThreadLocalRandom.current().nextInt(n) で 0～(n-1) の乱数を生成(10 なら 0から9)
      // 2) 1% "凶" を返す
      // 3) それ以外を 5 つの運勢に振り分ける（各 19.8% ≒ 約19〜20 の範囲）
      // 4) 必ず FORTUNES リストの要素を返すこと
      int random = ThreadLocalRandom.current().nextInt(100);
      if (random == 0) {
        return FORTUNES.get(5);
      } else if (random < 20) {
        return FORTUNES.get(0);
      } else if (random < 40) {
        return FORTUNES.get(1);
      } else if (random < 60) {
        return FORTUNES.get(2);
      } else if (random < 80) {
        return FORTUNES.get(3);
      } else {
        return FORTUNES.get(4);
      }
    }
  }
}