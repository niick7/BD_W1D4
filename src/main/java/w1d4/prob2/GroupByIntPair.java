package w1d4.prob2;

import java.util.ArrayList;
import java.util.List;

public class GroupByIntPair {
  private String key;
  private List<IntPair> intPairs;

  public GroupByIntPair(String key) {
    this.key = key;
    this.intPairs = new ArrayList<>();
  }

  public String getKey() {
    return key;
  }

  public List<IntPair> getIntPairs() {
    return intPairs;
  }

  public void addIntPair(IntPair intPair) {
    this.intPairs.add(intPair);
  }

  @Override
  public String toString() {
    return "< " + key + " ," + intPairs + " >\n";
  }
}
