package payload.goRest;

public class GoRestPayLoad {


   /* public String getUserDetails()
    {
        String body = " {\n" +
                "        \"name\": \"Mayur\",\n" +
                "        \"email\": \"mayur2@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }" ;

        return body;
    }*/

    public static String getUserDetails()
    {
       return  " {\n" +
                "        \"name\": \"Mayur\",\n" +
                "        \"email\": \"mayur2@gmail.com\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"status\": \"active\"\n" +
                "    }" ;

    }
    public static String getUserDetails(String name,String email,String gender,String status)
    {
        return  " {\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"email\": \""+email+"\",\n" +
                "        \"gender\": \""+gender+"\",\n" +
                "        \"status\": \""+status+"\"\n" +
                "    }" ;

    }
}
