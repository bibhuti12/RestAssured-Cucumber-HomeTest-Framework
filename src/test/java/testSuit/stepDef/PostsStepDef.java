package testSuit.stepDef;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.inject.Inject;
import com.jayway.jsonpath.JsonPath;
import com.qa.api.client.posts.PostsPayload;
import com.qa.api.client.posts.PostsRequest;
import com.qa.api.client.user.UserPayload;
import com.qa.api.client.user.UserRequest;
import com.qa.api.core.response.IResponse;
import com.qa.api.utils.ReporterFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testSuit.utils.TestContext;

public class PostsStepDef {

    @Inject
    TestContext testContext;


    @When("A user extracted from test context with key {string} create posts with input json from path {string} and store the response in the Test context with key {string}")
    public void createPost(String testContextKey , String inputJsonPath, String contextKey) throws Exception {
        IResponse response = new PostsRequest().createPost(new PostsPayload().createPostPayload(inputJsonPath, testContext.getContextValues().get(testContextKey)));
        testContext.getNewResponseContext().put(contextKey,response);

        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response code",
                String.valueOf(testContext.getNewResponseContext().get(contextKey).status())));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response headers", response.getHeaders().toString()));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Response body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,
                MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON));
    }

    @When("A existing user {string} create posts with input json from path {string} and store the response in the Test context with key {string}")
    public void createPostWithExistingUser(String userID , String inputJsonPath, String contextKey) throws Exception {
        IResponse response = new PostsRequest().createPost(new PostsPayload().createPostPayload(inputJsonPath, userID));
        testContext.getNewResponseContext().put(contextKey,response);

        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response code",
                String.valueOf(testContext.getNewResponseContext().get(contextKey).status())));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response headers", response.getHeaders().toString()));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Response body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,
                MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON));
    }
}
