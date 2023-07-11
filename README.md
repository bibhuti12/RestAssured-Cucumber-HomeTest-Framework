# NOTE :- The tests will fail as resource will not be really updated on the server but it will be faked as if.

# RestAssured-Cucumber-HomeTest-Framework
RestAssured cucumber HomeTest framework



# Test execution
* Test application: `https://jsonplaceholder.typicode.com/`

## We can execute the test in different ways
* Locally
    * Through maven
        * `mvn clean test` to execute test through maven.
        * To execute specific tags from command line we can use mvn test -> `-Dcucumber.filter.tags="@All"`
    * Through the `TestSuitRunner.java` class

In any point the execution in framework is start from `runners.TestSuitRunner.java` class. Test that need to execute are defined in the features files present in the Features folder, The set of test cases are identified by appropriate tag name using the tags section in TestRunner class.

# Test reporting:
**Suit level configuration:**
Test report high level(suit level) configured will be done through `@BeforeClass` and `@AfterClass` annotations of TestNG inside TestRunner class. each scenario wise step will be added to report through `stepDef.Hooks`
**Scenario level configuration:**
We only have to create test in extend report in the scenario level configuration that is done using `@Before`
**Step level configuration:**
For test step status management are using listener class named `com.utils.TestListener` which implements cucumber plugin `ConcurrentEventListener`. Using this plugin we are managing the status of the test cases by monitoring test steps. We are handling three main status **FAILED, PASSED, SKIPPED**. Since we have all the steps in `stepDef` package, we added request response and other related details to report through the same classes in the package.
# Context sharing
All the features which are common in scenario level like **responseContext, reqBodyContext, contextValues, requestBuilder, configuration and wiremock server** are done through `com.utils.TestContext`. i.e. During the execution if we want to share the data between steps or scenarios, we need to use TestContext.
* TestContext is marked with `@ScenarioScoped`, so the class will have separate copy of instance for each scenario
* We are using google-guice for DI