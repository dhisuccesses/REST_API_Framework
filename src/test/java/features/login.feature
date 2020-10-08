Feature: Validating user login api

Scenario Outline: Verify to login user and validating the response status code
	Given user details "<email>"  "<password>" for login user
	When login user using "Login" API
	Then the API login call got success status code 200
	
	Examples:
	|email|password|
	|eve.holt@reqres.in|cityslicka|

Scenario: Try to register the user without password
	Given user details "eve.holt@reqres.in" for login user
	When login user using "Login" API
	Then the API login call got error status code 400
	And validate the login error message
	