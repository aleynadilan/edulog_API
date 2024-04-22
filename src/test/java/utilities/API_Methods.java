package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class API_Methods {
    public static Response response;

    public static Response getResponse(String pathParam) {
        response = given()
                .spec(spec)
                .when()
                .get(pathParam);

        response.prettyPrint();

        return response;
    }

    public static Response getBodyResponse(Object requestBody, String pathParam) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .get(pathParam);

        response.prettyPrint();

        return response;
    }

    public static Response postResponse(Object requestBody, String pathParam) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post(pathParam);

        response.prettyPrint();

        return response;
    }

    public static Response patchResponse(Object requestBody, String pathParam) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .patch(pathParam);

        response.prettyPrint();

        return response;
    }

    public static Response putResponse(Object requestBody, String pathParam) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .put(pathParam);

        response.prettyPrint();

        return response;
    }

    public static void statusCodeAssert(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }
}
