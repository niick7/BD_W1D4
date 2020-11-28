package w1d4.prob2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Mapper {
  private static final String splitBySpaceOrMinusSign = "[\\s-]+";
  private static final String fileExceptionMessage = "An error occurred.";
  private static final String isNumberOrContainUnderscoreMatcherRegex = "[0-9]|_";
  List<KeyInPair> keyInPairs;
  public Mapper() {
    this.keyInPairs = new ArrayList<>();
  }

  public void map(String fileName) {
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while(scanner.hasNext()) {
        String line = scanner.nextLine();
        System.out.println(line);
        List<String> wordsInLine = Arrays.asList(line.split(splitBySpaceOrMinusSign));
        for(String word : wordsInLine) {
          word = trimWord(word);
          if(isWord(word)) {
            String firstWordLetter = String.valueOf(word.charAt(0)).toLowerCase();
            KeyInPair keyInPair = getGroupByPairByKey(firstWordLetter);
            if(keyInPair == null) {
              KeyInPair gbp = new KeyInPair(firstWordLetter);
              IntPair intPair = gbp.getIntPair();
              intPair.setKey(word.length());
              intPair.setValue(1);
              keyInPairs.add(gbp);
            } else {
              IntPair intPair = keyInPair.getIntPair();
              intPair.setKey(intPair.getKey() + word.length());
              intPair.setValue(intPair.getValue() + 1);
            }
          }
        }
      }
    }
    catch(FileNotFoundException e) {
      System.out.println(fileExceptionMessage);
      e.printStackTrace();
    }
  }

  public static String trimWord(String word) {
    word = word.replace(",", "");
    word = word.replace(".", "");
    word = word.replace("\"", "");
    word = word.replace("\'", "");
    return word;
  }

  public static boolean isWord(String word){
    if ("".equals(word) || Pattern.compile(isNumberOrContainUnderscoreMatcherRegex).matcher(word).find()
      || "mumedu".equals(word))
      return false;
    return true;
  }

  public List<KeyInPair> getGroupByPairs() { return keyInPairs; }

  public List<KeyInPair> sortGroupByPair() {
    keyInPairs.sort(Comparator.comparing(KeyInPair::getKey));
    return keyInPairs;
  }

  public KeyInPair getGroupByPairByKey(String key) {
    for(KeyInPair keyInPair : keyInPairs) {
      if(keyInPair.getKey().equals(key))
        return keyInPair;
    }

    return null;
  }

  @Override
  public String toString() {
    String str = "\n";

    for(KeyInPair keyInPair : keyInPairs) {
      str += keyInPair;
    }
    return str;
  }
}
