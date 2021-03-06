import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredTest {

    //Teste que valida o acesso ao serviço e retorna Status Code 200
    @Test
    public void TestDeliveryMuchAcessarServiço() {

        when().
                get("http://challengeqa.staging.devmuch.io/").
                then().
                statusCode(HttpStatus.SC_OK);
    }

    //Teste que valida ser impossível retornar um valor maior que o requisito especifica
    @Test
    public void TestDeliveryMuchImpossivelConverterValorAcimaDe10000() {

        when().
                get("http://challengeqa.staging.devmuch.io/10001").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
