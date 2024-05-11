package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.API_Methods;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.File;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;
import static utilities.API_Methods.pathParam;
import static utilities.API_Methods.requestBody;

public class CampusStudentUploadSinglefileUserId {
    public RequestSpecification excelSpec;


    @Given("Mustafa kullanicisi {string} icin post request gonderir ve donen responsei kaydeder")
    public void mustafa_kullanicisi_icin_post_request_gonderir_ve_donen_responsei_kaydeder(String string) {

        // Request specification oluşturuluyor
        excelSpec = new RequestSpecBuilder()
                .setBaseUri("https://panelbe.edulog.com.tr")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + Authentication.generateToken("employee"))
                .build();

// Post işlemi için URL oluşturuluyor
        String userId = "11";
        String postUrl = "/campus/student/upload_single_file/" + userId;

// Post işlemi gerçekleştiriliyor
        Response response = given()
                .spec(excelSpec)
                .multiPart("file", new File("C:\\Selenium\\edulog_API\\src\\test\\resources\\features\\API\\campus\\student\\student.xls"))
                .when()
                .post(postUrl);

// Yanıt kontrol ediliyor
        response.then()
                .statusCode(201);

    }


}
