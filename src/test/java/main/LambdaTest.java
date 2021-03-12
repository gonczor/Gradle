package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LambdaTest {
    @Test
    public void testLambdaGreetings() {
        Lambda l = new Lambda();
        Assertions.assertEquals("Hello, world!", l.getGreetings());
    }
}
