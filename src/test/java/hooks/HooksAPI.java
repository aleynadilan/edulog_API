package hooks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.Authentication;
import utilities.ConfigReader;

public class HooksAPI {
    public static RequestSpecification spec;

    public static void setUpApi(String userType) {
        String token;
        if (userType.equals("employee")) {
            token = Authentication.generateToken(userType);
        } else if (userType.equals("student")) {
            token = Authentication.generateToken(userType);
        } else {
            token = ConfigReader.getProperty("invalidToken");
        }

        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url"))
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
