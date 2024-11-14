package pac1;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
 
public class GET_AllBooks_BDD {
		
	@Test
		public void getbooks()
		{
		 baseURI = "http://192.168.5.80:3000/api";
		
		 given().
		 get("/v1/book/getAllBook").
		 then().statusCode(200).log().all();
		
		
	}
 
}