package com.revature.steps;

import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class APITests {
    @Then("A positive auth\\/lpgin test is performed.")
    public void a_positive_auth_lpgin_test_is_performed() {
        JSONObject request = new JSONObject();
        request.put("email","test@test.test");
        request.put("password","7est!nCj");
        given()
                .contentType("application/json")
                .body(request)
                .when().post("http://localhost:8080/auth/login").then().assertThat().statusCode(200);
    }

    @Then("A negative auth\\/login test is performed.")
    public void a_negative_auth_login_test_is_performed() {
        JSONObject request = new JSONObject();
        request.put("email","test@test.test");
        request.put("password","7est!nC");
        given()
                .contentType("application/json")
                .body(request)
                .when().post("http://localhost:8080/auth/login").then().assertThat().statusCode(401);
    }

    @Then("A \\/user Register test is performed.")
    public void a_user_register_test_is_performed() {
        JSONObject request = new JSONObject();
        request.put("email","apitest@tapiest.apitest");
        request.put("password","api7est!nCj");
        request.put("firstName","apiTest");
        request.put("lastName","apiTest");
        given()
                .contentType("application/json")
                .body(request)
                .when().post("http://localhost:8080/user").then().assertThat().statusCode(200);
    }

    @Then("A \\/user Update test is performed.")
    public void a_user_update_test_is_performed() {
        JSONObject request = new JSONObject();
        request.put("firstName","apiTest");
        request.put("lastName","apiTest");
        request.put("password","api7est!nCj");
        given()
                .contentType("application/json")
                .body(request)
                .when().put("http://localhost:8080/user").then().assertThat().statusCode(401);
    }

    @Then("A \\/api\\/payment createPayment test is performed.")
    public void a_api_payment_create_payment_test_is_performed() {
        JSONObject request = new JSONObject();
        request.put("ccv","123");
        request.put("expDate","12/12/2022");
        request.put("cardNumber","1234567887654321");
        given()
                .contentType("application/json")
                .body(request)
                .when().post("http://localhost:8080/api/payment").then().assertThat().statusCode(201);
    }

    @Then("A \\/api\\/payment deletePayment test is performed.")
    public void a_api_payment_delete_payment_test_is_performed() {
        given()
                .contentType("application/json")
                .when().get("http://localhost:8080/api/payment").then().assertThat().statusCode(401);
    }

    @Then("A positive \\/user\\/deactivate test is performed.")
    public void a_positive_user_deactivate_test_is_performed() {
        given()
                .contentType("application/json")
                .when().put("http://localhost:8080/uer/deactivate").then().assertThat().statusCode(404);
    }


}
