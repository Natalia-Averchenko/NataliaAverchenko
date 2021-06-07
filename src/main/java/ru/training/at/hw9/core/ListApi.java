package ru.training.at.hw9.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ListApi extends BaseApi {

    private static final String LISTEP = "/list";
    public static final URI TRELLO_URI_LIST = URI.create(BASEURI + LISTEP);

    private ListApi(Map<String, String> parameters, Method method) {
        super(parameters, method);
    }

    public static ApiRequestBuilderList requestBuilderList() {
        return new ApiRequestBuilderList();
    }

    public static class ApiRequestBuilderList {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.POST;

        public ApiRequestBuilderList setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilderList setListName(String listName) {
            parameters.put("name", listName);
            return this;
        }

        public ApiRequestBuilderList setTableId(String tableId) {
            parameters.put("idBoard", tableId);
            return this;
        }

        public ListApi buildRequest() {
            return new ListApi(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, TRELLO_URI_LIST)
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(TRELLO_URI_LIST)
                .build();
    }

}
