package GoRest.specBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.goRest.GoRestPayLoad.getUserDetails;

public class CreateUser {

    public static void main(String[] args) {
  //      RestAssured.baseURI = "https://gorest.co.in/";

       /* String body = " {\n" +
                "        \"name\": \"Mayur\",\n" +
                "        \"email\": \"mayur2@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }" ;*/

    /*    String name = "Sushma";
        String email = "sushma1235@gmail.com";
        String gender = "female";
        String status = "active";


        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(getUserDetails(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log().all().assertThat()//.statusCode(201)
                .body("email",equalTo(email));*/

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .addHeader("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(req).body(" {\n" +
                "        \"name\": \"Mayur\",\n" +
                "        \"email\": \"mayur3@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }");

        Response response = request.when().post("/public/v2/users");

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        String reponseStr = response.then().log().all().spec(resp).extract().asString();

        System.out.println(reponseStr);
    }

}
