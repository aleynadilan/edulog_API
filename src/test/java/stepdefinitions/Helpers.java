package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import utilities.API_Methods;
import utilities.ConfigReader;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Helpers {

    API_Methods api_methods = new API_Methods();
    JsonPath jsonPath;

    @Given("Api kullanicisi {string}, {string} path parametrelerini olusturur")
    public void api_kullanicisi_path_parametrelerini_olusturur(String pp1, String pp2) {
        spec.pathParams("pp1", pp1, "pp2", pp2);
        API_Methods.pathParam = "/{pp1}/{pp2}";
    }

    @Given("Api kullanicisi {string}, {string} ve {int} path parametrelerini olusturur")
    public void api_kullanicisi_ve_path_parametrelerini_olusturur(String pp1, String pp2, int pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
    }

    @Given("Api kullanicisi {string}, {string} ve {string} path parametrelerini olusturur")
    public void api_kullanicisi_ve_path_parametrelerini_olusturur(String pp1, String pp2, String pp3) {
        spec.pathParams("pp1", pp1, "pp2", pp2, "pp3", pp3);
        API_Methods.pathParam = "/{pp1}/{pp2}/{pp3}";
    }

    @Given("Api kullanicisi get request gonderir ve donen responsei kaydeder")
    public void api_kullanicisi_get_request_gonderir_ve_donen_responsei_kaydeder() {
        API_Methods.getResponse(API_Methods.pathParam);
    }

    @Given("Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular")
    public void api_kullanicisi_donen_responsei_kaydeder_status_codeun_ve_reason_phrase_bilgisinin_unauthorized_oldugunu_dogrular() {
        assertTrue(API_Methods.tryCatchGet(API_Methods.pathParam).equals(ConfigReader.getProperty("unauthorizedExceptionMessage")));
    }

    // ***************************************** /helpers/employees *************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String name, String roleName) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(roleName, jsonPath.getString("[" + dataIndex + "].role.name"));
    }

    @Given("Api kullanicisi helpers employees endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_employees_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersEmployees.json");
    }
    // **************************************************************************************************************

    // ***************************************** /helpers/students **************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string} bilgisinin doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_bilgisinin_doğrular(int dataIndex, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
    }

    @Given("Api kullanicisi helpers students endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_students_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersStudents.json");
    }
    // **************************************************************************************************************

    // ***************************************** /helpers/cities ****************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
    }

    @Given("Api kullanicisi helpers cities endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_cities_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersCities.json");
    }
    // **************************************************************************************************************

    // *************************************** /helpers/county/{cityId}} ********************************************
    @Given("Api kullanicisi response body'deki arrayin bos oldugunu dogrular")
    public void api_kullanicisi_response_body_deki_arrayin_bos_oldugunu_dogrular() {
        API_Methods.response.then()
                .assertThat()
                .body("", empty());
    }

    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string}, {string}, {string} ve {int} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name, int cityId) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(cityId, jsonPath.getInt("[" + dataIndex + "].cityId"));
    }

    @Given("Api kullanicisi helpers county endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_county_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersCounty.json");
    }
    // **************************************************************************************************************

    // *************************************** /helpers/district/{id}} **********************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olan {string}, {string}, {string} ve {int} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name, int countyId) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(countyId, jsonPath.getInt("[" + dataIndex + "].countyId"));
    }
    // **************************************************************************************************************

    // ******************************************* /helpers/mixed ***************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olan {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("cities[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("cities[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("cities[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("cities[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("cities[" + dataIndex + "].name"));
    }
    // **************************************************************************************************************

    // ******************************************* /helpers/seasons *************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olan {string}, {string}, {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name, String seasonStartDate, String seasonEndDate) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(seasonStartDate, jsonPath.getString("[" + dataIndex + "].seasonStartDate"));
        assertEquals(seasonEndDate, jsonPath.getString("[" + dataIndex + "].seasonEndDate"));
    }

    @Given("Api kullanicisi helpers seasons endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_seasons_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersSeasons.json");
    }
    // **************************************************************************************************************

    // ************************************* /helpers/classes/{seasonId} ********************************************
    @Given("Api kullanıcısi response bodyde ki {int} indexe sahip olanin {string}, {string}, {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_bodyde_ki_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, String name, String level_key) {
        jsonPath = API_Methods.response.jsonPath();

        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertEquals(level_key, jsonPath.getString("[" + dataIndex + "].level_key"));
    }

    @Given("Api kullanicisi helpers classes endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_classes_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersClasses.json");
    }
    // **************************************************************************************************************

    // *********************************** /helpers/stage-classes/{stage} *******************************************
    @Given("Api kullanıcısi response bodyde branchList arrayinde ki {int} indexe sahip olanin {int}, {string} ve {int} bilgilerini doğrular.")
    public void api_kullanıcısi_response_bodyde_branch_list_arrayinde_ki_indexe_sahip_olanin_ve_bilgilerini_doğrular(int dataIndex, int value, String label, int classId) {
        jsonPath = API_Methods.response.jsonPath();

        assertEquals(value, jsonPath.getInt("branchList[" + dataIndex + "].value"));
        assertEquals(label, jsonPath.getString("branchList[" + dataIndex + "].label"));
        assertEquals(classId, jsonPath.getInt("branchList[" + dataIndex + "].classId"));
    }

    @Given("Api kullanicisi helpers stage classes endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_stage_classes_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersStageClasses.json");
    }
    // **************************************************************************************************************

    // ***************************************** /helpers/role-list *************************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olan {string} ve {string} bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olan_ve_bilgilerini_doğrular(int dataIndex, String name, String key) {
        API_Methods.response.then()
                .assertThat()
                .body("[" + dataIndex + "].name", equalTo(name),
                        "[" + dataIndex + "].key", equalTo(key));
    }

    @Given("Api kullanicisi helpers role list endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_role_list_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersRoleList.json");
    }
    // **************************************************************************************************************

    // *************************************** /helpers/responsible-teachers ****************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string} bilgisini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_bilgisini_doğrular(int dataIndex, String name) {
        API_Methods.response.then()
                .assertThat()
                .body("[" + dataIndex + "].name", equalTo(name));
    }

    @Given("Api kullanicisi helpers responsible teachers endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_responsible_teachers_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersResponsibleTeachers.json");
    }
    // **************************************************************************************************************

    // ************************************ /helpers/responsible-students/{id} **************************************
    @Given("Api kullanıcısi response body icindeki {int} indexe sahip olanin {string}, {string}, {int}, {int}, {int}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string}, {int}, {int}, {int}, {int}  bilgilerini doğrular.")
    public void api_kullanıcısi_response_body_icindeki_indexe_sahip_olanin_bilgilerini_doğrular(int dataIndex, String createdAt, String updatedAt, int companyId, int groupId, int schoolId, String registerType, String name, String idNumber, String phone, String bloodType, String birthday, String gender, int cityId, int countyId, int districtId, String addressDetail, String studentNumber, int classId, int branchId, int seasonId, int teacherId) {
        jsonPath = API_Methods.response.jsonPath();

        assertFalse(jsonPath.getBoolean("[" + dataIndex + "].isActive"));
        assertEquals(createdAt, jsonPath.getString("[" + dataIndex + "].createdAt"));
        assertEquals(updatedAt, jsonPath.getString("[" + dataIndex + "].updatedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].deletedAt"));
        assertNull(jsonPath.get("[" + dataIndex + "].isBanned"));
        assertNull(jsonPath.get("[" + dataIndex + "].banEndDate"));
        assertNull(jsonPath.get("[" + dataIndex + "].nameId"));
        assertEquals(companyId, jsonPath.getInt("[" + dataIndex + "].companyId"));
        assertEquals(groupId, jsonPath.getInt("[" + dataIndex + "].groupId"));
        assertEquals(schoolId, jsonPath.getInt("[" + dataIndex + "].schoolId"));
        assertTrue(jsonPath.getBoolean("[" + dataIndex + "].testUser"));
        assertEquals(registerType, jsonPath.getString("[" + dataIndex + "].registerType"));
        assertEquals(name, jsonPath.getString("[" + dataIndex + "].name"));
        assertFalse(jsonPath.getBoolean("[" + dataIndex + "].isForeign"));
        assertEquals(idNumber, jsonPath.getString("[" + dataIndex + "].idNumber"));
        assertEquals(phone, jsonPath.getString("[" + dataIndex + "].phone"));
        assertEquals(bloodType, jsonPath.getString("[" + dataIndex + "].bloodType"));
        assertNull(jsonPath.get("[" + dataIndex + "].email"));
        assertEquals(birthday, jsonPath.getString("[" + dataIndex + "].birthday"));
        assertEquals(gender, jsonPath.getString("[" + dataIndex + "].gender"));
        assertEquals(cityId, jsonPath.getInt("[" + dataIndex + "].cityId"));
        assertEquals(countyId, jsonPath.getInt("[" + dataIndex + "].countyId"));
        assertEquals(districtId, jsonPath.getInt("[" + dataIndex + "].districtId"));
        assertNull(jsonPath.get("[" + dataIndex + "].nationalityId"));
        assertEquals(addressDetail, jsonPath.getString("[" + dataIndex + "].addressDetail"));
        assertEquals(studentNumber, jsonPath.getString("[" + dataIndex + "].studentNumber"));
        assertEquals(classId, jsonPath.getInt("[" + dataIndex + "].classId"));
        assertEquals(branchId, jsonPath.getInt("[" + dataIndex + "].branchId"));
        assertEquals(seasonId, jsonPath.getInt("[" + dataIndex + "].seasonId"));
        assertNull(jsonPath.get("[" + dataIndex + "].area"));
        assertEquals(teacherId, jsonPath.getInt("[" + dataIndex + "].teacherId"));
    }

    @Given("Api kullanicisi helpers responsible students id endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_responsible_students_id_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersResponsibleStudentsId.json");
    }
    // **************************************************************************************************************

    // ******************************************** /helpers/branches ***********************************************
    @Given("Api kullanicisi helpers branches endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_branches_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersBranches.json");
    }
    // **************************************************************************************************************

    // ******************************************* /helpers/nationality *********************************************
    @Given("Api kullanicisi helpers nationality endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_nationality_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersNationality.json");
    }
    // **************************************************************************************************************

    // ************************************ /helpers/responsible-students *******************************************
    @Given("Api kullanicisi helpers responsible students endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_responsible_students_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersResponsibleStudents.json");
    }
    // **************************************************************************************************************

    // **************************************** /helpers/stage-branches *********************************************

    @Given("Api kullanicisi helpers stage branches endpointinden donen response bodynin schema validation dogrulamasini yapar")
    public void api_kullanicisi_helpers_stage_branches_endpointinden_donen_response_bodynin_schema_validation_dogrulamasini_yapar() {
        api_methods.schemaValidation("features/API/helpers/helpersJsonSchema/helpersStageBranches.json");
    }
    // **************************************************************************************************************
}
