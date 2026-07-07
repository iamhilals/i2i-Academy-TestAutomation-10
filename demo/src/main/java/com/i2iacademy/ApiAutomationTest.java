package com.i2iacademy;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ApiAutomationTest {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        System.out.println("--- GET İSTEĞİ TESTİ BAŞLIYOR ---");
        try {
           
            Response getResponse = given()
                .when()
                .get("/users/2");
            
            
            getResponse.then()
                .statusCode(200) 
                .time(lessThan(5000L)) 
                .body("name", equalTo("Ervin Howell")); 

            System.out.println("GET İsteği Başarılı!");
            System.out.println("Dönen Durum Kodu: " + getResponse.getStatusCode());
            System.out.println("Yanıt Süresi: " + getResponse.getTime() + " ms");
            
        } catch (Exception e) {
            System.out.println("GET Testi Başarısız: " + e.getMessage());
        }

        System.out.println("\n--- POST İSTEĞİ TESTİ BAŞLIYOR ---");
        try {
            
            String requestBody = "{ \"name\": \"i2i Academy\", \"job\": \"Test Automation Engineer\" }";
            
            Response postResponse = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users");

            
            postResponse.then()
                .statusCode(201) 
                .body("name", equalTo("i2i Academy")); 
            System.out.println("POST İsteği Başarılı!");
            System.out.println("Dönen Durum Kodu: " + postResponse.getStatusCode());
            System.out.println("Oluşturulan Kullanıcı Adı: " + postResponse.jsonPath().getString("name"));

        } catch (Exception e) {
            System.out.println("POST Testi Başarısız: " + e.getMessage());
        }
    }
}