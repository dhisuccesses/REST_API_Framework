Feature: Validating user registration api

Scenario Outline: Verify to register the user and validating the response status code
	Given user details "<email>"  "<password>" for register user
	When register the user using "Register" API
	Then the API register call got success status code 200
	
	Examples:
	|email|password|
	|eve.holt@reqres.in|pistol|

Scenario: Try to register the user without password
	Given user details "eve.holt@reqres.in" for register user
	When register the user using "Register" API
	Then the API register call got error status code 400
	And validate the error message
	