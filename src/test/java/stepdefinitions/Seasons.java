package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import pojos.SeasonsPostPojo;
import utilities.API_Methods;

import static org.junit.Assert.*;

public class Seasons {

    SeasonsPostPojo requestBodyPojo;
    JsonPath jsonPath;
    API_Methods api_methods = new API_Methods();

    // ***************************************** /seasons (post) ****************************************************
    @Given("Api kullanicisi seasons endpointine gondermek icin gerekli verileri iceren bir post request olusturur")
    public void api_kullanicisi_seasons_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_post_request_olusturur() {
        requestBodyPojo = new SeasonsPostPojo(true, "Aleyna");
    }

    @Given("Api kullanicisi post request gonderir ve seasons endpointinden donen responsei kaydeder")
    public void api_kullanicisi_post_request_gonderir_ve_seasons_endpointinden_donen_responsei_kaydeder() {
        API_Methods.postResponse(requestBodyPojo, API_Methods.pathParam);
    }

    @Given("Api kullanicisi seasons post endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_seasons_post_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/seasons/seasonsJsonSchema/seasonsPost.json");
    }
    // **************************************************************************************************************

    // ***************************************** /seasons (get) *****************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olan {string}, {string}, {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name, String seasonStartDate, String seasonEndDate) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(seasonStartDate, jsonPath.getString("[" + dataIndex + "].seasonStartDate"));
        assertEquals(seasonEndDate, jsonPath.getString("[" + dataIndex + "].seasonEndDate"));
    }

    @Given("Api kullanicisi seasons get endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_seasons_get_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/seasons/seasonsJsonSchema/seasonsGet.json");
    }
    // **************************************************************************************************************

    // *************************************** /seasons/{id} (get) **************************************************
    @Given("Api kullanicisi response bodydeki data {int}, {string}, {string}, {string}, {string} ve {string} iceriklerini dogrular")
    public void api_kullanicisi_response_bodydeki_data_ve_iceriklerini_dogrular(int id, String createdAt, String updatedAt, String name, String seasonStartDate, String seasonEndDate) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(id, jsonPath.getInt("id"));
        assertTrue(jsonPath.getBoolean("isActive"));
        assertEquals(createdAt, jsonPath.getString("createdAt"));
        assertEquals(updatedAt, jsonPath.getString("updatedAt"));
        assertNull(jsonPath.get("deletedAt"));
        assertEquals(name, jsonPath.getString("name"));
        assertEquals(seasonStartDate, jsonPath.getString("seasonStartDate"));
        assertEquals(seasonEndDate, jsonPath.getString("seasonEndDate"));
    }

    @Given("Api kullanicisi seasons id endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_seasons_id_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/seasons/seasonsJsonSchema/seasonsIdGet.json");
    }
    // **************************************************************************************************************
}
