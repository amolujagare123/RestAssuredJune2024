package ChatServer;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

import static io.restassured.RestAssured.given;

public class GetAllUsersBasicAuth {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200);

    }
}
