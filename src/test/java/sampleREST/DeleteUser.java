package sampleREST;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all()
                .when().delete("/api/users/2")
                .then().log().all().assertThat()
                .statusCode(204);
    }
}
