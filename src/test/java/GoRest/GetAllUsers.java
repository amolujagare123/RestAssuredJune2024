package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .when().get("/public/v2/users")
                .then().log().all().assertThat().statusCode(200);
    }

}
