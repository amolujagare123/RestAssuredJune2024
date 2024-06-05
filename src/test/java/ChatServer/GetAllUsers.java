package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        given().log().all()
                .header("Authorization","Basic YWRtaW46YWRtaW4xMjM=")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200);

    }
}
