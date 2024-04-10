package com.corejava.v1.chapter7.p2_exception;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/26
 */
public class ServletException extends RuntimeException{
    public ServletException() {
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }
}
