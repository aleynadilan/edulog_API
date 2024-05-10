package stepdefinitions;

import io.cucumber.java.en.*;
import utilities.API_Methods;
import utilities.PicoContainer;

import static hooks.HooksAPI.spec;
import static utilities.API_Methods.pathParam;
import static utilities.API_Methods.response;

public class CampusStudentSelectStudentId {
    PicoContainer picoContainer;
    public CampusStudentSelectStudentId(PicoContainer picoContainer) {
        this.picoContainer=picoContainer;
    }

    @Given("Mustafa kullanicisi donen body govdesinden base_url-campus-student-:studentId icin rastgele bir ogrenci idsini bir degiskene kaydeder")
    public void mustafa_kullanicisi_donen_body_govdesinden_base_url_campus_student_student_ıd_icin_rastgele_bir_ogrenci_idsini_bir_degiskene_kaydeder() {
        int rastgeleSecilenOgrenciId = picoContainer.getRastgeleSecilenOgrenciId();
        picoContainer.setRastgeleSecilenOgrenciId(rastgeleSecilenOgrenciId);
        System.out.println("rastgeleSecilenOgrenciId = " + rastgeleSecilenOgrenciId);

    }
    @Given("Mustafa kullanicisi {string}, {string} ve :studentId gerekli path parametrelerini olusturur")
    public void mustafa_kullanicisi_ve_student_ıd_gerekli_path_parametrelerini_olusturur(String pp1, String pp2) {
        int pp3 = picoContainer.rastgeleSecilenOgrenciId;
        spec.pathParams("pp1", pp1, "pp2", pp2,"pp3",pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
        System.out.println("pp3 = " + pp3);
    }
    @Given("Mustafa kullanicisi base_url-campus-student-:studentId icin get request islemini yapar")
    public void mustafa_kullanicisi_base_url_campus_student_student_ıd_icin_get_request_islemini_yapar() {
        API_Methods.getResponse(pathParam);

    }
    @Given("Mustafa kullanicisi {string}, {string} ve {string} path icin parametrelerini olusturur")
    public void mustafa_kullanicisi_ve_path_icin_parametrelerini_olusturur(String pp1, String pp2, String arg) {
        pathParam= "/{pp1}/{pp2}/{pp3}";
        int pp3=picoContainer.rastgeleSecilenOgrenciId;
        System.out.println("pp3 postislemi icin = " + pp3);
        spec.pathParams("pp1", pp1, "pp2", pp2,"pp3",pp3);

    }
    @Given("Mustafa kullanicisi base_url-campus-student-:studentId icin post request gonderir")
    public void mustafa_kullanicisi_base_url_campus_student_student_ıd_icin_post_request_gonderir() {
        API_Methods.postResponseNoBody(pathParam);
    }
    @Then("Mustafa kullanicisi base_url-campus-student-:studentId icin status code {int} oldugunu dogrular")
    public void mustafa_kullanicisi_base_url_campus_student_student_ıd_icin_status_code_oldugunu_dogrular(Integer int1) {
        API_Methods.statusCodeAssert(int1);
    }

    @Given("Mustafa kullanicisi {string}, {string} ve :studentId path parametrelerini olusturur")
    public void mustafa_kullanicisi_ve_student_ıd_path_parametrelerini_olusturur(String pp1, String pp2) {
        pathParam= "/{pp1}/{pp2}/{pp3}";
        int pp3=picoContainer.rastgeleSecilenOgrenciId;
        System.out.println("pp3 delete islemi icin = " + pp3);
        spec.pathParams("pp1", pp1, "pp2", pp2,"pp3",pp3);
    }
    @Given("Mustafa kullanicisi base_url-campus-student-:studentId icin DELETE request gonderir")
    public void mustafa_kullanicisi_base_url_campus_student_student_ıd_icin_delete_request_gonderir() {
        API_Methods.deleteResponse(pathParam);
    }


}