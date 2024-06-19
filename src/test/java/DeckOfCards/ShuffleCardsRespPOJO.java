package DeckOfCards;

import POJO.DeckOfCards.ShuffleCardsPojo;
import POJO.DeckOfCards.drawCards.DrawCardsPOJO;
import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ShuffleCardsRespPOJO {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        int expectedRemaining = 52;

        ShuffleCardsPojo shuffleCardsPojo = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().as(ShuffleCardsPojo.class);

        String deckID = shuffleCardsPojo.getDeck_id();

        System.out.println("deck id="+shuffleCardsPojo.getDeck_id());
        System.out.println("shuffled="+shuffleCardsPojo.isShuffled());
        System.out.println("success="+shuffleCardsPojo.isSuccess());
        System.out.println("remaining="+shuffleCardsPojo.getRemaining());

        int actualRemaining = shuffleCardsPojo.getRemaining();

        //Assert.assertEquals(actualRemaining,expectedRemaining);

        int expectedCardsDrawn = 3;

        DrawCardsPOJO drawCards = given().log().all().queryParam("count", expectedCardsDrawn)
                .when().get("/api/deck/" + deckID + "/draw")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().as(DrawCardsPOJO.class);

        // check the exact 2 cards are drawn
        // check remaining is 50

        int actualCardsDrawn = drawCards.getCards().size();

        System.out.println("actualCardsDrawn="+actualCardsDrawn);
        System.out.println("expectedCardsDrawn="+expectedCardsDrawn);

         expectedRemaining = expectedRemaining - expectedCardsDrawn;

         int actualCardsRemaining = drawCards.getRemaining();

        System.out.println("actualCardsRemaining="+actualCardsRemaining);
        System.out.println("expectedRemaining="+expectedRemaining);

        Assert.assertEquals(actualCardsRemaining,expectedRemaining);

      //  Assert.assertEquals(actualCardsDrawn,expectedCardsDrawn);

      //  print all the cards drawn
        //  print there png image path

        System.out.println("below are the cards drawn");

        for (int i=0;i<drawCards.getCards().size();i++) {

            System.out.println(drawCards.getCards().get(i).getCode());
            System.out.println(drawCards.getCards().get(i).getImages().getPng());

        }




    }
}
