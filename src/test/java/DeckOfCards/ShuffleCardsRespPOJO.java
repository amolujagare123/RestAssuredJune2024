package DeckOfCards;

import POJO.DeckOfCards.ShuffleCardsPojo;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ShuffleCardsRespPOJO {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        ShuffleCardsPojo shuffleCardsPojo = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().as(ShuffleCardsPojo.class);

        System.out.println("deck id="+shuffleCardsPojo.getDeck_id());
        System.out.println("shuffled="+shuffleCardsPojo.isShuffled());
        System.out.println("success="+shuffleCardsPojo.isSuccess());
        System.out.println("remaining="+shuffleCardsPojo.getRemaining());

    }
}
