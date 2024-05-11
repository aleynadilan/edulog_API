package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

import utilities.API_Methods;
import utilities.PicoContainer;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static hooks.HooksAPI.spec;

import static utilities.API_Methods.*;


public class Campus_Student {
    PicoContainer picoContainer;

    public Campus_Student(PicoContainer picoContainer) {
        this.picoContainer=picoContainer;
    }

    @Given("Mustafa kullanicisi {string} token ile base urli olusturur")
    public void mustafa_kullanicisi_token_ile_base_urli_olusturur(String user) {
        HooksAPI.setUpApi(user);
    }

    @Given("Mustafa kullanicisi {string}, {string},{string},{string} path parametrelerini olusturur")
    public void mustafa_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3, String pp4) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3, "pp4", pp4);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}/{pp4}";

    }

    @Given("Mustafa kullanicisi post request gonderir ve donen responsei kaydeder")
    public void mustafa_kullanicisi_post_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.postResponse(requestBody, pathParam);
    }

    @Then("Mustafa kullanicisi status code {int} oldugunu dogrular")
    public void mustafa_kullanicisi_status_code_oldugunu_dogrular(Integer int1) {
        API_Methods.statusCodeAssert(int1);
    }

    @Then("Mustafa kullanicisi donen body O zaman yanıtın gövdesi doğrulanır:")
    public void mustafa_kullanicisi_donen_body_o_zaman_yanıtın_gövdesi_doğrulanır(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedBody = dataTable.asMap(String.class, String.class);

        // İstenen her bir alanın doğrulanması
        Assert.assertEquals(true, Boolean.parseBoolean(expectedBody.get("status")));
        Assert.assertEquals("success", expectedBody.get("message"));
        Assert.assertNull(expectedBody.get("data")); // Boş değer kontrolü için null kontrolü yapılıyor
        Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(expectedBody.get("statusCode")));

    }

    @Given("Mustafa kullanicisi body olusturur")
    public void mustafa_kullanicisi_body_olusturur() {
        // Örnek bir requestBody JSON formatında
        requestBody = "{\n" +
                "  \"ids\": [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ],\n" +
                "  \"update\": {\n" +
                "    \"isActive\": true\n" +
                "  }\n" +
                "}";


    }

    @Then("Mustafa kullanicisi request bodynin schema validation dogrulamasini yapar")
    public void mustafa_kullanicisi_request_bodynin_schema_validation_dogrulamasini_yapar() throws IOException {
        InputStream campusStudentJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("jsonSchema/campus_student.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(campusStudentJsonSchema));

    }

    @And("Mustafa kullanicisi isActive kismi null body olusturur")
    public void mustafaKullanicisiIsActiveKismiNullBodyOlusturur() {
        requestBody = "{\n" +
                "  \"ids\": [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ],\n" +
                "  \"update\": {\n" +
                "    \"isActive\": null\n" +
                "  }\n" +
                "}";
    }


    @And("Mustafa kullanicisi id kismi bos body olusturur")
    public void mustafaKullanicisiIdKismiBosBodyOlusturur() {
        requestBody = "{\n" +
                "  \"ids\": [\n" +
                "    \n" +
                "  ],\n" +
                "  \"update\": {\n" +
                "    \"isActive\": true\n" +
                "  }\n" +
                "}";
    }

    @And("Mustafa kullanicisi download body olusturur")
    public void mustafaKullanicisiDownloadBodyOlusturur() {
        requestBody = "{\n" +
                "  \"ids\": [\n" +
                "    34,\n" +
                "    17\n" +
                "  ]\n" +
                "}";
    }

    @And("Mustafa kullanicisi get request gonderir ve donen responsei kaydeder")
    public void mustafaKullanicisiGetRequestGonderirVeDonenResponseiKaydeder() {
        //API_Methods.getResponseWithBodyAndQueryParams(requestBody, pathParam,queryParams);
        //API_Methods.getBodyResponse(requestBody,pathParam);
        API_Methods.getResponse(pathParam);
    }

    @And("Mustafa kullanicisi {string}, {string},{string},{string} path ve query parametrelerini olusturur")
    public void mustafaKullanicisiPathVeQueryParametreleriniOlusturur(String pp1, String pp2, String pp3, String pp4) {
        int rastId = picoContainer.rastgeleSecilenOgrenciId;
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3, "pp4", pp4).queryParams("ids",""+rastId+"");
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}/{pp4}";

//        queryParams = new HashMap<>();
//        queryParams.put("ids", "34");
//        queryParams.put("ids", "17");


    }
}
