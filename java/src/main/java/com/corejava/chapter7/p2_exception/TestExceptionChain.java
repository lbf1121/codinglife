package com.corejava.chapter7.p2_exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/26
 */
public class TestExceptionChain {

    static void testExcep() throws Throwable {
        try {
            throw new Exception("cannot connect db.....");
        } catch (Exception e) {
//            throw new ServletException("database error:"+e.getMessage());
            Throwable se = new ServletException("database error");
            se.initCause(e);
            throw se;
        }
    }

    static void testTryFinally() throws Exception {
        try {
            throw new Exception("cannot connect db.....");
        } finally {
            System.out.println("抛出前，先执行我");
        }
    }

    static long testFinally(long n) {
        try {
            long r = n * n;
            return r;
        } finally {
            if (n == 2) {
                return 0;
            }
        }
    }

    static void testDoubleException() throws Exception{
        try {
            try{
                throw new Exception("cannot connect db.....");
            }catch(Exception e){
                throw e;
            }
        }finally {
            try{
                throw new Exception("finally exception.....");
            }catch(Exception e){
                throw e;
            }
        }
    }

    static void testTryWithResources(){
        String userPath = System.getProperty("user.home");
        System.out.println(userPath);
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String classesRootPath = Class.class.getClass().getResource("/").getPath();
        System.out.println(classesRootPath);
        String classPath = TestExceptionChain.class.getResource("").getPath();
        System.out.println(classPath);
        // 当前目录至：项目根目录
        File file = new File(classesRootPath+"/curl.txt");
        System.out.println(file.getAbsolutePath());
        try(Scanner in = new Scanner(new FileInputStream(file))){
            while(in.hasNext()){
                System.out.println(in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try{
//            testExcep();
//        } catch (Throwable e) {
//            System.out.println(e.fillInStackTrace());
//            System.out.println("==========");
//            Throwable se = e.getCause();
//            se.printStackTrace();
//        }

//        try {
//            testTryFinally();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println(testFinally(3));
//        System.out.println(testFinally(2));

//        try{
//            testDoubleException();
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        testTryWithResources();
    }
}
