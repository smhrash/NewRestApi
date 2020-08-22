package bddtest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class DemoGetRequest {

    @Test(enabled = false)
    public void test_NumberOfCircuits() {

        given().
                when().
                get("http://ergast.com/api/f1/2019/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().
                body("MRData.CircuitTable.Circuits.circuitId", hasSize(21)).
                and().
                header("Content-Length", equalTo("4739"));
    }


    @Test(enabled = false)
    public void testLastRaceDetails(){
        given().
                when().
                get("http://ergast.com/api/f1/2019/last.json").
                then().
                assertThat().
                statusCode(200).
                and().
                header("Content-Type",equalTo("application/json; charset=utf-8"));
    }
    @Test
    public void test_1(){
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[0]",equalTo(7)).
                body("data.first_name",hasItems("Michael","Lindsay")).
                body("data.first_name[5]",equalTo("Rachel")).
                log().all();

    }

}
