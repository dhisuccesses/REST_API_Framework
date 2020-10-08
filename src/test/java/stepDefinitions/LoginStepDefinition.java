package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
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

public class LoginStepDefinition extends Utils{
	
	ResponseSpecification resspec;
	Response response;
	RequestSpecification res;
	TestDataBuild data =new TestDataBuild();
	
	@Given("user details {string}  {string} for login user")
	public void user_details_for_login_user(String email, String password) throws IOException {
		// To get predefined data
		 res=given().spec(requestSpecification())
					.body(data.loginPayLoad(email,password));
	}

	@When("login user using {string} API")
	public void login_user_using_API(String resource) {
		// To login user API call
		APIResources resourceAPI=APIResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response =res.when().post(resourceAPI.getResource());
		 response.prettyPrint();
	}

	@Then("the API login call got success status code {int}")
	public void the_API_login_call_got_success_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),200);
	}
	
	@Given("user details {string} for login user")
	public void user_details_for_login_user(String email) throws IOException {
		// To get predefined data
		res=given().spec(requestSpecification())
				.body(data.loginNegativePayLoad(email));
	}

	@Then("the API login call got error status code {int}")
	public void the_API_login_call_got_error_status_code(Integer int1) {
		// To validate status code
		assertEquals(response.getStatusCode(),400);
	}
	
	@Then("validate the login error message")
	public void validate_the_login_error_message() {
		// To try login user API call without password
		JsonPath jsonResponse = response.jsonPath();
		String  errorMessage = jsonResponse.getString("error");
		assertEquals(errorMessage,"Missing password");
	}

}
