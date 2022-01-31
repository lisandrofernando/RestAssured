Feature: Validating Place API's



Scenario Outline: Verify if Place is added successfully using addPlace API
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is successlly with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify placeID created maps to "<name>" using "getPlaceAPI"

Examples:
      | name           | language | address           |
      | Ecatepec House | english  | Colonia Ecatepec  |
   #   |San Pedro House | Spanish  | Colonia San Pedro |