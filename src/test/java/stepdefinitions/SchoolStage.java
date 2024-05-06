package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.API_Methods;
import utilities.Authentication;
import utilities.ConfigReader;
import utilities.PicoContainer;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class SchoolStage {
    PicoContainer picoContainer;

    public SchoolStage(PicoContainer picoContainer) {
        this.picoContainer = picoContainer;
    }

    @Given("Mustafa kullanicisi base_url-school-stage-list icin path parametrelerini olusturur")
    public void mustafa_kullanicisi_base_url_school_stage_list_icin_path_parametrelerini_olusturur() {
        picoContainer.specSchoolStage=new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url"))
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + Authentication.generateToken("employee") )
                .build();
        picoContainer.specSchoolStage.pathParams("pp1", "school", "pp2", "stage", "pp3", "list");
        picoContainer.pathParamSchoolStageGet = "/{pp1}/{pp2}/{pp3}";
    }

    @And("Mustafa kullanicisi base_url-school-stage-list icin get request yapar")
    public void mustafaKullanicisiBase_urlSchoolStageListIcinGetRequestYapar() {
        picoContainer.responseSchoolStageGet = given()
                .spec(picoContainer.specSchoolStage)
                .contentType(ContentType.JSON)
                .when()
                .get(picoContainer.pathParamSchoolStageGet);
    }

    @And("Mustafa kullanicisi status code {int} oldugunu assert eder")
    public void mustafaKullanicisiStatusCodeOldugunuAssertEder(int statusCode) {
        picoContainer.responseSchoolStageGet
                .then()
                .assertThat()
                .statusCode(statusCode);
    }
}
