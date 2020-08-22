package testtweet;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public void testPutRequest() {

        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();


    }

}
