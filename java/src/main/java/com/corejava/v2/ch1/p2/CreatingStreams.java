package com.corejava.v2.ch1.p2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/9
 */
public class CreatingStreams {
    // 非字母分隔符：预编译避免重复编译同一个正则表达式，从而提升程序的执行效率。
    private static Pattern NON_LETTER_DELIMITER = Pattern.compile("\\PL+");

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("./java/src/main/java/com/corejava/v2/gutenberg/alice30.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        // 将字符串分隔成单词
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);
        Stream<String> silence = Stream.empty();
        show("silence", silence);

        // 无限流：无限个Echo字符串
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        // 无限流：无限个随机数
        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        // 无限流：它会接受一个“种子”值，以及一个函数，并且会反复地将该函数应用到之前的结果上
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay = NON_LETTER_DELIMITER.splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        // Files.lines：返回一个包含了文件中所有行的Stream，整行读取，每条数据为一行字符串
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 只展示10个元素，其他的采用...代替，不足10个的则全部展示 */
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");

        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            if (i < SIZE) {
                System.out.print(firstElements.get(i));
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }
}
