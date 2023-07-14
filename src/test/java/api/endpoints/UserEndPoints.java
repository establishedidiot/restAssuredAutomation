package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// used to perform CRUD
public class UserEndPoints {
    // method for urls from properties file
    public static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("Routes");
        return routes;
    }

    public static Response createUser(User payload) {
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().post(Routes.post_url);
        return response;
    }

    public static Response readUser(String userName) {
        Response response = given().
                pathParam("username", userName).
                when().
                get(Routes.get_url);

        return response;
    }

    public static Response updateUser(String userName, User payload) {
        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username", userName).
                body(payload).
                when().
                put(Routes.update_url);

        return response;
    }

    public static Response deleteUser(String userName) {
        Response response = given().
                pathParam("username", userName).
                when().
                delete(Routes.delete_url);

        return response;
    }
}
