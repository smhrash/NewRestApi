package testtweet;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class DeleteRequest {

    @Test
    public void testDeleteRequest() {


        when().
                delete("https://reqres.in/api/users?page=2").
                then().
                statusCode(204).
                log().all();
    }


}

