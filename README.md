# Test RestAPI with Serenity RestAssured Example

## 1. RestAssured
Rest assured is a java based tool used for automating Restful web services. It is a powerful behavior driven library set up for testing out various API endpoints and their response bodies. It helps in writing readable, maintainable tests for RESTful APIs

Rest assured can be added as a dependency in maven pom.xml as follows:

```
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-rest-assured</artifactId>
            <version>2.0.81</version>
        </dependency>
```
* Please note that the version of serenity rest assured should be the same with serenity core version. On this example I used the same version is 2.0.81

## 2. Test Get API
With the GET method API, we don't need send any form data from client. We just create the get request like below
```
    given().when().get("https://bddtrader.herokuapp.com/api/stock/aapl/company");
```

We can use the RestAssured.baseURI to store the domain url, then just use the path of API on request like this

```
    @Before
    public void prepare_rest_config(){
        RestAssured.baseURI = "https://bddtrader.herokuapp.com/api";
    }
    
    @Test
    public void find_a_simple_field_value(){
        //Create the request
        given().when().get("stock/aapl/company");
    }
```

## 3. Verify Responses

We can use the Ensure object to verify response of request. 

The Ensure.that take 2 parameters:
* First is a text describe about criteria, this content will be embeded into the report
* The Second parameter is a comparison between response's attribute with the outcome expectation value
```
        //Verify responses
        Ensure.that("the industry is correctly defined",
                response->response.body("industry", equalTo("Telecommunications Equipment")))
            .andThat("the exchange should be NASDAQ",
                response->response.body("exchange", equalTo("NASDAQ")));
```
## 4. The Report
![alt text](http://url/to/img.png)
