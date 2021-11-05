package com.blog.blog_app.exceptions;

public class PostDoesNotExistException extends  Exception{
    public PostDoesNotExistException() {
    }

    public PostDoesNotExistException(String message) {
        super(message);
    }

    public PostDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
