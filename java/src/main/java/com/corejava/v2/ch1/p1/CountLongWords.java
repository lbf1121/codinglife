package com.corejava.v2.ch1.p1;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/4/8
 */
public class CountLongWords {
    public static void main(String[] args) throws Exception {
        // 方法1：项目根目录：是codinglife下目录
        System.out.println(System.getProperty("user.dir"));
        // 方法2：项目根目录
        File root = new File("");
        System.out.println(root.getAbsolutePath());

        // 方法1：获取字节码文件（Class文件）所在目录
        root = new File(CountLongWords.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(root.getAbsolutePath());
        // 方法2：获取字节码文件（Class文件）所在目录
        ClassLoader classLoader = CountLongWords.class.getClassLoader();
        URL resouce = classLoader.getResource("");
        System.out.println(resouce.getPath());

        String path = "./java/src/main/java/com/corejava/v2/gutenberg/alice30.txt";
        String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));   //\\PL+：非字母分隔符

        long start = System.currentTimeMillis();
        long count = 0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - start);
        System.out.println("................");

        start = System.currentTimeMillis();
        count = words.stream().filter(w -> w.length() > 12).count();
        end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - start);
        System.out.println("................");

        start = System.currentTimeMillis();
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - start);
    }
}
