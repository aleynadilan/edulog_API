package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PanelOkulResmiBelgeTurleri {

    API_Methods api_methods = new API_Methods();
    JsonPath jsonPath;

    @Given("Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular")
    public void api_kullanicisi_response_bodydeki_status_bilgisinin_true_oldugunu_dogrular() {
        API_Methods.response.then()
                .assertThat()
                .body("status", equalTo(true));
    }

    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olan {string} bilgisini dogrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olan_bilgisini_dogrular(int dataIndex, String key) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(key, jsonPath.getString("data[" + dataIndex + "].key"));
    }

    @Given("Api kullanicisi panel school official file type endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_panel_school_official_file_type_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/panelOkulResmiBelgeTurleri/panelSchoolOfficialFileType.json");
    }
}
