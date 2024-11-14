package pac1;
 
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
 
import java.io.FileInputStream;
import java.io.IOException;
 
import static io.restassured.RestAssured.*;
 
public class Data_excel {
 
    @Test
    public void executeBookRequest() throws IOException {
        // Load the Excel file
        FileInputStream file = new FileInputStream("C:\\Users\\sruthi.katapally\\eclipse-workspace\\Nov2024_RestAssured\\sample_book_data.xlsx"); // Update with your Excel file path
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
 
        DataFormatter formatter = new DataFormatter();
 
        // Read data from Excel file
        String baseURIExcel = formatter.formatCellValue(sheet.getRow(1).getCell(0)); // baseURI
        String method = formatter.formatCellValue(sheet.getRow(1).getCell(1));       // Method
        String name = formatter.formatCellValue(sheet.getRow(1).getCell(2));         // Book name
        String authorName = formatter.formatCellValue(sheet.getRow(1).getCell(3));   // Author name
        String publishedYear = formatter.formatCellValue(sheet.getRow(1).getCell(4));// Published year
        double price = sheet.getRow(1).getCell(5).getNumericCellValue();             // Price
        
        workbook.close();
 
        // Set base URI
        baseURI = baseURIExcel;
 
        // Create JSON object with book data
        JSONObject req = new JSONObject();
        req.put("name", name);
        req.put("authorName", authorName);
        req.put("publishedYear", publishedYear);
        req.put("price", price);
 
        // Execute request based on the method specified in Excel
        switch (method.toUpperCase()) {
            case "POST":
                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                    .post("/v1/book/addBook")
                .then()
                    .statusCode(200)
                    .log().all();
                break;
                
            case "GET":
                given()
                    .header("Content-Type", "application/json")
                .when()
                    .get("/v1/book/getBook")
                .then()
                    .statusCode(200)
                    .log().all();
                break;
                
            case "PATCH":
                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                    .patch("/v1/book/updateBook")
                .then()
                    .statusCode(200)
                    .log().all();
                break;
                
            case "DELETE":
                given()
                    .header("Content-Type", "application/json")
                .when()
                    .delete("/v1/book/deleteBook")
                .then()
                    .statusCode(200)
                    .log().all();
                break;
            case "PUT":
                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(req.toJSONString())
                .when()
                    .patch("/v1/book/updateBook")
                .then()
                    .statusCode(200)
                    .log().all();
                break;
                
            default:
                System.out.println("Invalid method specified in Excel");
                break;
        }
    }
}
 