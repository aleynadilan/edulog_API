package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class CampusStudentStepStudent {
    @Given("Mustafa kullanicisi {string} icin body olusturur")
    public void mustafa_kullanicisi_icin_body_olusturur(String string) {
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": false,\n" +
                "  \"name\": \"BizimApiOgrencisi\",\n" +
                "  \"idNumber\": \"35321176424\",\n" +
                "  \"firstCreate\": true\n" +
                "}";
    }
    @Given("Mustafa kullanicisi {string} icin post request gonderir ve donen response kaydeder")
    public void mustafa_kullanicisi_icin_post_request_gonderir_ve_donen_response_kaydeder(String string) {
       API_Methods.postResponse(API_Methods.requestBody,API_Methods.pathParam);
    }
    @Then("Mustafa kullanicisi {string} dosyasi schema validation yapar")
    public void mustafa_kullanicisi_dosyasi_schema_validation_yapar(String string) {
       API_Methods.schemaValidateAssert(string);
    }
}
