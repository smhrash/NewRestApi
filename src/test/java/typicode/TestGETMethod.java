package typicode;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGETMethod {



    @Test(enabled = false)
    public void testStatusCode(){
        // Specify base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Request object
        RequestSpecification requestSpecification = RestAssured.given();

        // Response object
        Response response = requestSpecification.request(Method.GET, "/users");

        String responseBody = response.getBody().asString();

       // System.out.println("Response body is: " + responseBody);

        int statusCode =response.statusCode();
        System.out.println("Status code is: "+statusCode);

        Assert.assertEquals(statusCode,200);


    }
    @Test(enabled = false)
    public void testStatusLine(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users");

        String statusLine = response.statusLine();
        System.out.println("Status Line is: "+statusLine);

        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }
    @Test(enabled = false)
    public void testPOSTRequest(){

        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParam = new JSONObject();
        requestParam.put("id",11);
        requestParam.put("name","Sarker Rashid");
        requestParam.put("username","smhrashid");
        requestParam.put("email","smhrashid@gmail.com");
        requestParam.put("address","62-00 39 Ave");
        requestParam.put("city","Woodside");
        requestParam.put("state","NY");

        httpRequest.header("Content - Type","Application/json");

        httpRequest.body(requestParam.toString());

        Response response =httpRequest.request(Method.POST,"/users");

        int statusCode = response.statusCode();
        System.out.println("Status Code is: "+statusCode);

        Assert.assertEquals(statusCode,201);
//
//        String successCode = response.jsonPath().get("SuccessCode");
//
//        System.out.println("Success Code: "+successCode);
//        Assert.assertEquals(successCode,"");


    }
    @Test(enabled = false)
    public void testStatusCode2(){
        // Specify base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Request object
        RequestSpecification requestSpecification = RestAssured.given();

        // Response object
        Response response = requestSpecification.request(Method.GET, "/typicode/demo/posts");

        String responseBody = response.getBody().asString();

       // System.out.println("Response body is: " + responseBody);

        int statusCode =response.statusCode();
        System.out.println("Status code is: "+statusCode);

        Assert.assertEquals(statusCode,200);

        String contentType= response.header("Content-Type");
        System.out.println("ContentType: "+contentType);

        Assert.assertEquals(contentType,"application/json; charset=utf-8");

        String contentEncoding = response.header("Content-Encoding");
        System.out.println("Content Encoding: "+contentEncoding);

        Assert.assertEquals(contentEncoding,"gzip");


    }
    @Test
    public void testDriverDetails(){
        Response response =  RestAssured.get("http://ergast.com/api/f1/2019/last.json");

        System.out.println("Response is: "+response.toString());
        System.out.println("Body is: "+response.getBody().toString());
        System.out.println("Status code is: "+response.getStatusCode());

        System.out.println("Content Type: "+response.getHeader("Content-Type"));
        System.out.println("Date is: "+response.getHeader("Date"));

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");

    }



}
