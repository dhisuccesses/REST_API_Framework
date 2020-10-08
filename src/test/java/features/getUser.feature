Feature: Validating get user api

Scenario: Verify to get user list and validate the response
	When user calls "GetUserList" API
	Then the API call got success status code 200
	And verify user details in response

Scenario Outline: Verify to get single user and validate the response
	When user calls "GetUser" API with "<userID>"
	Then the API call got success status code 200
	And verify the userID details in response
	
	Examples:
	| userID |
	| 2 |
	| 8 |
	
Scenario Outline: Verify to get single user with invalid userID
	When user calls "GetUser" API with "<userID>"
	Then the API call got error status code 404
	
	Examples:
	| userID |
	| 23 |

Scenario Outline: Verify to get user list with given delay
	When user calls "DELAY" API with delay "<delaySeconds" 
	Then the API call got success status code 200

	Examples:
	| delaySeconds |
	| 3 |
