package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.API_Methods;

import java.util.List;

import static hooks.HooksAPI.spec;

public class CampusStudentStepStudent {
    @Given("Mustafa kullanicisi {string} icin body olusturur")
    public void mustafa_kullanicisi_icin_body_olusturur(String string) {
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": false,\n" +
                "  \"name\": \"Tarik Akan\",\n" +
                "  \"idNumber\": \"35321176424\",\n" +
                "  \"firstCreate\": true\n" +
                "}";
    }
    @Given("Mustafa kullanicisi {string} icin post request gonderir ve donen response kaydeder")
    public void mustafa_kullanicisi_icin_post_request_gonderir_ve_donen_response_kaydeder(String string) {
       API_Methods.postResponse(API_Methods.requestBody,API_Methods.pathParam);
    }
    @Then("Mustafa kullanicisi {string} dosyasi schema validation yapar")
    public void mustafa_kullanicisi_dosyasi_schema_validation_yapar(String string) {
        string="features/API/campus/student/campusstepstudent.json";
       API_Methods.schemaValidation(string);
    }

    @And("Mustafa kullanicisi {string} bos name ile  body olusturur")
    public void mustafaKullanicisiBosNameIleBodyOlusturur(String arg0) {
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": false,\n" +
                "  \"name\": \"\",\n" +
                "  \"idNumber\": \"35321176424\",\n" +
                "  \"firstCreate\": true\n" +
                "}";
    }

    @And("Mustafa kullanicisi response {string} icerdigini dogrular")
    public void mustafaKullanicisiResponseIcerdiginiDogrular(String string) {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        String errorData = jsonPath.getString("errorData[0]");

        Assert.assertEquals(string, errorData);

    }

    @And("Mustafa kullanicisi {string} bos id number ile  body olusturur")
    public void mustafaKullanicisiBosIdNumberIleBodyOlusturur(String arg0) {
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": false,\n" +
                "  \"name\": \"Mustafa\",\n" +
                "  \"idNumber\": \"\",\n" +
                "  \"firstCreate\": true\n" +
                "}";
    }

    @And("Mustafa kullanicisi {string} isForeign null ile  body olusturur")
    public void mustafaKullanicisiIsForeignNullIleBodyOlusturur(String arg0) {
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": null,\n" +
                "  \"name\": \"Guduk Necmi\",\n" +
                "  \"idNumber\": \"35321176424\",\n" +
                "  \"firstCreate\": true\n" +
                "}";
    }


}
