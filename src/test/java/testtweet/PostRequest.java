package testtweet;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequest {

    @Test
    public void testPostRequest() {
//
//        Map<String,Object> map =new HashMap<>();
//        map.put("name","morpheus");
//        map.put("job","leader");
//        System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toString()).
                when().post("https://reqres.in/api/users").
                then().
                statusCode(201);


    }


}
