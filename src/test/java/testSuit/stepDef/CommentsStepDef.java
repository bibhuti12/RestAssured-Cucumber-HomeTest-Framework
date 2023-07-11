package testSuit.stepDef;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.inject.Inject;
import com.qa.api.client.comments.CommentsPayload;
import com.qa.api.client.comments.CommentsRequest;
import com.qa.api.client.posts.PostsPayload;
import com.qa.api.client.posts.PostsRequest;
import com.qa.api.core.response.IResponse;
import com.qa.api.utils.ReporterFactory;
import io.cucumber.java.en.When;
import testSuit.utils.TestContext;

public class CommentsStepDef {

    @Inject
    TestContext testContext;


    @When("A user comments on a post which is extracted from test context with key {string} uses input json from path {string} and store the response in the Test context with key {string}")
    public void createComments(String testContextKey , String inputJsonPath, String contextKey) throws Exception {
        IResponse response = new CommentsRequest().createComment(new CommentsPayload().createCommentPayload(inputJsonPath, testContext.getContextValues().get(testContextKey)));
        testContext.getNewResponseContext().put(contextKey,response);

        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response code",
                String.valueOf(testContext.getNewResponseContext().get(contextKey).status())));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response headers", response.getHeaders().toString()));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Response body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,
                MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON));
    }

    @When("A user comments on an existing post {string} uses input json from path {string} and store the response in the Test context with key {string}")
    public void createCommentsOnExistingPost(String testContextKey , String inputJsonPath, String contextKey) throws Exception {
        IResponse response = new CommentsRequest().createComment(new CommentsPayload().createCommentPayload(inputJsonPath, testContext.getContextValues().get(testContextKey)));
        testContext.getNewResponseContext().put(contextKey,response);

        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response code",
                String.valueOf(testContext.getNewResponseContext().get(contextKey).status())));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response headers", response.getHeaders().toString()));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Response body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,
                MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON));
    }
}
