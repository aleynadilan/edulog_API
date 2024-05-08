package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class PicoContainer {
    public Response responseSchoolStageGet;
    public String pathParamSchoolStageGet;
    public RequestSpecification specSchoolStage;
    public int rastgeleSecilenOgrenciId;

    public int getRastgeleSecilenOgrenciId() {
        JsonPath jsonPath = API_Methods.response.jsonPath();
        int responseSize = jsonPath.getInt("Array.size()");

        Random random = new Random();
        int dataIndex = random.nextInt(responseSize);

        rastgeleSecilenOgrenciId = jsonPath.getInt("[" + dataIndex + "].id");
        return rastgeleSecilenOgrenciId;
    }

    public void setRastgeleSecilenOgrenciId(int rastgeleSecilenOgrenciId) {
        this.rastgeleSecilenOgrenciId = rastgeleSecilenOgrenciId;
    }




}