package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.API_Methods;

import java.io.InputStream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Meet {

    JsonPath jsonPath;
    JSONObject requestBody;

    // ***************************************** /meet/widgets ******************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olanin {string}, {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String key, String icon, String color, String chartType) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(key, jsonPath.getString("data[" + dataIndex + "].key"));
        assertEquals(icon, jsonPath.getString("data[" + dataIndex + "].icon"));
        assertEquals(color, jsonPath.getString("data[" + dataIndex + "].color"));
        assertEquals(chartType, jsonPath.getString("data[" + dataIndex + "].chartType"));
    }
    // **************************************************************************************************************

    // ********************************** /meet/dashboard-meet-list *************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olan {string}, {string} bilgileri dogrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olan_ve_bilgileri_dogrular(int dataIndex, String type, String name) {
        API_Methods.response.then()
                .assertThat()
                .body("data[" + dataIndex + "].type", equalTo(type),
                        "data[" + dataIndex + "].name", equalTo(name));
    }
    // **************************************************************************************************************

    // ******************************************* /meet/id (get) ***************************************************
    @Given("Api kullanicisi response bodydeki data {int}, {string}, {string}, {string} ve {string} iceriklerini dogrular")
    public void api_kullanicisi_response_bodydeki_data_ve_iceriklerini_dogrular(int id, String createdAt, String updatedAt, String meetDate, String status) {
        API_Methods.response.then()
                .assertThat()
                .body("data.id", equalTo(id),
                        "data.isActive", equalTo(true),
                        "data.createdAt", equalTo(createdAt),
                        "data.updatedAt", equalTo(updatedAt),
                        "data.deletedAt", equalTo(null),
                        "data.description", equalTo(null),
                        "data.meetDate", equalTo(meetDate),
                        "data.status", equalTo(status),
                        "data.isSibling", equalTo(false));
    }
    // **************************************************************************************************************

    // ******************************************* /meet/bulk/update ************************************************
    @Given("Api kullanicisi meet bulk update endpointine gondermek icin gerekli verileri iceren bir post request olusturur")
    public void api_kullanicisi_meet_bulk_update_endpointine_gondermek_icin_gerekli_verileri_iceren_bir_post_request_olusturur() {
        JSONArray ids = new JSONArray();
        ids.put(1);
        ids.put(2);
        ids.put(3);
        ids.put(4);

        JSONObject update = new JSONObject();
        update.put("isActive", true);

        requestBody = new JSONObject();
        requestBody.put("ids", ids);
        requestBody.put("update", update);

        System.out.println(requestBody.toString());
    }

    @Given("Api kullanicisi post request gonderir ve meet bulk update endpointinden donen responsei kaydeder")
    public void api_kullanicisi_post_request_gonderir_ve_meet_bulk_update_endpointinden_donen_responsei_kaydeder() {
        API_Methods.postResponse(requestBody.toString(), API_Methods.pathParam);
    }
    // **************************************************************************************************************

}
