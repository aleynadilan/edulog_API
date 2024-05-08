package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import utilities.API_Methods;
import utilities.PicoContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static hooks.HooksAPI.spec;
import static org.junit.Assert.assertEquals;


public class CampusStudentStepFinance {
    PicoContainer picoContainer;
    public CampusStudentStepFinance(PicoContainer picoContainer) {
        this.picoContainer=picoContainer;
    }
    //     int rastgeleSecilenOgrenciId;

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

        int picoContainerRastgeleSecilenOgrenciId = picoContainer.getRastgeleSecilenOgrenciId();
        picoContainer.setRastgeleSecilenOgrenciId(picoContainerRastgeleSecilenOgrenciId);
        System.out.println("picoContainerRastgeleSecilenOgrenciId = " + picoContainerRastgeleSecilenOgrenciId);
    }

    @And("Mustafa kullanicisi {string} seklindeki endpointi icin get request gonderir ve donen response kaydeder")
    public void mustafaKullanicisiSeklindekiEndpointiIcinGetRequestGonderirVeDonenResponseKaydeder(String arg0) {
        API_Methods.getResponse(API_Methods.pathParam);
    }

    @And("Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder")
    public void mustafaKullanicisiDonenBodyGovdesindenRastgeleBirPricingsIdsiniBirDegiskeneKaydeder() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        int responseSize = jsonPath.getInt("data.size()");

        Random random = new Random();
        int dataIndex = random.nextInt(responseSize);

        rastgeleSecilenPricingsId = jsonPath.getInt("data[" + dataIndex + "].id");
        System.out.println("rastgeleSecilenPricingsId = " + rastgeleSecilenPricingsId);
    }


    @And("Mustafa kullanicisi {string} icin yeni body olusturur")
    public void mustafaKullanicisiIcinYeniBodyOlusturur(String arg0) {

        API_Methods.requestBody = "{\n" +
                "  \"financePricings\": [\n" +
                "    " + rastgeleSecilenPricingsId + "\n" +
                "  ],\n" +
                "  \"student\": " + picoContainer.rastgeleSecilenOgrenciId + "\n" +
                "}";
    }

    @And("Mustafa kullanicisi base_url-campus-student-step_finance icin yeni body olusturur")
    public void mustafaKullanicisiBase_urlCampusStudentStep_financeIcinYeniBodyOlusturur() {

        API_Methods.requestBody = "{\n" +
                "  \"financePricings\": [\n" +
                "    " + rastgeleSecilenPricingsId + "\n" +
                "  ],\n" +
                "  \"student\": " + picoContainer.rastgeleSecilenOgrenciId + "\n" +
                "}";
    }


    @And("Mustafa kullanicisi base_url-campus-student-step_finance-calculate icin post request gonderir")
    public void mustafaKullanicisiBase_urlCampusStudentStep_financeCalculateIcinPostRequestGonderir() {
        API_Methods.postResponse(API_Methods.requestBody, API_Methods.pathParam);

    }

    @And("Mustafa kullanicisi base_url-campus-student-step_finance icin post request gonderir")
    public void mustafaKullanicisiBase_urlCampusStudentStep_financeIcinPostRequestGonderir() {
        API_Methods.postResponse(API_Methods.requestBody, API_Methods.pathParam);
    }

    @And("Mustafa kullanicisi base_url-campus-student-step_finance icin bos body olusturur")
    public void mustafaKullanicisiBase_urlCampusStudentStep_financeIcinBosBodyOlusturur() {
        API_Methods.requestBody = "";
    }

    @And("Mustafa kullanicisi errorData degerlerinin varligini dogrular")
    public void mustafaKullanicisiErrorDataDegerlerininVarliginiDogrular() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        List<String> errorData = jsonPath.getList("errorData");

        List<String> expectedErrorData = Arrays.asList(
                "financePricings must be an array",
                "financePricings should not be empty",
                "student must be a number conforming to the specified constraints",
                "student should not be empty"
        );

        Assert.assertEquals(expectedErrorData, errorData);
    }

    @And("Mustafa kullanicisi base_url-campus-student-step_finance icin studentid olmayan body olusturur")
    public void mustafaKullanicisiBase_urlCampusStudentStep_financeIcinStudentidOlmayanBodyOlusturur() {
        API_Methods.requestBody = "{\n" +
                "  \"financePricings\": [\n" +
                "    \"" + rastgeleSecilenPricingsId + "\"\n" +
                "  ],\n" +
                "  \"student\": \"\"\n" +
                "}";
    }

    @And("Mustafa kullanicisi id olmadan errorData degerlerinin varligini dogrular")
    public void mustafaKullanicisiIdOlmadanErrorDataDegerlerininVarliginiDogrular() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        List<String> errorData = jsonPath.getList("errorData");

        List<String> expectedErrorData = Arrays.asList("student must be a number conforming to the specified constraints",
                "student should not be empty");
        Assert.assertEquals(expectedErrorData, errorData);
    }
}