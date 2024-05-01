package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.API_Methods;

public class CampusStudentFile {


    @Given("Mustafa kullanicisi {string} icin delete request gonderir ve donen response kaydeder")
    public void mustafa_kullanicisi_icin_delete_request_gonderir_ve_donen_response_kaydeder(String string) {
        API_Methods.deleteResponse(API_Methods.pathParam);
    }

}
