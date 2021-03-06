import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JsonSchemaValidator {

    //Teste de validação do Json Schema do Json retornado pelo serviço em Português
    @Test
    public void testJsonSchemaServiçoPTBr() {
        RestAssured.given()
                .when()
                .get("http://challengeqa.staging.devmuch.io/10")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("JsonSchemaResponse.json"));
    }
    //Teste de validação do Json Schema do Json retornado pelo serviço em Inglês
    @Test
    public void testJsonSchemaServiçoEnglish() {
        RestAssured.given()
                .when()
                .get("http://challengeqa.staging.devmuch.io/en/100")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("JsonSchemaResponseEnglish.json"));
    }
}