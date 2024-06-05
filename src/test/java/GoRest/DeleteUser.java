package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

        String id = "6947464";


        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")

                .when().delete("/public/v2/users/"+id)
                .then().log().all().assertThat().statusCode(204);
    }
}
