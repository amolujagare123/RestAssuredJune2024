package ChatServer.specBuilder;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void createUser()
    {
        /*RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        given().log().all().auth()
                .preemptive().basic("admin","admin123")
                .contentType("application/json")
                .body("{\n" +
                        "  \"username\": \"john_doe\",\n" +
                        "  \"password\": \"SecureP@ssw0rd\",\n" +
                        "  \"email\": \"john.doe@example.org\",\n" +
                        "  \"name\": \"John\",\n" +
                        "  \"surname\": \"Doe\",\n" +
                        "  \"chat_nickname\": \"JohnnyD\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);*/


        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification req = new RequestSpecBuilder( )
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin/")
                .setAuth(auth)
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(req).body("{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"SecureP@ssw0rd\",\n" +
                "  \"email\": \"john.doe@example.org\",\n" +
                "  \"name\": \"John\",\n" +
                "  \"surname\": \"Doe\",\n" +
                "  \"chat_nickname\": \"JohnnyD\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}");

        Response reponse = request.when().post("/restapi/user");

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();


        String responseStr = reponse.then().log().all().spec(resp).extract().asString();

        System.out.println(responseStr);

    }
}
