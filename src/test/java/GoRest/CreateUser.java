package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(" {\n" +
                        "        \"name\": \"Mayur\",\n" +
                        "        \"email\": \"mayur@gmail.com\",\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"status\": \"active\"\n" +
                        "    }")
                .when().post("/public/v2/users")
                .then().log().all().assertThat()//.statusCode(201)
                .body("email",equalTo("mayur@gmail.com"));
    }

}
