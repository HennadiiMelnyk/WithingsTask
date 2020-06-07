package com.melnyk.withingstasks.task1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SearcherTest {
    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"49 20 6c 6f 76 65 20 57 69 74 68 69 6e 67 73", "Withings", 7},
                {"57 69 74 68 69 6e 67 73 20 68 69 72 65 64 20 6d 65", "Withings", 0},
                {"9 20 65 61 74 20 70 61 73 74 61", "eat",  2}
        });
    }

    public String encoded;
    public String nonEncoded;
    public int expectedIndex;
    private Searcher searcher;

    public SearcherTest(String encoded, String nonEncoded, int expectedIndex){
        this.encoded = encoded;
        this.nonEncoded = nonEncoded;
        this.expectedIndex = expectedIndex;
    }

    @Before
    public void setUp() {
        searcher = new Searcher();
    }

    @Test
    public void findIndexOfCharFromNonEncodedStringTest(){
        int result = searcher.findIndexOfCharFromNonEncodedString(encoded, nonEncoded);

        Assert.assertEquals(result, expectedIndex);
    }
}