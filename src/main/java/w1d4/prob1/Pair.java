package w1d4.prob1;

public class Pair {
  private final String key;
  private int value;

  public Pair(String key) {
    this.key = key;
    this.value = 1;
  }

  public String getKey() {
    return key;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "< " + key + " , " + value +" >\n";
  }
}
