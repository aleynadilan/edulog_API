package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import utilities.API_Methods;

import java.io.InputStream;

import static hooks.HooksAPI.spec;

public class CampusStudentParnetsWidgets {
    @Given("Mustafa kullanicisi {string}, {string},{string} path ve query parametrelerini olusturur")
    public void mustafa_kullanicisi_path_ve_query_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
    }
    @Then("Mustafa kullanicisi {string} icin schema validation yapar")
    public void mustafa_kullanicisi_icin_schema_validation_yapar(String string) {
        InputStream classessGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/campus/student/campusstudentparentwidgets.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessGetJsonSchema));
    }

}
