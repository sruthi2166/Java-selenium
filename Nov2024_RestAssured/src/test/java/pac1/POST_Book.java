package pac1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;


import io.restassured.http.ContentType;

public class POST_Book {
	
	
@Test
	public  void postbooks ()
		// TODO Auto-generated method stub
	{
		JSONObject req=new JSONObject();
		baseURI = "http://192.168.5.80:3000/api";
		
		req.put("name", "How Make Money1");
		req.put("authorName", "Ram1");
		req.put("publishedYear", "01/11/1994");
		req.put("price", 1050);
		
		given()
		.header("content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.post("/v1/book/addBook")
		.then().statusCode(200).log().all();

	}

}
