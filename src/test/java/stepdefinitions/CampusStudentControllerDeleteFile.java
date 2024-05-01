package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.API_Methods;

import static hooks.HooksAPI.spec;

public class CampusStudentControllerDeleteFile {
    @Given("Mustafa kullanicisi {string}, {string},{string} ve :familyId path parametrelerini olusturur")
    public void mustafa_kullanicisi_ve_family_ıd_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3).queryParams("familyId", "11");
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";

    }
}
