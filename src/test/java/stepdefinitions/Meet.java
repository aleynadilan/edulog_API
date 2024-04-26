package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Meet {

    JsonPath jsonPath;

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

}
