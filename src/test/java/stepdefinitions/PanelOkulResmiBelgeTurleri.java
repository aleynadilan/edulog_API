package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PanelOkulResmiBelgeTurleri {

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
}
