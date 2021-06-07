package ru.training.at.hw9.core;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.Map;

import static org.hamcrest.Matchers.lessThan;

public class BaseApi {
    protected static final String BASEURI = "https://api.trello.com/1";
    protected static final String KEY = "da8de2b6cdfc8342b42f06a706eaf940";
    protected static final String TOKEN =
            "6a82f3c8104e8b880ffcd666af9d2e6731ae0c5150498bae5573deed1b930570";

    protected Method requestMethod;
    protected Map<String, String> parameters;

    public BaseApi(Map<String, String> parameters, Method requestMethod) {
        this.requestMethod = requestMethod;
        this.parameters = parameters;
        parameters.put("key", KEY);
        parameters.put("token", TOKEN);
    }

    public static ResponseSpecification baseResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(5000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

}
