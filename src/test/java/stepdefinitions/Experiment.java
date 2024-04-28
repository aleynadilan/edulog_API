package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;
import utilities.ConfigReader;

import java.io.InputStream;

import static org.junit.Assert.*;

public class Experiment {

    JsonPath jsonPath;

    // ************************************* /experiment/{id} (get) ************************************************
    @Given("Api kullanicisi donen responsei kaydeder, status codeun '400' ve reason phrase bilgisinin Bad Request oldugunu dogrular")
    public void api_kullanicisi_donen_responsei_kaydeder_status_codeun_ve_reason_phrase_bilgisinin_bad_request_oldugunu_dogrular() {
        assertTrue(API_Methods.tryCatchGet(API_Methods.pathParam).equals(ConfigReader.getProperty("badRequestExceptionMessage")));
    }

    @Given("Api kullanicisi response bodydeki data {int}, {string}, {string}, {string}, {string}, {string}, {int} ve {string} iceriklerini dogrular")
    public void api_kullanicisi_response_bodydeki_data_ve_iceriklerini_dogrular(int id, String createdAt, String updatedAt, String name, String key, String type, int capacity, String image) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(id, jsonPath.getInt("data.id"));
        assertTrue(jsonPath.getBoolean("data.isActive"));
        assertEquals(createdAt, jsonPath.getString("data.createdAt"));
        assertEquals(updatedAt, jsonPath.getString("data.updatedAt"));
        assertNull(jsonPath.get("data.deletedAt"));
        assertEquals(name, jsonPath.getString("data.name"));
        assertEquals(key, jsonPath.getString("data.key"));
        assertEquals(type, jsonPath.getString("data.type"));
        assertEquals(capacity, jsonPath.getInt("data.capacity"));
        assertEquals(image, jsonPath.getString("data.image"));
    }

    @Given("Api kullanicisi experiment id endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_experiment_id_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        InputStream experimentIdGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/experiment/experimentJsonSchema/experimentIdGet.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(experimentIdGetJsonSchema));
    }
    // **************************************************************************************************************
}
