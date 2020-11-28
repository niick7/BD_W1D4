package w1d4.prob2;

public class Prob2 {
  public static void main(String[] args) {
    WordCount wordCount = new WordCount();
    System.out.println("Number of Input-Splits: " + WordCount.m);
    System.out.println("Number of Reducers: " + WordCount.r);
    for(int i = 0; i < WordCount.m; i++) {
      System.out.println("Mapper " + i + " Input:");
      Mapper mapper = new Mapper();
      mapper.map("assets/prob2/input" + (i + 1) + ".txt");
      wordCount.getMappers()[i] = mapper;
    }
    for(int i = 0; i < WordCount.m; i++) {
      Mapper mapper = wordCount.getMappers()[i];
      System.out.println("Mapper " + i + " Output: " + mapper);
    }
    wordCount.buildReducer();
    wordCount.createReducerGroupByPairs();
    wordCount.doReduce();
  }
}
