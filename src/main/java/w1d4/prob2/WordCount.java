package w1d4.prob2;

import java.util.List;

public class WordCount {
  public static final int m = 4;
  public static final int r = 3;
  private Mapper[] mappers;
  private Reducer[] reducers;

  public WordCount() {
    this.mappers = new Mapper[m];
    for(int i = 0; i < m; i++) {
      this.mappers[i] = new Mapper();
    }
    this.reducers = new Reducer[r];
    for(int i = 0; i < r; i++) {
      this.reducers[i] = new Reducer();
    }
  }

  public Mapper[] getMappers() { return mappers; }

  public void buildReducer() {
    int mapperLength = mappers.length;
    int reducerLength = reducers.length;
    for(int im = 0; im < mapperLength; im++) {
      List<KeyInPair> groupByPairs = mappers[im].getGroupByPairs();
      int length = groupByPairs.size();
      String str = "Pairs send from Mapper " + im;
      for(int ir = 0; ir < reducerLength; ir++){
        System.out.println(str + " Reducer " + ir + "");
        for(int i = 0; i < length; i++) {
          KeyInPair keyInPair = groupByPairs.get(i);
          String key = keyInPair.getKey();
          if(ir == getPartition(key)) {
            System.out.print(keyInPair);
            this.reducers[ir].addGroupByIntPair(keyInPair);
          }
        }
      }
    }
  }

  public int getPartition(String key){
    return (int) key.hashCode() % r;
  }

  public void createReducerGroupByPairs() {
    for(int i = 0; i < r; i++) {
      System.out.println("Reducer " + i + " input");
      Reducer reducer = reducers[i];
      reducer.createGroupByIntPairs();
      reducer.printGroupByIntPairs();
    }
  }

  public void doReduce() {
    for(int i = 0; i < r; i++) {
      System.out.println("Reducer " + i + " output");
      Reducer reducer = reducers[i];
      reducer.reduce();
    }
  }
}
