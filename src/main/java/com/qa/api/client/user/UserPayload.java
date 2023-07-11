package com.qa.api.client.user;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.api.pojo.Users;
import com.qa.api.utils.ReporterFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author bjha
 */
public class UserPayload {

    public Users createUserPayload(String inputJsonPath) throws IOException {

        String content =
                new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/test/resources/testData/"+inputJsonPath)));
        ObjectMapper mapper = new ObjectMapper() ;
        Users user  = mapper.readValue(content , Users.class);
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Request body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock(content, CodeLanguage.JSON));

        return user;
    }

}
