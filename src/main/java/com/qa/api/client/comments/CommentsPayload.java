package com.qa.api.client.comments;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.api.pojo.Comments;
import com.qa.api.pojo.Posts;
import com.qa.api.utils.ReporterFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author bjha
 */
public class CommentsPayload {

    public Comments createCommentPayload(String inputJsonPath, String postID) throws IOException {

        String content =
                new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/test/resources/testData/"+inputJsonPath)));
        ObjectMapper mapper = new ObjectMapper() ;
        Comments comment  = mapper.readValue(content , Comments.class);
        comment.setPostId(Integer.valueOf(postID));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Request body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock(content, CodeLanguage.JSON));

        return comment;
    }

}
