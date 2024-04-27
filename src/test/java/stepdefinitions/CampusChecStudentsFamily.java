package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import utilities.API_Methods;

import java.io.InputStream;

import static hooks.HooksAPI.spec;

public class CampusChecStudentsFamily {
    @Given("Mustafa kullanicisi {string}, {string},{string} path parametrelerini olusturur")
    public void mustafa_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
    }
    @Given("Mustafa kullanicisi {string} icin get request gonderir ve donen response kaydeder")
    public void mustafa_kullanicisi_icin_get_request_gonderir_ve_donen_response_kaydeder(String string) {
        API_Methods.getResponse(API_Methods.pathParam);
    }
    @Then("Mustafa kullanicisi {string}, {string},{string} schema validation yapar")
    public void mustafa_kullanicisi_schema_validation_yapar(String string, String string2, String string3) {
        InputStream classessGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/campus/student/CampusStudentControllerCheckStudentsFamilys.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessGetJsonSchema));
    }

}
