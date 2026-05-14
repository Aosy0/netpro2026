import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class WordResponse {
  private Map<Character, String> words = new HashMap<>();

  public WordResponse() {
    words.put('あ', "あさひ");
    words.put('い', "いろは");
    words.put('う', "うえの");
    words.put('え', "えいご");
    words.put('お', "おおさか");

    words.put('か', "かわせ");
    words.put('き', "きって");
    words.put('く', "くらぶ");
    words.put('け', "けしき");
    words.put('こ', "こども");

    words.put('さ', "さくら");
    words.put('し', "しんぶん");
    words.put('す', "すずめ");
    words.put('せ', "せかい");
    words.put('そ', "そろばん");

    words.put('た', "たばこ");
    words.put('ち', "ちどり");
    words.put('つ', "つるかめ");
    words.put('て', "てがみ");
    words.put('と', "とうきょう");

    words.put('な', "なごや");
    words.put('に', "にほん");
    words.put('ぬ', "ぬまづ");
    words.put('ね', "ねずみ");
    words.put('の', "のはら");

    words.put('は', "はがき");
    words.put('ひ', "ひこうき");
    words.put('ふ', "ふじさん");
    words.put('へ', "へいわ");
    words.put('ほ', "ほけん");

    words.put('ま', "まっち");
    words.put('み', "みかさ");
    words.put('む', "むせん");
    words.put('め', "めいじ");
    words.put('も', "もみじ");

    words.put('や', "やまと");
    words.put('ゆ', "ゆみや");
    words.put('よ', "よしの");

    words.put('ら', "らじお");
    words.put('り', "りんご");
    words.put('る', "るすい");
    words.put('れ', "れんげ");
    words.put('ろ', "ろーま");

    words.put('わ', "わらび");
    words.put('ゐ', "いど");
    words.put('を', "おわり");
  }

  public char getFirstChar(String str) {
    String normalized = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    return normalized.charAt(0);
  }

  public char getLastChar(String str) {
    String normalized = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    return normalized.charAt(normalized.length() - 1);
  }

  public String getWord(String str) {
    if (str == null || str.isEmpty()) {
      return "文字が入力されていません";
    }

    char c = getLastChar(str);
    char searchChar = Character.toUpperCase(c);

    return words.getOrDefault(searchChar, "error");
  }
}
