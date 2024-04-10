package com.corejava.v2.ch1.p13;

import com.algorithm.edu.princeton.cs.algs4.In;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/10
 */
public class PrimitiveTypeStreams {

    public static void main(String[] args) throws Exception {
        DoubleStream is0 = DoubleStream.generate(() -> Math.random() * 100);
        show("is0",is0);

        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1",is1);
        IntStream is2 = IntStream.range(5,10);
        show("is2",is2);
        IntStream is3 = IntStream.rangeClosed(5,10);
        show("is3",is3);

        Path path = Paths.get("./java/src/main/java/com/corejava/v2/gutenberg/alice30.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        IntStream is4 = words.mapToInt(String::length);
        show("is4",is4);

        // \uD835\uDD46 is the UTF-16 encoding of the letter 𝕆,unicode U+1D546
        String sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println(sentence);
        // The stream with hex values
        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c->String.format("%X ",c)).collect(Collectors.joining()));

        Stream<Integer> integers = IntStream.range(0,100).boxed();
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5",is5);

    }

    public static void show(String title, IntStream stream) {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0) {
                System.out.println(",");
            }
            if (i < SIZE) {
                System.out.print(firstElements[i]);
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }

    public static void show(String title, DoubleStream stream) {
        final int SIZE = 10;
        double[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0) {
                System.out.println(",");
            }
            if (i < SIZE) {
                System.out.print(firstElements[i]);
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }
}
