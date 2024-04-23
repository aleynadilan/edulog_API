package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.equalTo;

public class HealthCheck {

    @Given("Api kullanicisi {string} path parametrelerini olusturur")
    public void api_kullanicisi_path_parametrelerini_olusturur(String pp1) {
        spec.pathParam("pp1", pp1);
        API_Methods.pathParam = "/{pp1}";
    }
    @Given("Api kullanicisi response bodydeki message bilgisinin {string} oldugunu dogrular")
    public void api_kullanicisi_response_bodydeki_message_bilgisinin_oldugunu_dogrular(String message) {
        API_Methods.response.then()
                .assertThat()
                .body("message", equalTo(message));
    }
}
