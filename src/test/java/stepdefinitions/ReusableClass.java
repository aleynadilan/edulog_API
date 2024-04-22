package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import utilities.API_Methods;

public class ReusableClass {
    @Given("Api kullanicisi {string} token ile base urli olusturur")
    public void api_kullanicisi_token_ile_base_urli_olusturur(String user) {
        HooksAPI.setUpApi(user);
    }

    @Given("Api kullanicisi status codeun {int} oldugunu dogrular")
    public void api_kullanicisi_status_codeun_oldugunu_dogrular(int code) {
        API_Methods.statusCodeAssert(code);
    }
}
