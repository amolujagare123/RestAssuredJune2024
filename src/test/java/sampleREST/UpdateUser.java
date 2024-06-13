package sampleREST;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String responseStr = given().log().all().contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();

        System.out.println("responseStr="+responseStr);

        JsonPath jsonPath = new JsonPath(responseStr);
        String myJob = jsonPath.getString("job");

        String myJob2 =jsonPath.get("job");


        System.out.println("myJob="+myJob);
    }


}
