package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.goRest.GoRestPayLoad.getUserDetails;

public class CreateUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

       /* String body = " {\n" +
                "        \"name\": \"Mayur\",\n" +
                "        \"email\": \"mayur2@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }" ;*/

        String name = "Sushma";
        String email = "sushma1235@gmail.com";
        String gender = "female";
        String status = "active";


        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(getUserDetails(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log().all().assertThat()//.statusCode(201)
                .body("email",equalTo(email));
    }

}
