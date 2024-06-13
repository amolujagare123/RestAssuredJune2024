package ComplexJson;

import io.restassured.path.json.JsonPath;

public class ComplexJsonDemo {

    public static void main(String[] args) {

        String responseStr = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "     {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "      \n" +
                "  ]\n" +
                "}\n";


        JsonPath jsonPath = new JsonPath(responseStr);


    //    1. Print No of courses returned by API/response
        int totalCourses = jsonPath.getInt("courses.size()");
        System.out.println("totalCourses="+totalCourses);

     //   2.Print Purchase Amount
       int purchaseAmount = jsonPath.get("dashboard.purchaseAmount"); // 1162
        System.out.println("purchaseAmount="+purchaseAmount);

     //   3. Print Title of the first course
        String title = jsonPath.getString("courses[0].title");
        System.out.println("title="+title);

    //    4. Print All course titles and their respective Prices
        System.out.println("==============================");
        System.out.println("=====Courses & Their Prices===");
        System.out.println("==============================");
        for (int i=0;i<totalCourses;i++)
        {
            System.out.print("Title="+jsonPath.getString("courses["+i+"].title"));
            System.out.println("\tPrice="+jsonPath.get("courses["+i+"].price"));
        }

       //  5. Print no of copies sold by RPA Course

        String myCourse = "Cypress";

        for (int i=0;i<totalCourses;i++)
        {
            String course = jsonPath.getString("courses["+i+"].title");
            if (course.equalsIgnoreCase(myCourse))
            {
                  int copies = jsonPath.getInt("courses["+ i +"].copies");
                  System.out.println("Copies by "+course+"="+copies);
            }
        }

        // 6. Verify if Sum of all Course prices matches with Purchase Amount

          int sum = 0;

         for (int i=0;i<totalCourses;i++)
         {
             int price = jsonPath.getInt("courses["+i+"].price");
             int copies = jsonPath.getInt("courses["+ i +"].copies");

             sum = sum + (price * copies);
         }

          System.out.println("sum="+sum);

         if(sum==1162)
             System.out.println("Prices matched");
         else
             System.out.println("Prices not matched");

    }
}
