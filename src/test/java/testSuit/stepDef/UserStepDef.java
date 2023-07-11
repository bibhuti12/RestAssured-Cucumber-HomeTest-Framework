package testSuit.stepDef;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.inject.Inject;
import com.jayway.jsonpath.JsonPath;
import com.qa.api.client.user.UserPayload;
import com.qa.api.client.user.UserRequest;
import com.qa.api.core.response.IResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.qa.api.utils.ReporterFactory;
import testSuit.utils.TestContext;

public class UserStepDef {

    @Inject
    TestContext testContext;



    @When("I create user with input json from path {string} and store the response in the Test context with key {string}")
    public void createUser(String inputJsonPath, String contextKey) throws Exception {
        IResponse response = new UserRequest().createUser(new UserPayload().createUserPayload(inputJsonPath));
        testContext.getNewResponseContext().put(contextKey,response);

        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response code",
                String.valueOf(testContext.getNewResponseContext().get(contextKey).status())));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO, MarkupHelper.createCodeBlock("Response headers", response.getHeaders().toString()));
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Response body");
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,
                MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON));
    }
}
