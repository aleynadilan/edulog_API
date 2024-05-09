package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.API_Methods.*;

public class FinancePricing {
    JsonPath jsonPath;
    @Given("ApiN kullanicisi {string} , {string} ,{string} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1",pp1,"pp2",pp2,"pp3",pp3);
        pathParam="/{pp1}/{pp2}/{pp3}";

    }
    @Given("ApiN kullanicisi {string},{string},{string},{string},{int} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3, String pp4, int pp5) {


        spec.pathParams("pp1",pp1,"pp2",pp2,"pp3",pp3,"pp4",pp4).queryParam("season",pp5);
        pathParam="/{pp1}/{pp2}/{pp3}/{pp4}";






    }


    @Given("ApiN kullanicisi response body icindeki mesaj bilgisinin {string} oldugunu dogrular")
    public void api_n_kullanicisi_response_body_icindeki_mesaj_bilgisinin_oldugunu_dogrular(String mesaj) {
        jsonPath = response.jsonPath();
        assertEquals(mesaj,jsonPath.getString("message"));


    }
    @Given("ApiN kullanicisi response hata mesajinin da status code '400',  reason phrase: Bad Request oldugunu dogrular")
    public void api_n_kullanicisi_response_hata_mesajinin_da_status_code_reason_phrase_bad_request_oldugunu_dogrular() {


        String mesaj = null;
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(pathParam);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        assertEquals("status code: 400, reason phrase: Bad Request",mesaj);
    }

    }


