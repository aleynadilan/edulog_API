package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.API_Methods;
import utilities.PicoContainer;

import static hooks.HooksAPI.spec;

public class CampusParents {
    PicoContainer picoContainer;

    public CampusParents(PicoContainer picoContainer) {
        this.picoContainer=picoContainer;
    }

    @Given("Mustafa kullanicisi {string}, {string},{string},{string},{string} path ve query parametrelerini olusturur")
    public void mustafa_kullanicisi_path_ve_query_parametrelerini_olusturur(String pp1, String pp2, String pp3, String pp4, String pp5) {
        int ids = picoContainer.rastgeleSecilenOgrenciId;
        System.out.println("ids = " + ids);
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3, "pp4", pp4, "pp5", pp5).queryParam("ids", ""+ids+"");
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}/{pp4}/{pp5}";
    }


    @And("Mustafa kullanicisi {string} icin get request gonderir ve donen responsei kaydeder")
    public void mustafaKullanicisiIcinGetRequestGonderirVeDonenResponseiKaydeder(String arg0) {
        API_Methods.getResponse(API_Methods.pathParam);

    }
}
