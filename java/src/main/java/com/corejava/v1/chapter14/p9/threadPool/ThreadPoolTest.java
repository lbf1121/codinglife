package com.corejava.v1.chapter14.p9.threadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author liubf
 * @date 2024/4/7
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /Users/firecrow/Desktop/files)：");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile)：");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(new File(directory),keyword,pool);
            Future<Integer> resutl = pool.submit(counter);

            try{
                System.out.println(resutl.get()+" matching files.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
