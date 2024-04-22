package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class HealthCheck {
    String pathParam;
    Response response;
    @Given("APi kullanicisi ealth check path parametrelerini olusturur")
    public void a_pi_kullanicisi_ealth_check_path_parametrelerini_olusturur() {
        spec.pathParam("pp1", "health-check");
        pathParam = "/{pp1}";
    }

    @Given("Api kullanicisi get request gonderir ve ealth check endpointinden donen responsei kaydeder")
    public void api_kullanicisi_get_request_gonderir_ve_ealth_check_endpointinden_donen_responsei_kaydeder() {
        API_Methods.getResponse(pathParam);
    }
}
