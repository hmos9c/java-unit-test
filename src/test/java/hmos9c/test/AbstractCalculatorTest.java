package hmos9c.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import hmos9c.test.resolver.RandomParameterResolver;

@Extensions({
    @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {

  protected Calculator calculator = new Calculator();

  @BeforeEach
  void setUp() {
    System.out.println("Before each");
  }
}
