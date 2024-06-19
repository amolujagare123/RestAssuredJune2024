package sampleREST;

import POJO.REQRES.ListUsersPojo;
import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class GetAllUsers2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        ListUsersPojo responseListUsers = given().log().all().queryParam("page", 2)
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(ListUsersPojo.class);

        // print all first names
        System.out.println("Below are all first names");
        for (int i=0;i<responseListUsers.getData().size();i++)
        {
            System.out.println(responseListUsers.getData().get(i).getFirst_name());
        }

    }
}
