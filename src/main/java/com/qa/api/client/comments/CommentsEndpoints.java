package com.qa.api.client.comments;

/**
 * @author bjha
 */
public enum CommentsEndpoints {

    COMMENTS("/comments");

    private String path;
    CommentsEndpoints(String path){
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
