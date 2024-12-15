//Task16
//Make restAssured TC using scenario from Task_15.
//The same using any another API client.
//Add Request and Response clases for each unique endpoints.
//Validate Response Object using your own class comparator.

//Task15
//Create a new board. Check that the API call returns a success status code and that the board is created with the name provided in the API call.
//Create a new list on the board. Check that the API call returns a success status code and that the list is created with the name provided in the API call.
//Add a new checklist to the card. Check that the API call returns a success status code and that the checklist is added to the card.
//Delete the checklist from the card. Check that the API call returns a success status code and that the checklist is removed from the card.



package task16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task16Test {

    public static final String Trello_API_KEY = "8ef9fb826f6d39e1fd0839c810463892";
    public static final String Trello_TOKEN = "ATTA854d1be1fe11941c19b52139ab82ad3c0daef64215c35e8d7bc17c8b1c53e4c52DF7747D";
    public static final String Accept = "application/json";

    @Test
    void trelloTest(){
        //Create Board
        Response createBoardResponse = given()
                .queryParam("name", "BoardName")
                .queryParam("token", Trello_TOKEN)
                .queryParam("key", Trello_API_KEY)
                .header("Accept", Accept)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards")
                .then().log().all().statusCode(200).extract().response();
        String boardId = createBoardResponse.jsonPath().getString("id");

        // Create List
        Response createListResponse = given()
                .queryParam("name", "NewList")
                .queryParam("token", Trello_TOKEN)
                .queryParam("key", Trello_API_KEY)
                .queryParam("idBoard", boardId)
                .header("Accept", Accept)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/lists")
                .then().log().all().statusCode(200).extract().response();
        String listId = createListResponse.jsonPath().getString("id");

        // Create Card
        Response createCardResponse = given()
                .queryParam("name", "NewCard")
                .queryParam("token", Trello_TOKEN)
                .queryParam("key", Trello_API_KEY)
                .queryParam("idList", listId)
                .header("Accept", Accept)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/cards")
                .then().log().all().statusCode(200).extract().response();
        String cardId = createCardResponse.jsonPath().getString("id");

        // Create CheckList
        Response createCheckListResponse = given()
                .queryParam("name", "NewCheckList")
                .queryParam("token", Trello_TOKEN)
                .queryParam("key", Trello_API_KEY)
                .queryParam("idCard", cardId)
                .header("Accept", Accept)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/cards/"+cardId+"/checklists")
                .then().log().all().statusCode(200).extract().response();
        String checkListId = createCheckListResponse.jsonPath().getString("id");

        // Delete Checklist
        Response deleteChecklistResponse = given()
                .queryParam("token", Trello_TOKEN)
                .queryParam("key", Trello_API_KEY)
                .queryParam("idCheckList", checkListId)
                .header("Accept", Accept)
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.trello.com/1/checklists/"+checkListId)
                .then().log().all().statusCode(200).extract().response();
        String deletedCheckListId = deleteChecklistResponse.jsonPath().getString("id");
    }
}
