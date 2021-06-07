package ru.training.at.hw9;

import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.training.at.hw9.beans.TrelloAnswer;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static ru.training.at.hw9.core.BaseApi.baseResponseSpecification;
import static ru.training.at.hw9.core.BoardApi.*;
import static ru.training.at.hw9.core.ListApi.requestBuilderList;

public class TrelloTests {

    private String tableID;
    private String organizationId;

    @Test(dataProviderClass = DataProviderTrelloTest.class,
            dataProvider = "dataForTableCreatingTest")
    public void checkAnswerStatusAfterCreatingTable(String tableName) {
        requestBuilderBoard()
                .setTableName(tableName)
                .buildRequest()
                .sendRequest()
                .then().assertThat()
                .spec(baseResponseSpecification())
                .body(containsString("id"))
                .body(containsString("FirstTable"));
    }

    @Test(dataProviderClass = DataProviderTrelloTest.class,
            dataProvider = "dataForTableCreatingTest")
    public void checkAnswerContentAfterCreatingTable(String tableName) {
        TrelloAnswer answer = getAnswer(
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
                .spec(baseResponseSpecification())
                .body(containsString("FirstList"));
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

    @Test(dependsOnMethods = { "checkAnswerContentAfterCreatingTable" })
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
        List<TrelloAnswer> answers = getAnswers(
                requestBuilderBoard()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestByOrg(organizationId));
        for (TrelloAnswer ans : answers){
            requestBuilderBoard()
                    .setMethod(Method.DELETE)
                    .buildRequest()
                    .sendRequestWithId(ans.getId());
        }
    }

}
