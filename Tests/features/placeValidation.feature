Feature: Validating Place API's



Scenario: Verify if Place is added successfully using addPlace API
Given Add Place Payload
When user calls "AddPlaceAPI" with Post http request
Then the API call is successlly with status code 200
And "status" in response body is "OK"



      