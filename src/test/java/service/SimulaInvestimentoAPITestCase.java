package service;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import io.restassured.http.ContentType;

public class SimulaInvestimentoAPITestCase {
	
	String uriBase = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";
	
	@Test
	public void validaURL() {
		
			given()
			.log()
			.all()
			.param("id", "1")
			.when()
			.get(uriBase)
			.then()
			.statusCode(200)
			.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void validaPreco() {
		
			given()
			.log()
			.all()
			.get(uriBase)
			.then()
			.assertThat()
			.body("valor", hasItems("2.802","3.174","3.564","3.971"));
		
	}

}
