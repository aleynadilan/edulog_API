package stepdefinitions;

import io.cucumber.java.en.*;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class CampusEmployee {
/*
{
    "status": true,
    "message": "success",
    "data": "",
    "statusCode": 200
}
 */
    @When("Api kullanicisi {string}, {string}, {string} ve {string} path parametrelerini olusturur")
    public void api_kullanicisi_ve_path_parametrelerini_olusturur(String path1, String path2, String path3, String path4) {
        spec.pathParams("path1",path1,"path2", path2,"path3", path3,"path4", path4);
        API_Methods.pathParam = "/{path1}/{path2}/{path3}/{path4}";

    }
    @Then("Api kullanicisi post request gonderir ve donen responsei kaydeder")
    public void api_kullanicisi_post_request_gonderir_ve_donen_responsei_kaydeder() {

    }
}
