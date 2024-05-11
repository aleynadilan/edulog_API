package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.API_Methods;

import java.util.List;
import java.util.Random;

import static hooks.HooksAPI.spec;

public class CampusStudentStepStudent {
    public String generateIdNumber() {
        StringBuilder idNumberBuilder = new StringBuilder("8");

        // İlk dokuz rakamı oluştur
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            idNumberBuilder.append(random.nextInt(10)); // 0 ile 9 arasında rastgele rakam ekle
        }

        // İlk dokuz rakam üzerinde hesaplama yaparak 10. haneyi bul
        int sumOdd = Character.getNumericValue(idNumberBuilder.charAt(0)) +
                Character.getNumericValue(idNumberBuilder.charAt(2)) +
                Character.getNumericValue(idNumberBuilder.charAt(4)) +
                Character.getNumericValue(idNumberBuilder.charAt(6)) +
                Character.getNumericValue(idNumberBuilder.charAt(8));
        int sumEven = Character.getNumericValue(idNumberBuilder.charAt(1)) +
                Character.getNumericValue(idNumberBuilder.charAt(3)) +
                Character.getNumericValue(idNumberBuilder.charAt(5)) +
                Character.getNumericValue(idNumberBuilder.charAt(7));
        int tenthDigit = (sumOdd * 7 - sumEven) % 10;

        idNumberBuilder.append(tenthDigit);

        // İlk dokuz rakam ile 10. haneyi kullanarak 11. haneyi bul
        int sumAll = 0;
        for (int i = 0; i < 10; i++) {
            sumAll += Character.getNumericValue(idNumberBuilder.charAt(i));
        }
        int eleventhDigit = sumAll % 10;

        idNumberBuilder.append(eleventhDigit);

        String idNumber = idNumberBuilder.toString();
        return idNumber;
    }
    @Given("Mustafa kullanicisi {string} icin body olusturur")
    public void mustafa_kullanicisi_icin_body_olusturur(String string) {
        // Kimlik numarası oluşturma fonksiyonu
        String s = generateIdNumber();
        API_Methods.requestBody="{\n" +
                "  \"isForeign\": false,\n" +
                "  \"name\": \"Tarik Akan\",\n" +
                "  \"idNumber\": \""+s+"\",\n" +
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
