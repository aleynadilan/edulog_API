package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static utilities.API_Methods.response;

public class Schools {
    JSONObject requestBody;
    JsonPath jsonPath;
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

}
