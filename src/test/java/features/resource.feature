Feature: Validating get resource api

Scenario: Verify to get resource list and validate the response
	When user calls "GetResourceList" API
	Then the API call got success status code 200
	And verify user details in response

Scenario Outline: Verify to get single resource and validate the response
	When user calls "GetResource" API with "<userID>"
	Then the API call got success status code 200
	And verify the userID details in response
	
	Examples:
	| userID |
	| 2 |
	| 8 |
	
Scenario Outline: Try to get single resource with invalid userID
	When user calls "GetResource" API with "<userID>"
	Then the API call got error status code 404
	
	Examples:
	| userID |
	| 23 |

