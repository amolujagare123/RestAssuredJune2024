package DeckOfCards;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ShuffleCards {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        given().log().all().queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .body("success",equalTo(true))
                .body("remaining",equalTo(52));
    }
}
