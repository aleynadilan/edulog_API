package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class CampusParents {
    @Given("Mustafa kullanicisi {string}, {string},{string},{string},{string} path ve query parametrelerini olusturur")
    public void mustafa_kullanicisi_path_ve_query_parametrelerini_olusturur(String pp1, String pp2, String pp3, String pp4, String pp5) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3, "pp4", pp4, "pp5", pp5).queryParams("ids", "15", "ids", "33");
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}/{pp4}/{pp5}";
    }


    @And("Mustafa kullanicisi {string} icin get request gonderir ve donen responsei kaydeder")
    public void mustafaKullanicisiIcinGetRequestGonderirVeDonenResponseiKaydeder(String arg0) {
        API_Methods.getResponse(API_Methods.pathParam);

    }
}
