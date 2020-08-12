
//The service will handle GET requests  , the GET request should return 200 OK response with JSON in the body.
package com.example.restservice.demo;

public class  Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}