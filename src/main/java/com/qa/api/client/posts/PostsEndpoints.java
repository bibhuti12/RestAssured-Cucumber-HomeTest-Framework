package com.qa.api.client.posts;

/**
 * @author bjha
 */
public enum PostsEndpoints {

    POSTS("/posts");

    private String path;
    PostsEndpoints(String path){
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
