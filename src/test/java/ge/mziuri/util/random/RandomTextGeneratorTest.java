package ge.mziuri.util.random;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RandomTextGeneratorTest {
    @Before
    public void beforeTest() {
        System.out.println("Executing test case for RandomTextGeneratorTest...");
    }

    @After
    public void afterTest() {
        System.out.println("Executed test case for RandomTextGeneratorTest...");
    }

    @Test
    public void lengthTest(){
        int length = 7;
        String randomText = RandomTextGenerator.generateRandomString(length);
        Assert.assertEquals(length, randomText.length());
    }

    @Test
    public void randomTest(){
        Set<String> textHashSet = new HashSet<>();
        int length = 127;
        for (int i = 0; i < length; i++) {
            String randomText=RandomTextGenerator.generateRandomString(10);
            textHashSet.add(randomText);
        }
        Assert.assertEquals(length, textHashSet.size());
    }
}
