package testtweet;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchRequest {

    @Test
    public void testPatchRequest(){


        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                header("Content-Type","application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }
}
