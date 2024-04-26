package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class Default {

    @Given("Api kullanicisi {string}, {string}, {string} path parametrelerini olusturur")
    public void api_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
    }
}
