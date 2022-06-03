package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAndPost {
	
	//@Test
	public void testGet() {
		
		// baseURI = "https://reqres.in/api";
		
		given().
			get("https://vtsapi.infotracktelematics.com/v1.0/api/alertconfig").
		then().
			statusCode(200).
			body("[10].email_To",equalTo("nil@gmail.com")).
			body("data.first_name", hasItems("George","Byron"));
	}
	
	@Test
	
	public void testPost() {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("mobileNumber","9995599999");
//		map.put("alertTypeMasterId", 96);
//			
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name","Raghav");
		request.put("job","Teacher");
		
		System.out.println(request.toJSONString());		
		
		
			given().
				body(request.toJSONString()).
			when().
				post("https://reqres.in/api/users/2").
			then().
			statusCode(201).log().all();
			


	
		
	}

}
