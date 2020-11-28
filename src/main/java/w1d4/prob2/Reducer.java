package w1d4.prob2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Reducer {
  private List<KeyInPair> keyInPairs;
  private List<GroupByIntPair> groupByIntPairs;

  public Reducer() {
    this.keyInPairs = new ArrayList<>();
  }

  public void reduce() {
    List<Pair> pairs = new ArrayList<>();
    for(GroupByIntPair g : groupByIntPairs) {
      Pair pair = new Pair(g.getKey());
      double value = 0;
      double sum = 0;
      int times = 0;
      for(IntPair intPair : g.getIntPairs()) {
        sum += intPair.getKey();
        times += intPair.getValue();
      }
      pair.setValue(sum/times);
      pairs.add(pair);
    }

    for(Pair p : pairs) {
      System.out.print(p);
    }
  }

  public List<KeyInPair> getGroupByPairs() {
    return keyInPairs;
  }

  public void addGroupByIntPair(KeyInPair keyInPair) {
    this.keyInPairs.add(keyInPair);
  }

  public List<KeyInPair> sortPair() {
    keyInPairs.sort(Comparator.comparing(KeyInPair::getKey));
    return keyInPairs;
  }

  public void createGroupByIntPairs() {
    List<GroupByIntPair> groupByIntPairs = new ArrayList<>();
    String tempKey = "";
    GroupByIntPair tempGroupByIntPair = new GroupByIntPair(tempKey);
    for(KeyInPair keyInPair : sortPair()) {
      String key = keyInPair.getKey();
      GroupByIntPair groupByIntPair = new GroupByIntPair(key);
      if(!tempKey.equals(key)) {
        groupByIntPairs.add(groupByIntPair);
        tempKey = key;
        tempGroupByIntPair = groupByIntPair;
      } else {
        groupByIntPair = tempGroupByIntPair;
      }
      groupByIntPair.addIntPair(keyInPair.getIntPair());
    }
    this.groupByIntPairs = groupByIntPairs;
  }

  public void printGroupByIntPairs() {
    for(GroupByIntPair groupByIntPair : groupByIntPairs) {
      System.out.print(groupByIntPair);
    }
  }
}
