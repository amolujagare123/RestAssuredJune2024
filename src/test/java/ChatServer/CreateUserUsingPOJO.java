package ChatServer;

import POJO.ChatServer.CreateUserPojo;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUserUsingPOJO {

    @Test
    public void createUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        CreateUserPojo payLoad = new CreateUserPojo();

        payLoad.setUsername("rahul123");
        payLoad.setPassword("SecurePass@2024");
        payLoad.setName("Rahul");
        payLoad.setSurname("Sharma");
        payLoad.setEmail("rahul.sharma@example.in");
        payLoad.setChat_nickname("rahulChat");

        ArrayList<Integer> dept = new ArrayList<>();
        dept.add(1);
        dept.add(2);

        payLoad.setDepartments(dept);

        ArrayList<Integer> dept_read = new ArrayList<>();
        dept_read.add(2);

        payLoad.setDepartments_read(dept_read);

        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1);

        payLoad.setDepartment_groups(groups);
        payLoad.setUser_groups(groups);


        given().log().all().auth()
                .preemptive().basic("admin","admin123")
                .contentType("application/json")
                .body(payLoad)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
