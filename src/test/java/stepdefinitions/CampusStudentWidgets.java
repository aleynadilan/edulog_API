package stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import utilities.API_Methods;

import java.io.InputStream;

public class CampusStudentWidgets {
    @Then("Mustafa kullanicisi {string} schema validation yapar")
    public void mustafa_kullanicisi_schema_validation_yapar(String string) {
        InputStream classessGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/campus/student/campusstudentwidgets.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessGetJsonSchema));
    }

}
