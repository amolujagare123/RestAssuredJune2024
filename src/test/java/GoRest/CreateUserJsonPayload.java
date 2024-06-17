package GoRest;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.goRest.GoRestPayLoad.getUserDetails;

public class CreateUserJsonPayload {

   @Test
    public void createUserRequest() throws IOException {
        RestAssured.baseURI = "https://gorest.co.in/";


       byte[] fileBytes = Files.readAllBytes(Paths.get("C:\\Users\\amolu\\eclipse-workspace\\RestAssuredJune2024\\src\\test\\java\\GoRest\\payloadJson\\createUserPayload.js"));

       String payLoad = new String(fileBytes);

        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(payLoad)
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);

    }



}
