package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static org.junit.Assert.*;

public class Panel {

    API_Methods api_methods = new API_Methods();
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

    @Given("Api kullanicisi panel cgs list endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_panel_cgs_list_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/panel/panelJsonSchema/panelCgsList.json");
    }
    // **************************************************************************************************************

    // *************************************** /panel/module-list ***************************************************
    @Given("Api kullanıcısi response body icinde {int} indexe sahip olanin {string} bilgisini doğrular.")
    public void api_kullanıcısi_response_body_icinde_indexe_sahip_olanin_bilgisini_doğrular(int dataIndex, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
    }
    @Given("Api kullanicisi panel module list endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_panel_module_list_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/panel/panelJsonSchema/panelModuleList.json");
    }
    // **************************************************************************************************************
}
