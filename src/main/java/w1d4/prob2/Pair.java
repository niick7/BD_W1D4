package w1d4.prob2;

public class Pair {
  private final String key;
  private double value;

  public Pair(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "< " + key + " , " + value +" >\n";
  }
}
