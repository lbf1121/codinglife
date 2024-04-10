package com.corejava.v2.ch1.p14;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/10
 */
public class ParallelStreams {
    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("./java/src/main/java/com/corejava/v2/gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        // Very bad code ahead
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));

        //Try again-the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));

        // Remedy: Group and count
        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(shortWordCounts);

        // Downstream order not deterministic
        Map<Integer,List<String>> result = wordList.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        result = wordList.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        Map<Integer,Long> wordCounts = wordList.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        System.out.println(wordCounts);
    }
}
