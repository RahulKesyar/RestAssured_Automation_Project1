package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "RAJU");
		request.put("lastName", "SHAME");
		request.put("subjecteId", 1);
		
		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
			
	}
	
	@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "RAJU 6");
		request.put("lastName", "new name");
		request.put("subjecteId", 2);
		
		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void patch() {
		
		JSONObject request = new JSONObject();
		
	
		request.put("lastName", "new patch name");
		
		
		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void Delete() {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/4").
		then().
				statusCode(200).
				log().all();
	}

}
