package com.melnyk.withingstasks.task2;

import com.melnyk.withingstasks.task1.Searcher;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FileParser {

    public static final String REGEX_EXP = "(\\[.*?\\])(.*)";
    private final static Logger logger = Logger.getLogger(FileParser.class);

    /**
     * a method which parses this file and sort the conversations by identifier
     *
     * @param filePath
     * @return
     */
    public Map<String, List<String>> parseConversations(String filePath) {
        File file = new File(filePath);
        Map<String, List<String>> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line;
                 (line = br.readLine()) != null; ) {
                Pattern pattern = Pattern.compile(REGEX_EXP);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String chatId = matcher.group(1);
                    String message = matcher.group(2);
                    if (map.containsKey(chatId)) {
                        map.get(chatId).add(message);
                    } else {
                        map.put(chatId, Stream.of(message).collect(toList()));
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Cannot read a file.");
        }
        return map;

    }
}
