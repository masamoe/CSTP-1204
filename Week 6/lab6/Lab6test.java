package lab6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lab6test {
    @Test
    public void testMap() {
        Lab6 lab6 = new Lab6();
        int result = lab6.findUnique("leetcode");
        System.out.println(result);
        assertEquals(0, result);
    }
}