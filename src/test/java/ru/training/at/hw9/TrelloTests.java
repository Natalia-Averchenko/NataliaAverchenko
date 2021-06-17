package ru.training.at.hw9;

import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.training.at.hw9.beans.TrelloBoard;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static ru.training.at.hw9.core.BaseApi.baseResponseSpecification;
import static ru.training.at.hw9.core.BoardApi.*;
import static ru.training.at.hw9.core.ListApi.requestBuilderList;

public class TrelloTests {

    private String tableID;
    private String organizationId;

    @Test(dataProviderClass = DataProviderTrelloTest.class,
            dataProvider = "dataForTableCreatingTest")
    public void checkAnswerStatusAfterCreatingTable(String tableName) {
        TrelloBoard answer = getBoard(
                requestBuilderBoard()
                        .setTableName(tableName)
                        .buildRequest()
                        .sendRequest()
                        .then().assertThat()
                        .spec(baseResponseSpecification())
                        .extract()
                        .response());
        assertEquals(answer.getName(), tableName);
        assertNotNull(answer.getId());
    }

    @Test(dataProviderClass = DataProviderTrelloTest.class,
            dataProvider = "dataForTableCreatingTest")
    public void checkAnswerContentAfterCreatingTable(String tableName) {
        TrelloBoard answer = getBoard(
                requestBuilderBoard()
                        .setTableName(tableName)
                        .buildRequest()
                        .sendRequest());
        assertEquals(answer.getName(), tableName);
        tableID = answer.getId();
        organizationId = answer.getIdOrganization();
    }

    @Test(dataProviderClass = DataProviderTrelloTest.class,
            dataProvider = "dataForListCreatingTest")
    public void checkAnswerStatusAfterCreatingList(String listName) {
        requestBuilderList()
                .setListName(listName)
                .setTableId(tableID)
                .buildRequest()
                .sendRequest()
                .then().assertThat()
                .spec(baseResponseSpecification());
    }

    @Test
    public void tableDeletingAndCheckAnswerStatus() {
        requestBuilderBoard()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequestWithId(tableID)
                .then().assertThat()
                .spec(baseResponseSpecification());
    }

    @Test(dependsOnMethods = {"checkAnswerContentAfterCreatingTable"})
    public void checkMissingTableAfterDeleting() {
        requestBuilderBoard()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequestWithId(tableID)
                .then().assertThat()
                .spec(notFoundResponseSpecification());
    }

    @AfterClass
    public void deletingAllCreatedBoards() {
        List<TrelloBoard> answers = getBoards(
                requestBuilderBoard()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestByOrg(organizationId));
        for (TrelloBoard ans : answers) {
            requestBuilderBoard()
                    .setMethod(Method.DELETE)
                    .buildRequest()
                    .sendRequestWithId(ans.getId());
        }
    }

}
