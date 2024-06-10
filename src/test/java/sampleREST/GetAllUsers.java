package sampleREST;

import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all().queryParam("page",2)
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .time(lessThan(1000L))
                .time(greaterThan(1L), TimeUnit.SECONDS);

    }
}
