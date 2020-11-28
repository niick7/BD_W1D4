package w1d4.prob2;

public class IntPair {
  private int key = 1;
  private int value = 1;

  public IntPair() {
  }

  public void setKey(int key) {
    this.key = key;
  }
  public int getKey() {
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
    return " [ " + key + ", " + value +" ]";
  }
}
