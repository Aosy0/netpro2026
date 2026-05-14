import java.util.HashMap;
import java.util.Map;

public class WordResponse {
  private Map<Character, String> words = new HashMap<>();

  public WordResponse() {
    words.put('A', "Alpha");
    words.put('B', "Bravo");
    words.put('C', "Charlie");
    words.put('D', "Delta");
    words.put('E', "Echo");
    words.put('F', "Foxtrot");
    words.put('G', "Golf");
    words.put('H', "Hotel");
    words.put('I', "India");
    words.put('J', "Juliett");
    words.put('K', "Kilo");
    words.put('L', "Lima");
    words.put('M', "Mike");
    words.put('N', "November");
    words.put('O', "Oscar");
    words.put('P', "Papa");
    words.put('Q', "Quebec");
    words.put('R', "Romeo");
    words.put('S', "Sierra");
    words.put('T', "Tango");
    words.put('U', "Uniform");
    words.put('V', "Victor");
    words.put('W', "Whiskey");
    words.put('X', "X-ray");
    words.put('Y', "Yankee");
    words.put('Z', "Zulu");


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

  public String getWord(char c) {
    char searchChar = Character.toUpperCase(c);

    // getOrDefaultメソッドを使うと、Mapに登録されていない文字が入力されたときの返答を設定できる
    return words.getOrDefault(searchChar, "該当なし");
  }
}
