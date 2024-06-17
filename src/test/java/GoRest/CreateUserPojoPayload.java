package GoRest;

import POJO.GoRest.CreateUserPojo;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserPojoPayload {

   @Test
    public void createUserRequest() throws IOException {
        RestAssured.baseURI = "https://gorest.co.in/";

       CreateUserPojo payLoad = new CreateUserPojo();
       payLoad.setName("Amrutha");
       payLoad.setEmail("amruta@gmail.com");
       payLoad.setGender("female");
       payLoad.setStatus("active");


        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(payLoad)
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);

    }



}
