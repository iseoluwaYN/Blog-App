package com.blog.blog_app.exceptions;

public class PostException extends Exception{
    public PostException() {
    }

    public PostException(String message) {
        super(message);
    }

    public PostException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostException(Throwable cause) {
        super(cause);
    }
}
