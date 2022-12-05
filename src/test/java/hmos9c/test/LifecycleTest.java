package hmos9c.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

  private String temp;

  @Test
  void testA() {
    temp = "Sanas";
  }

  @Test
  void testB() {
    System.out.println(temp);
  }
}
