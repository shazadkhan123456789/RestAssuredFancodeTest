package api.endpoints;

import api.utilities.Headers;
import api.utilities.Keys;
import api.utilities.Routes;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndpoints {

    public static Response getAllUsers() {
        return given()
                .header(Headers.CONTENT_TYPE_JSON_KEY.getHeaderKey(), Headers.CONTENT_TYPE_JSON.getHeaderKey())
                .when()
                .get(Routes.BASE_URL.getUrl() + Routes.USERS_URL.getUrl());
    }

    public static Response getTodosForUser(int userId) {
        return given()
                .header(Headers.CONTENT_TYPE_JSON_KEY.getHeaderKey(), Headers.CONTENT_TYPE_JSON.getHeaderKey())
                .queryParam(Keys.USER_ID.getKey(), userId)
                .when()
                .get(Routes.BASE_URL.getUrl() + Routes.TODOS_URL.getUrl());
    }
}
