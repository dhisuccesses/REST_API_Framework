package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import cucumber.api.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class UserStepDefinition extends Utils  {
	
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	String userIDValue = "";
	String userName = "";
	TestDataBuild data =new TestDataBuild();
	@When("user calls {string} API")
	public void user_calls_by_using(String resource) throws IOException {	
	    // To get users list API call
		APIResources resourceAPI=APIResources.valueOf(resource);
		res=given().spec(requestSpecification());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response =res.when().get(resourceAPI.getResource());
		response.prettyPrint();
	}
	
	@Then("the API call got success status code {int}")
	public void the_API_call_got_success_status_code(Integer int1) {
	    // To validate status code
		assertEquals(response.getStatusCode(),200);	
	}
	
	@Then("verify user details in response")
	public void verify_user_details_in_response() {
	    // To validate data values
		JsonPath jsonResponse = response.jsonPath();
		String  dataValue = jsonResponse.getString("data");
		if(!dataValue.equals("[]"))
		{
			assertEquals(dataValue,dataValue);
		}
		else{
			assertEquals("valid data value","[]");
		}
	}
	
	@When("user calls {string} API with {string}")
	public void user_calls_API_with(String resource, String userID) throws IOException {
	    // To get single user API call
		userIDValue = userID;
		APIResources resourceAPI=APIResources.valueOf(resource);
		res=given().spec(requestSpecification());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response =res.when().get(resourceAPI.getResource()+userID);
		response.prettyPrint();
	}	
	
	@Then("verify the userID details in response")
	public void verify_the_userID_details_in_response() {
	    // // To validate userID
		JsonPath jsonResponse = response.jsonPath();
		String  userId = jsonResponse.getString("data.id");
		assertEquals(userId,userIDValue);
	}
	
	@Then("the API call got error status code {int}")
	public void the_API_call_got_error_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),404);
		
	
	}
	
	@Given("user details {string}  {string} for create user")
	public void user_details_for_create_user(String name, String job) throws IOException {
	    // To get predefined data
		userName = name;
		 res=given().spec(requestSpecification())
					.body(data.userPayLoad(name,job));
	}
	
	@When("create user using {string} API")
	public void create_user_using_API(String resource) {
	    // To create user post API Call
		APIResources resourceAPI=APIResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response =res.when().post(resourceAPI.getResource());
		 response.prettyPrint();
		
	}

	@Then("the API post call got success status code {int}")
	public void the_API_post_call_got_success_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),201);
	}

	@Then("verify the created user details")
	public void verify_the_created_user_details() {
	    // To validate user details
		JsonPath jsonResponse = response.jsonPath();
		String  name = jsonResponse.getString("name");
		assertEquals(name,userName);
	}

	@Given("update user {string} details with {string} {string}")
	public void update_user_details_with(String userID, String name, String job) throws IOException {
		// To get predefined data
		userIDValue = userID;
		userName = name;
		 res=given().spec(requestSpecification())
					.body(data.userPayLoad(name,job));
	}

	@When("update user using {string} with {string} API")
	public void update_user_using_API(String resource,String updateType) {
		  // To update user put/patch API Call
		APIResources resourceAPI=APIResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(updateType.equals("put")){
		 response =res.when().put(resourceAPI.getResource()+userIDValue);}
		else if(updateType.equals("patch")){
			 response =res.when().patch(resourceAPI.getResource()+userIDValue);
		}
		 response.prettyPrint();
	}

	@Then("the API update call got success status code {int}")
	public void the_API_update_call_got_success_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),200);
	}

	@Then("verify the updated user details")
	public void verify_the_updated_user_details() {
		// To validate user details
		JsonPath jsonResponse = response.jsonPath();
		String  name = jsonResponse.getString("name");
		assertEquals(name,userName);
	}
	
	@Given("delete user {string} details")
	public void delete_user_details(String userID) {
		// To get predefined data
		userIDValue = userID;
	}

	@When("delete user using {string} API")
	public void delete_user_using_API(String resource) throws IOException {
		 // To delete user API Call
		APIResources resourceAPI=APIResources.valueOf(resource);
		res=given().spec(requestSpecification());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response =res.when().delete(resourceAPI.getResource()+userIDValue);
		 response.prettyPrint();
	}

	@Then("the API delete call got success status code {int}")
	public void the_API_delete_call_got_success_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),204);
	}

	@When("user calls {string} API with delay {string}")
	public void user_calls_API_with_delay(String resource, String delaySeconds) throws IOException {
		// To get user API Call with delay
		APIResources resourceAPI=APIResources.valueOf(resource);
		res=given().spec(requestSpecification());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response =res.when().get(resourceAPI.getResource()+delaySeconds);
		response.prettyPrint();
	}

}
