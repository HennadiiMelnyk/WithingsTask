package com.melnyk.withingstasks;

import com.melnyk.withingstasks.task1.Searcher;
import com.melnyk.withingstasks.task2.FileParser;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Searcher searcher = new Searcher();
        String encoded = "49 20 6c 6f 76 65 20 57 69 74 68 69 6e 67 73";
        String nonEncoded = "Withings";
        int result = searcher.findIndexOfCharFromNonEncodedString(encoded, nonEncoded);
        System.out.println(result);
        FileParser fileParser = new FileParser();
        Map<String, List<String>> resultMap = fileParser.parseConversations("input.txt");
        resultMap.forEach((k, v) -> System.out.println(k + v));
    }
}

