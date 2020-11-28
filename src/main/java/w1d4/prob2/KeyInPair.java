package w1d4.prob2;

public class KeyInPair {
  private String key;
  private IntPair intPair;

  public KeyInPair(String key) {
    this.key = key;
    this.intPair = new IntPair();
  }

  public String getKey() {
    return key;
  }

  public IntPair getIntPair() {
    return intPair;
  }

  @Override
  public String toString() {
    return "< " + key + " ," + intPair + " >\n";
  }
}
