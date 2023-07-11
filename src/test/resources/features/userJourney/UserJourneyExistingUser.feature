Feature: User Journey Existing User which will create new post and add new comments
  User Journey Existing User which will create new post and add new comments API scenarios

  @UserJourneyExistingUser01  @All
  Scenario: UserJourneyExistingUser01
  Existing user which will create new post and add new comments
    Given start new scenario
    When A existing user '1' create posts with input json from path 'createPosts/scenario1/input/requestBody.json' and store the response in the Test context with key 'create_post_scenario1_response'
    Then retrieve the response object from response context with key 'create_post_scenario1_response' and validate response code should be '201'
    And retrieve the response object from response context with key 'create_post_scenario1_response' and response body should be '/createPosts/scenario1/output/responseBody.json' ignoring all extra fields
    Given retrieve the response object from response context with key 'create_user_scenario1_response', retrieve value from path 'id' and store it in 'PostIdValue'
    When A user comments on a post which is extracted from test context with key 'PostIdValue' uses input json from path 'createComments/scenario1/input/requestBody.json' and store the response in the Test context with key 'create_comment_scenario1_response'
    Then retrieve the response object from response context with key 'create_comment_scenario1_response' and validate response code should be '201'
    And retrieve the response object from response context with key 'create_comment_scenario1_response' and response body should be '/createComments/scenario1/output/responseBody.json' ignoring all extra fields

  @UserJourneyExistingUser02  @All
  Scenario: UserJourneyExistingUser02
  Existing user comments on existing post
    Given start new scenario
    When A user comments on an existing post '1' uses input json from path 'createComments/scenario1/input/requestBody.json' and store the response in the Test context with key 'create_comment_scenario1_response'
    Then retrieve the response object from response context with key 'create_comment_scenario1_response' and validate response code should be '201'
    And retrieve the response object from response context with key 'create_comment_scenario1_response' and response body should be '/createComments/scenario1/output/responseBody.json' ignoring all extra fields

