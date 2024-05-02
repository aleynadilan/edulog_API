package stepdefinitions;

import io.cucumber.java.en.*;
import org.json.JSONObject;
import utilities.API_Methods;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.equalTo;

public class CampusEmployee {
/*
{
    "status": true,
    "message": "success",
    "data": "",
    "statusCode": 200
}
 */

    JSONObject requesBody;

    @When("Api kullanicisi {string}, {string}, {string} ve {string} path parametrelerini olusturur")
    public void api_kullanicisi_ve_path_parametrelerini_olusturur(String path1, String path2, String path3, String path4) {
        spec.pathParams("path1", path1, "path2", path2, "path3", path3, "path4", path4);
        API_Methods.pathParam = "/{path1}/{path2}/{path3}/{path4}";

    }

    @Then("Api kullanicisi responce'a gonderecegi body'i olusturur")
    public void api_kullanicisi_responce_a_gonderecegi_body_i_olusturur() {
        requesBody = new JSONObject();
        int[] id = {1, 2, 3, 4};
        JSONObject update = new JSONObject();
        update.put("isActive", true);
        requesBody.put("ids", id);
        requesBody.put("update", update);

    }

    @Then("Api kullanicisi post request gonderir ve donen responsei kaydeder")
    public void api_kullanicisi_post_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.postResponse(requesBody.toString(), API_Methods.pathParam);
    }

    @Then("Api kullanicisi responce body'deki errorData'nin Unauthorized oldugunu dogrular")
    public void api_kullanicisi_responce_body_deki_error_data_nin_unauthorized_oldugunu_dogrular() {
        API_Methods.response.then()
                .assertThat()
                .body(equalTo("Unauthorized"));
    }


    //****************************** Download *********************************************

    @Then("Api kullanicisi GET request gonderir ve donen responsei kaydeder")
    public void api_kullanicisi_get_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.getBodyResponse(requesBody.toString(), API_Methods.pathParam);
    }

    @When("Api kullanicisi {int} ve {int} query parametrelerini ve body'i olusturur")
    public void api_kullanicisi_ve_query_parametrelerini_ve_bodyi_olusturur(int ids, int ids2) {

//        spec.queryParams("ids", ids, "ids", ids2); // ikinci yol
        requesBody = new JSONObject();

        int[] id = {ids, ids2};
        requesBody.put("ids", id);

        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("ids", ids);
        queryParams.put("ids", ids2);
        API_Methods.getResponseWithBodyAndQueryParams(requesBody.toString(), API_Methods.pathParam,queryParams);
    }
}
