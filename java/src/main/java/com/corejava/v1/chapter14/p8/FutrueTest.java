package com.corejava.v1.chapter14.p8;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

/**
 *
 * @author liubf
 * @date 2024/4/7
 */
public class FutrueTest {

    public static void main(String[] args){
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /Users/firecrow/Desktop/files)：");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile)：");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory),keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();

            try{
                System.out.println(task.get()+" matching files.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
