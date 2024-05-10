package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Authentication {

    private Response response;
    private JSONObject body;
    String url;

    private void studentPhone() {
        body = new JSONObject();
        body.put("phone", "5000000000");
        System.out.println("Body : " + body);

        response = given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(body.toString())
                .post("https://testpanelbe.edulog.com.tr/auth/web-login/student/phone");
        response.prettyPrint();
    }

    private void studentLoginType() {
        body = new JSONObject();
        body.put("phone", "5000000000");
        body.put("loginType", "student");
        System.out.println("Body : " + body);

        response = given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(body.toString())
                .post("https://testpanelbe.edulog.com.tr/auth/web-login/student/login-type");
        response.prettyPrint();
    }

    private void employeePhone() {

        body = new JSONObject();
        body.put("phone", "5000000000");
        System.out.println("Body : " + body);

        response = given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(body.toString())
                .post("https://testpanelbe.edulog.com.tr/auth/web-login/employee/phone");
        response.prettyPrint();
    }

    public static String generateToken(String user) {
        Authentication authentication = new Authentication();

        switch (user) {
            case "employee":
                authentication.employeePhone();
                authentication.url = "https://testpanelbe.edulog.com.tr/auth/web-login/employee/otp";
                authentication.body = new JSONObject();
                authentication.body.put("phone", "5000000000");
                authentication.body.put("otpCode", "999999");
                break;
            case "student":
                authentication.studentPhone();
                authentication.studentLoginType();
                authentication.url ="https://testpanelbe.edulog.com.tr/auth/web-login/student/otp";
                authentication.body = new JSONObject();
                authentication.body.put("phone", "5000000000");
                authentication.body.put("otpCode", "999999");
                authentication.body.put("loginType", "student");
                break;
        }

        authentication.response = given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(authentication.body.toString())
                .post(authentication.url);
        authentication.response.prettyPrint();

        JsonPath jsonPath = authentication.response.jsonPath();
        String token = jsonPath.getString("data.access_token");

        System.out.println("Token : " + token);
        return token;
    }

}
