package sampleREST;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreatUser {

    public static void main(String[] args) {

        RestAssured.baseURI ="https://reqres.in/";

        given().log().all().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .contentType("application/json")
              // .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo("morpheus1"));

    }
}
