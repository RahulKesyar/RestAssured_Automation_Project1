package test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

//import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {
	
	@Test
	public void testPut() {
			
		JSONObject request = new JSONObject();
		
		request.put("name","Raghav");
		request.put("job","Teacher");
		
		System.out.println(request.toJSONString());		
		
		
			given().
				header("content-type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				put("https://reqres.in/api/users/2").
			then().
				statusCode(200).
				log().all();
			
		
	}
	
	@Test
	public void testPatch() {
			
		JSONObject request = new JSONObject();
		
		request.put("name","Raghav");
		request.put("job","Teacher");
		
		System.out.println(request.toJSONString());		
		
		
			given().
				header("content-type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				patch("https://reqres.in/api/users/2").
			then().
				statusCode(200).
				log().all();
			
		
	}

	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
				statusCode(204).
				log().all();
			
		
	}

}
