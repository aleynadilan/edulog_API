package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import pojos.ClassessPostPOJO;
import utilities.API_Methods;
import utilities.ConfigReader;

import java.io.InputStream;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class Classess {

    JSONObject requestBody;

    JsonPath jsonPath;
    ClassessPostPOJO classessPostPOJO;

    @Given("Api kullanicisi {string}, {int} path parametrelerini olusturur")
    public void api_kullanicisi_path_parametrelerini_olusturur(String pp1, int pp2) {
        spec.pathParams("pp1", pp1, "pp2", pp2);
        API_Methods.pathParam = "/{pp1}/{pp2}";
    }

    @Given("Api kullanicisi delete request gonderir ve donen responsei kaydeder")
    public void api_kullanicisi_delete_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.deleteResponse(API_Methods.pathParam);
    }

    @Given("Api kullanicisi donen delete responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular")
    public void api_kullanicisi_donen_delete_responsei_kaydeder_status_codeun_ve_reason_phrase_bilgisinin_unauthorized_oldugunu_dogrular() {
        assertTrue(API_Methods.tryCatchDelete(API_Methods.pathParam).equals(ConfigReader.getProperty("unauthorizedExceptionMessage")));
    }

    // ***************************************** /classess (post) ***************************************************
    @Given("Api kullanicisi classess endpointine gondermek icin gerekli verileri iceren bir post request olusturur")
    public void api_kullanicisi_classess_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_post_request_olusturur() {
        requestBody = new JSONObject();
        requestBody.put("isActive", true);
        requestBody.put("company_id", 1);
        requestBody.put("group_id", 1);
        requestBody.put("school_id", 1);
        requestBody.put("name", "Aleyna");
    }

    @Given("Api kullanicisi post request gonderir ve classess endpointinden donen responsei kaydeder")
    public void api_kullanicisi_post_request_gonderir_ve_classess_endpointinden_donen_responsei_kaydeder() {
        API_Methods.postResponse(requestBody.toString(), API_Methods.pathParam);
    }

    @Given("Api kullanicisi response bodydeki bilgileri dogrular")
    public void api_kullanicisi_response_bodydeki_bilgileri_dogrular() {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("isActive"));
        assertEquals(requestBody.get("name"), jsonPath.getString("name"));
        assertNull(jsonPath.get("level_key"));
        assertNull(jsonPath.get("deletedAt"));
    }

    @Given("Api kullanicisi response bodydeki errorData bilgisinin {string} oldugunu dogrular")
    public void api_kullanicisi_response_bodydeki_error_data_bilgisinin_oldugunu_dogrular(String errorData) {
        API_Methods.response.then()
                .assertThat()
                .body("errorData", equalTo(errorData));
    }

    @Given("Api kullanicisi response body icindeki name bilgisinin {string} ve id bilgisininde {int} oldugunu dogrular")
    public void api_kullanicisi_response_body_icindeki_name_bilgisinin_ve_id_bilgisininde_oldugunu_dogrular(String name, int id) {
        API_Methods.response.then()
                .assertThat()
                .body("name", equalTo(name),
                        "id", equalTo(id));
    }

    @Given("Api kullanicisi classess post endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_classess_post_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        InputStream classessPostJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/classess/classessJsonSchema/classessPost.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessPostJsonSchema));
    }

    @Given("Api kullanicisi classess endpointine gondermek icin gerekli verileri iceren bir POST request olusturur")
    public void api_kullanicisi_classess_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_POST_request_olusturur() {
        classessPostPOJO = new ClassessPostPOJO(true, 1, 1, 1, "Aleyna");
    }

    @Given("Api kullanicisi POST request gonderir ve classess endpointinden donen responsei kaydeder")
    public void api_kullanicisi_POST_request_gonderir_ve_classess_endpointinden_donen_responsei_kaydeder() {
        API_Methods.postResponse(classessPostPOJO, API_Methods.pathParam);
    }

    // **************************************************************************************************************

    // ***************************************** /classess (get) ***************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olan {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertNull(jsonPath.get("[" + dataIndex + "].level_key"));
    }

    @Given("Api kullanicisi classess endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_classess_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        InputStream classessGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/classess/classessJsonSchema/classessGet.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessGetJsonSchema));
    }
    // **************************************************************************************************************

    // *************************************** /classess/{id} (get) **************************************************
    @Given("Api kullanicisi response bodynin bos oldugunu dogrular")
    public void api_kullanicisi_response_bodynin_bos_oldugunu_dogrular() {
        API_Methods.response.then()
                .assertThat()
                .body(equalTo(""));
    }

    @Given("Api kullanicisi response bodydeki data {int}, {string}, {string}, {string} iceriklerini dogrular")
    public void api_kullanicisi_response_bodydeki_data_iceriklerini_dogrular(int id, String createdAt, String updatedAt, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(id, jsonPath.getInt("id"));
        assertTrue(jsonPath.getBoolean("isActive"));
        assertEquals(createdAt, jsonPath.getString("createdAt"));
        assertEquals(updatedAt, jsonPath.getString("updatedAt"));
        assertNull(jsonPath.get("deletedAt"));
        assertEquals(name, jsonPath.getString("name"));
        assertEquals(5, jsonPath.getInt("level_key"));
    }

    @Given("Api kullanicisi classess id endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_classess_id_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        InputStream classessIdGetJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("features/API/classess/classessJsonSchema/classessIdGet.json");

        API_Methods.response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(classessIdGetJsonSchema));
    }
    // **************************************************************************************************************

}
