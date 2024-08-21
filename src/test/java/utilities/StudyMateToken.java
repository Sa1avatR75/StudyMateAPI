package utilities;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudyMateToken {
    public static String getToken(){
        String endPoint = Config.getProperty("studyMateAPIURL") + "/api/myaccount/auth/login";

        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("sa.amingaliev@gmaiil.com");
        requestBody.setPassword("220300Sa");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(endPoint);
        return response.jsonPath().getString("jwt_token");
    }
}
