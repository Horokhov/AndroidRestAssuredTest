package apiCalls;

import utils.NumberResponse;
import utils.Specifications;

import static io.restassured.RestAssured.given;
public class GetRandomNumberRequest {
    private static final String baseUrl = "http://numbersapi.com";
    public String getRandromNumber(Integer minimumValue, Integer maximumValue){
        Specifications.getSpecification(Specifications.requestSpecification(baseUrl), Specifications.responseSpecification(200));

        NumberResponse response = given().queryParam("min", minimumValue).queryParam("max",maximumValue)
                .when()
                .get("random/math")
                .then()
                .log()
                .all()
                .extract().as(NumberResponse.class);


        String randomNumber = response.getNumber();

        return randomNumber;
    }

}
