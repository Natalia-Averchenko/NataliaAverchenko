package ru.training.at.hw9.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.training.at.hw9.beans.TrelloAnswer;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardApi extends BaseApi {

    private static final String BOARDEP = "/boards/";
    public static final URI TRELLO_URI_BOARD = URI.create(BASEURI + BOARDEP);


    private BoardApi(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static ApiRequestBuilder requestBuilderBoard() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.POST;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setTableName(String tableName) {
            parameters.put("name", tableName);
            return this;
        }


        public BoardApi buildRequest() {
            return new BoardApi(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, TRELLO_URI_BOARD)
                .prettyPeek();
    }

    public Response sendRequestWithId(String tableID) {
        URI trelloUriDelete = URI.create(BASEURI + BOARDEP+tableID);
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, trelloUriDelete)
                .prettyPeek();
    }

    public Response sendRequestByOrg(String orgId) {
        URI orgUri = URI.create("https://api.trello.com/1/organizations/"+orgId+"/boards");
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, orgUri)
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(TRELLO_URI_BOARD)
                .build();
    }

    public static TrelloAnswer getAnswer(Response response) {
        TrelloAnswer answer = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloAnswer>() {
                }.getType());
        return answer;
    }

    public static List<TrelloAnswer> getAnswers(Response response) {
        List<TrelloAnswer> answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>() {
                }.getType());
        return answers;
    }
}
