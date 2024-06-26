package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.API_Methods;

import java.util.HashMap;
import java.util.Map;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static utilities.API_Methods.pathParam;
import static utilities.API_Methods.response;

public class Schools {

    JSONObject requestBody;
    JsonPath jsonPath;
   HashMap<String, Object> requestBodyMap ;
    @Given("ApiN kullanicisi {string} token ile base urli olusturur")
    public void api_n_kullanicisi_token_ile_base_urli_olusturur(String user) {
        HooksAPI.setUpApi(user);

    }
    @Given("ApiN kullanicisi {string} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1) {
        spec.pathParam("pp1",pp1);
        API_Methods.pathParam="/{pp1}";

    }
    @Given("ApiN kullanicisi schools endpointine gondermek icin gerekli verileri iceren bir post request olusturur")
    public void api_n_kullanicisi_schools_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_post_request_olusturur() {
        requestBody = new JSONObject();
        requestBody.put("isActive",true);
        requestBody.put("company_id",5);
        requestBody.put("group_id",3);
        requestBody.put("name","Api Deneme Nursen");

    }
    @Given("ApiN kullanicisi post request gonderir ve schools endpointinden donen responsei kaydeder")
    public void api_n_kullanicisi_post_request_gonderir_ve_schools_endpointinden_donen_responsei_kaydeder() {
        API_Methods.postResponse(requestBody.toString(),API_Methods.pathParam);

    }
    @Given("ApiN kullanicisi status codeun {int} oldugunu dogrular")
    public void api_n_kullanicisi_status_codeun_oldugunu_dogrular(int statusCode) {
        API_Methods.statusCodeAssert(statusCode);

    }
    @Given("ApiN kullanicisi response bodydeki bilgileri dogrular")
    public void api_n_kullanicisi_response_bodydeki_bilgileri_dogrular() {
        jsonPath = API_Methods.response.jsonPath();
        assertTrue(jsonPath.getBoolean("isActive"));
        assertEquals(requestBody.get("name"),jsonPath.getString("name"));




    }
    @Given("ApiN kullanicisi schools post endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_n_kullanicisi_schools_post_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {

    }

    @Given("ApiN kullanicisi response bodydeki errorData bilgisinin {string} oldugunu dogrular")
    public void api_n_kullanicisi_response_bodydeki_error_data_bilgisinin_oldugunu_dogrular(String mesaj) {
        response.then().assertThat().body("errorData",equalTo(mesaj));

    }
    @Given("ApiN kullanicisi get request gonderir ve donen responsei kaydeder")
    public void api_n_kullanicisi_get_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.getResponse(API_Methods.pathParam);
    }
    @Given("ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular")
    public void api_n_kullanicisi_response_bodydeki_status_codeun_ve_error_data_bilgisinin_unauthorized_oldugunu_dogrular() {
        String mesaj = null;
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .when()
                    .get(pathParam);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
assertEquals("status code: 401, reason phrase: Unauthorized",mesaj);
    }


    @Given("ApiN kullanicisi {string}, {int} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, int pp2) {
        spec.pathParams("pp1",pp1,"pp2",pp2);
        API_Methods.pathParam="/{pp1}/{pp2}";

    }

    @Given("ApiN kullanicisi response body icindeki name bilgisinin {string} ve id bilgisininde {int} oldugunu dogrular")
    public void api_n_kullanicisi_response_body_icindeki_name_bilgisinin_ve_id_bilgisininde_oldugunu_dogrular(String name, int id) {
        jsonPath = API_Methods.response.jsonPath();
        assertEquals(jsonPath.get("name"),"api deneme");
        assertEquals(jsonPath.getInt("id"),id);

    }
    @Given("ApiN kullanicisi delete request gonderir ve donen responsei kaydeder")
    public void api_n_kullanicisi_delete_request_gonderir_ve_donen_responsei_kaydeder() {
       API_Methods.deleteResponse(API_Methods.pathParam);
    }
    @Given("ApiN kullanicisi schools endpoint'ine gondermek icin {string}  verisini iceren bir patch request olusturur")
    public void api_n_kullanicisi_schools_endpoint_ine_gondermek_icin_verisini_iceren_bir_patch_request_olusturur(String name) {
        requestBodyMap = new HashMap<>();
        requestBodyMap.put("name",name);


    }


    @Given("ApiN kullanicisi patch request gonderir ve schools endpoint'inden donen response'u kaydeder")
    public void api_n_kullanicisi_patch_request_gonderir_ve_schools_endpoint_inden_donen_response_u_kaydeder() {
        response = given()
                .spec(spec)//url
                .contentType(ContentType.JSON)//gönderilen data tipi
                .when()
                .body(requestBodyMap)//gönderilen body
                .patch(pathParam); //paramaetreler

        response.prettyPrint();

    }

    @Given("ApiN kullanicisi response body'deki bilgilerin guncellendigini dogrular")
    public void api_n_kullanicisi_response_body_deki_bilgilerin_guncellendigini_dogrular() {
        Map<String, Object> actualData = response.as(HashMap.class); //
        assertEquals(actualData.get("name"),"api patch");

    }


}
