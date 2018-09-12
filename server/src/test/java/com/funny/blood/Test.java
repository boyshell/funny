package com.funny.blood;

public class Test {
  @org.junit.Test
  public void test() {
    //    List<String> list = Lists.newArrayList("a", "b", "c", "d");
    //    System.out.println(list);
    double base = 1000000.0f;
    double p = 0.20f;
    for (int i = 0; i < 11; ++i) {
      System.out.printf("第%d年:%.2f元\n", i, base);
      base = base + base * p;
    }
  }
}
