package sampleREST.specBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreatUser {

    public static void main(String[] args) {

       /* RestAssured.baseURI ="https://reqres.in/";

        given().log().all().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .contentType("application/json")
              // .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo("morpheus1"));*/

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type","application/json")
                .build();

        RequestSpecification request = given().log().all().spec(req).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

        Response response = request.when().post("/api/users");

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        String responseStr = response.then().log().all().spec(resp).extract().asString();

        System.out.println(responseStr);
    }
}
