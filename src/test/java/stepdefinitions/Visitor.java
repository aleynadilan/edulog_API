package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.API_Methods.pathParam;
import static utilities.API_Methods.response;

public class Visitor {
    String body;
    JsonPath jsonPath;

    @Given("ApiN kullanicisi {string} , {string} path parametrelerini olusturur")
    public void api_n_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2) {
        spec.pathParams("pp1",pp1,"pp2",pp2);
        pathParam="/{pp1}/{pp2}";

    }
    @Given("ApiN kullanicisi visitor list endpointine gondermek icin gerekli verileri iceren bir post request olusturur")
    public void api_n_kullanicisi_visitor_list_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_post_request_olusturur() {
        body ="{}";


    }
    @Given("ApiN kullanicisi post request gonderir ve visitor list endpointinden donen responsei kaydeder")
    public void api_n_kullanicisi_post_request_gonderir_ve_visitor_list_endpointinden_donen_responsei_kaydeder() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(pathParam);

        response.prettyPrint();
    }
    @Given("ApiN kullanicisi response bodydeki messagen {string} oldugunu dogrular")
    public void api_n_kullanicisi_response_bodydeki_messagen_oldugunu_dogrular(String success) {
        jsonPath = response.jsonPath();

        assertEquals(success,jsonPath.get("message"));

    }

}
