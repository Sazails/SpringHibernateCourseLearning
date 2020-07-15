package org.sazails.Spring_Boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeTestTests {

    @Test
    public void AddTest(){
        SomeTest test = new SomeTest();
        int[] temp = new int[] { 4, 3 };
        Assertions.assertEquals(7, test.add(temp));
    }

    @Test
    public void GetWeirdStringTest(){
        SomeTest test = new SomeTest();
        Assertions.assertEquals("YOchoo", test.getWeirdString());
    }
}
