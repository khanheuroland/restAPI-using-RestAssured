package restassuredapi;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.rest.RestRequests.*;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenGettingCompanyDetails {
    @Before
    public void prepare_rest_config(){
        RestAssured.baseURI = "https://bddtrader.herokuapp.com/api";
    }
    @Test
    public void find_a_simple_field_value(){
        //Create the request
        given().pathParam("symbol", "aapl")
                .when().get("stock/{symbol}/company");

        //Verify responses
        Ensure.that("the industry is correctly defined",
                response->response.body("industry", equalTo("Telecommunications Equipment")))
            .andThat("the exchange should be NASDAQ",
                response->response.body("exchange", equalTo("NASDAQ")));
    }

    @Test
    public void each_new_client_should_be_given_a_unique_id()
    {
        String newClient = "{\n"+
                "   \"email\": \"sarah-jane@smith.com\", \n"+
                "   \"firstName\": \"Sarah-Jane \",\n"+
                "   \"lastName\": \"Smith\"\n"+
                "}";
        given().contentType("application/json").and()
                .body(newClient)
                .when().post("/client")
                .then().statusCode(200)
                .and().body("id", not(equalTo(0)));
    }
}
