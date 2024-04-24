package stepdefinitions;

import io.cucumber.java.en.Given;
import org.json.JSONObject;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.equalTo;

public class Classess {

    JSONObject requestBody;

    @Given("Api kullanicisi {string}, {int} path parametrelerini olusturur")
    public void api_kullanicisi_path_parametrelerini_olusturur(String pp1, int pp2) {
        spec.pathParams("pp1", pp1, "pp2", pp2);
        API_Methods.pathParam = "/{pp1}/{pp2}";
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
    // **************************************************************************************************************
}
