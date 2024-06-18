package JobPortal;

import POJO.JobPortal.CreateJobPOJO;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateJob {

    @Test
    public void createJob()
    {
        CreateJobPOJO payload = new CreateJobPOJO();
        payload.setJobTitle("Software Testing with automation");
        payload.setJobId(100);
        payload.setJobDescription("manual testing,selenium,api testing");

        ArrayList<String> experiences = new ArrayList<>();
        experiences.add("3 years in manual testing");
        experiences.add("1 year in api testing");
        experiences.add("1 year in selenium testing");
        payload.setExperience(experiences);

        Project project1 = new Project();
        project1.setProjectName("stock management");

        ArrayList<String> technologies1 = new ArrayList<>();
        technologies1.add("java");
        technologies1.add("sql");
        project1.setTechnology(technologies1);


        Project project2 = new Project();
        project2.setProjectName("HR management");

        ArrayList<String> technologies2 = new ArrayList<>();
        technologies2.add(".Net");
        technologies2.add("MSsql");
        project2.setTechnology(technologies2);

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);

        payload.setProject(projects);



        RestAssured.baseURI = "http://localhost:9897/";
        given().log().all()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
