package sampleREST.specBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

       /* RestAssured.baseURI = "https://reqres.in/";

        String responseStr = given().log().all().contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();
*/

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(req).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");

        Response response = request.when().put("/api/users/2");

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String responseStr = response.then().log().all().spec(resp).extract().asString();

        System.out.println(responseStr);
    }


}
