package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @BeforeClass
    public void setUp() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
    }

    @Test
    public void testAddListOfBooks() {

        List<String> isbns = new ArrayList<>();
        isbns.add("1234567890");
        isbns.add("0987654321");

        String userId = "user123";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"userId\": \"" + userId + "\", \"collectionOfIsbns\": " + isbns + " }")
                .post("/Books");


        Assert.assertEquals(response.getStatusCode(), 200, "Başarılı");
        String addedIsbn = response.jsonPath().getString("isbn");
        Assert.assertNotNull(addedIsbn, "ISBN alanı null olmamalıdır.");
    }
}