package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.API_Methods;

import java.util.List;
import java.util.Random;

import static hooks.HooksAPI.spec;
import static org.junit.Assert.assertEquals;


public class CampusStudentStepFinance {
    int rastgeleSecilenOgrenciId;
    int rastgeleSecilenPricingsId;
    @Given("Mustafa kullanicisi {string}, {string} path parametrelerini olusturur")
    public void mustafa_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2) {
        spec.pathParams("pp1", pp1, "pp2", pp2);
        API_Methods.pathParam = "/{pp1}/{pp2}";
    }

    @And("Mustafa kullanicisi {string} endpointi icin get request gonderir ve donen response kaydeder")
    public void mustafaKullanicisiEndpointiIcinGetRequestGonderirVeDonenResponseKaydeder(String arg0) {
        API_Methods.getResponse(API_Methods.pathParam);
    }

    @And("Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder")
    public void mustafaKullanicisiDonenBodyGovdesindenRastgeleBirOgrenciIdsiniBirDegiskeneKaydeder() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        int responseSize = jsonPath.getInt("Array.size()");

        Random random =new Random();
        int dataIndex = random.nextInt(responseSize);

        rastgeleSecilenOgrenciId = jsonPath.getInt("[" + dataIndex + "].id");

    }

    @And("Mustafa kullanicisi {string} seklindeki endpointi icin get request gonderir ve donen response kaydeder")
    public void mustafaKullanicisiSeklindekiEndpointiIcinGetRequestGonderirVeDonenResponseKaydeder(String arg0) {
        API_Methods.getResponse(API_Methods.pathParam);
    }

    @And("Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder")
    public void mustafaKullanicisiDonenBodyGovdesindenRastgeleBirPricingsIdsiniBirDegiskeneKaydeder() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        int responseSize = jsonPath.getInt("data.size()");

        Random random =new Random();
        int dataIndex = random.nextInt(responseSize);

        rastgeleSecilenPricingsId = jsonPath.getInt("data[" + dataIndex + "].id");
        System.out.println("rastgeleSecilenPricingsId = " + rastgeleSecilenPricingsId);
    }



    @And("Mustafa kullanicisi {string} icin yeni body olusturur")
    public void mustafaKullanicisiIcinYeniBodyOlusturur(String arg0) {
        API_Methods.requestBody="{\n" +
                "  \"financePricings\": [\n" +
                "    " + rastgeleSecilenPricingsId + "\n" +
                "  ],\n" +
                "  \"student\": " + rastgeleSecilenOgrenciId + "\n" +
                "}";
    }
}