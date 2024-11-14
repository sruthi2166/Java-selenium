package pac1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Allbooks {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response res=RestAssured.get("http://192.168.5.80:3000/api/v1/book/getAllBook");
		System.out.println("Status code:"+res.statusCode());
		System.out.println("Responsebody:"+res.getBody().asString());
		System.out.println("header:"+res.statusCode());
		System.out.println("Status line:"+res.getStatusLine());

	}

}
