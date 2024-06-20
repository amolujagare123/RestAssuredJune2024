package sampleREST.specBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class GetAllUsers {

    @Test
    public void getAllUsers() {

       /* RestAssured.baseURI = "https://reqres.in/";

        given().log().all().queryParam("page",2)
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .time(lessThan(1000L))
                .time(greaterThan(1L), TimeUnit.SECONDS);*/

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addQueryParam("page","2")
                .build();

        RequestSpecification requestGetAllUsers = given().log().all().spec(req);

        Response response = requestGetAllUsers.when().get("/api/users");

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();


        String responseStr = response.then().log().all().spec(resp).extract().asString();

        System.out.println(responseStr);
    }
}
