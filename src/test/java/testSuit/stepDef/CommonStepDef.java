package testSuit.stepDef;

import com.aventstack.extentreports.Status;
import com.google.inject.Inject;
import com.qa.api.utils.ReporterFactory;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import testSuit.utils.TestContext;

@Slf4j
public class CommonStepDef {

    @Inject
    TestContext testContext;

    private Response response;

    @Given("start new scenario")
    public void newReq() {
        testContext.setReqId(testContext.generateReqId());
    }



    @Given("retrieve the response object from response context with key {string}, retrieve value from path {string} and store it in {string}")
    public void storeJsonPathValueToContext(String responseContextKey, String jsonpath, String contextKey) {
        String extractedValue = testContext.getNewResponseContext().get(responseContextKey).getString(jsonpath);
        testContext.getContextValues().putIfAbsent(contextKey,extractedValue);
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"Extracted value from response body : " + extractedValue);
    }


}
