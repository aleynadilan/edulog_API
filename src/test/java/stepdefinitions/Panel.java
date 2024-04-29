package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static org.junit.Assert.*;

public class Panel {

    JsonPath jsonPath;

    // ***************************************** /panel/cgs-list ****************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olanin {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("data[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("data[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("data[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("data[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
    }
    // **************************************************************************************************************

    // *************************************** /panel/module-list ***************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olanin {string} bilgisini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olanin_bilgisini_doğrular(int dataIndex, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
    }
    // **************************************************************************************************************
}
