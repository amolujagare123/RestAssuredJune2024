package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ShuffleCards2 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String responseStr = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().asString();

        System.out.println("======= responseStr as below =======");
        System.out.println(responseStr);

        JsonPath jsonPath = new JsonPath(responseStr);
        String dId =  jsonPath.getString("deck_id");
        int remaining =  jsonPath.getInt("remaining");
        System.out.println("dId="+dId);


        given().log().all().queryParam("count", "2")
                .when().get("/api/deck/"+dId+"/draw/")
                .then().log().all().assertThat()
                .statusCode(200)
                ;

    }
}
