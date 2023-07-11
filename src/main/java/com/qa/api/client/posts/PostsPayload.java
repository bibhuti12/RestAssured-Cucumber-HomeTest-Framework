package com.qa.api.client.posts;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.api.pojo.Posts;
import com.qa.api.pojo.Users;
import com.qa.api.utils.ReporterFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author bjha
 */
public class PostsPayload {

    public Posts createPostPayload(String inputJsonPath, String userID) throws IOException {

        String content =
                new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/test/resources/testData/"+inputJsonPath)));
        ObjectMapper mapper = new ObjectMapper() ;
        Posts post  = mapper.readValue(content , Posts.class);
        post.setUserId(Integer.valueOf(userID));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Request body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock(content, CodeLanguage.JSON));

        return post;
    }

}
