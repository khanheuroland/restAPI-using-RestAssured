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

##2. Test Get API
With the GET method API, we don't need send any form data from client. We just create the get request like below
```
given().when().get("https://bddtrader.herokuapp.com/api/stock/aapl/company");
```
