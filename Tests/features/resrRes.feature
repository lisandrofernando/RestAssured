Feature: Validate ReqRes API's


Scenario: Verify ReqRes API's are working as expected
    Given Add ReqRes API Payload
    When User calls AddReqResAPI with Post http request
    Then The API call is successfully with status code 201
    And "name" in the response body is "morpheus"