Feature: Validating create, update and delete user api

Scenario Outline: Verify to create user and validating the response
	Given user details "<name>"  "<job>" for create user
	When create user using "CreateUser" API
	Then the API post call got success status code 201
	And verify the created user details
	
	Examples:
	|name|job|
	|nico|leader|
	|mike|Tester|
	|carol|Dev|
	
Scenario Outline: Verify to update user and validating the response
	Given update user "<userID>" details with "<name>" "<job>"
	When update user using "UpdateUser" with "<updateType>" API 
	Then the API update call got success status code 200
	And verify the updated user details
	
	Examples:
	|updateType|userID|name|job|
	|put|353|dhinesh2|leader1|
	|patch|353|dhinesh3|leader2|
	
Scenario Outline: Verify to delete the user and validating the status code
	Given delete user "<userID>" details 
	When delete user using "DeleteUser" API 
	Then the API delete call got success status code 204
	
	Examples:
	|userID|
	|353|


	
	