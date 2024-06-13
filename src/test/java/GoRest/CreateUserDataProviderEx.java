package GoRest;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.goRest.GoRestPayLoad.getUserDetails;

public class CreateUserDataProviderEx {

   @Test(dataProvider = "getData")
    public void createUserRequest(String name,String email,String gender,String status) {
        RestAssured.baseURI = "https://gorest.co.in/";

      /*  String name = "Sushma";
        String email = "sushma1235@gmail.com";
        String gender = "female";
        String status = "active";*/


        given().log().all()
                .header("Authorization","Bearer 7289f872cacc8e3635af500e2a48ef5edf2842bffce79710cec3393a95f91383")
                .contentType("application/json")
                .body(getUserDetails(name,email,gender,status))
                .when().post("/public/v2/users")
                .then().log().all().assertThat()//.statusCode(201)
                .body("email",equalTo(email));
    }

    @DataProvider
    Object[][] getData() throws IOException {
        // read the file
        FileInputStream fis = new FileInputStream("Data/data.xlsx");

        // store it into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // get the sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

       int rowCount = sheet.getPhysicalNumberOfRows();
       int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
            data[i][3] = row.getCell(3).toString();
        }


       /* data[0][0] = "Abhiram";
        data[0][1] = "abhi@gmail.com";
        data[0][2] = "male";
        data[0][3] = "active";

        data[1][0] = "Samantha";
        data[1][1] = "sam@gmail.com";
        data[1][2] = "female";
        data[1][3] = "inactive";

        data[2][0] = "Rajesh";
        data[2][1] = "rajesh@gmail.com";
        data[2][2] = "male";
        data[2][3] = "active";*/

        return data;
    }

}
