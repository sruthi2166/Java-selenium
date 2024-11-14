package pac1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;


import io.restassured.http.ContentType;

public class PATCH_Book2 {
	
	
@Test
	public  void postbooks ()
		// TODO Auto-generated method stub
	{
		JSONObject req=new JSONObject();
		baseURI = "http://192.168.5.80:3000/api";
		
		req.put("price", 12200);
		
		given()
		.header("content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.patch("/v1/book/updateBook/1")
		.then().statusCode(200).log().all();

	}

}
