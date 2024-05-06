package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static org.junit.Assert.assertEquals;

public class FinancePricing {
    JsonPath jsonPath;
    @Given("ApiN kullanicisi {string} , {string} ,{string} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1",pp1,"pp2",pp2,"pp3",pp3);
        API_Methods.pathParam="/{pp1}/{pp2}/{pp3}";

    }
    @Given("ApiN kullanicisi {string},{string},{string},{int} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3, int pp5) {
        spec.pathParams("pp1",pp1,"pp2",pp2,"pp3",pp3,"pp4",pp5);
        API_Methods.pathParam="/{pp1}/{pp2}/{pp3}/{pp4}";


    }
    @Given("ApiN kullanicisi response body icindeki mesaj bilgisinin {string} oldugunu dogrular")
    public void api_n_kullanicisi_response_body_icindeki_mesaj_bilgisinin_oldugunu_dogrular(String mesaj) {
        jsonPath =API_Methods.response.jsonPath();
        assertEquals(mesaj,jsonPath.getString("mesaj"));


    }
}
