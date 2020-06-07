package com.melnyk.withingstasks.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FileParserTest {

    private FileParser fileParser;

    @Before
    public void setUp() {
        fileParser = new FileParser();
    }

    @Test
    public void parseConversation() {
        int expectedMapSize = 3;
        String filePath = "input.txt";

        Assert.assertEquals(expectedMapSize, fileParser.parseConversations(filePath).size());
    }
}