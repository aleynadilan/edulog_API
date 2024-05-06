package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.API_Methods;
import utilities.Authentication;

import java.util.Random;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static utilities.API_Methods.pathParam;


public class CampusStudentSelectStudentId {

    RequestSpecification specStudentId;
    int rastgeleSecilenOgrenciId;

    Response response;

    @Given("Mustafa kullanicisi {string}, {string} ve :studentId path parametrelerini olusturur")
    public void mustafa_kullanicisi_ve_student_ıd_path_parametrelerini_olusturur(String pp1, String pp2) {
        specStudentId = new RequestSpecBuilder()
                .setBaseUri("https://panelbe.edulog.com.tr")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + Authentication.generateToken("student"))
                .build();

        int pp3 = rastgeleSecilenOgrenciId;
        specStudentId.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        pathParam = "/{pp1}/{pp2}/{pp3}";

    }

    @Given("Mustafa kullanicisi base_url-campus-student-:studentId icin get request gonderir")
    public void mustafa_kullanicisi_base_url_campus_student_student_ıd_icin_get_request_gonderir() {
        API_Methods.getResponse(pathParam);
    }

    @And("Mustafa kullanicisi base_url-campus-student-:studentId icin post request gonderir")
    public void mustafaKullanicisiBase_urlCampusStudentStudentIdIcinPostRequestGonderir() {
        response = given()
                .spec(specStudentId)
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .post(pathParam);

        response.prettyPrint();

    }

    @Then("Mustafa kullanicisi base_url-campus-student-:studentId icin status code {int} oldugunu dogrular")
    public void mustafaKullanicisiBase_urlCampusStudentStudentIdIcinStatusCodeOldugunuDogrular(int arg0) {
        response.then().statusCode(arg0);
    }

    @And("Mustafa kullanicisi donen body govdesinden base_url-campus-student-:studentId icin rastgele bir ogrenci idsini bir degiskene kaydeder")
    public void mustafaKullanicisiDonenBodyGovdesindenBase_urlCampusStudentStudentIdIcinRastgeleBirOgrenciIdsiniBirDegiskeneKaydeder() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        int responseSize = jsonPath.getInt("Array.size()");

        Random random = new Random();
        int dataIndex = random.nextInt(responseSize);

        rastgeleSecilenOgrenciId = jsonPath.getInt("[" + dataIndex + "].id");
        System.out.println("rastgeleSecilenOgrenciId = " + rastgeleSecilenOgrenciId);
    }

    @And("Mustafa kullanicisi base_url-campus-student-:studentId icin DELETE request gonderir")
    public void mustafaKullanicisiBase_urlCampusStudentStudentIdIcinDELETERequestGonderir() {
        response = given()
                .spec(specStudentId)
                .when()
                .delete(pathParam);

        response.prettyPrint();
    }
}
