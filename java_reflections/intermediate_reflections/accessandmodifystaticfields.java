package java_reflections.intermediate_reflections;

import java.lang.reflect.Field;
import java.util.Scanner;

class Configuration{
    private static String API_KEY;

    public static String getApiKey() {
        return API_KEY;
    }
}
public class accessandmodifystaticfields {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Class<?>cl = Configuration.class;
        Field apifield = cl.getDeclaredField("API_KEY");//Initial value of api key is null and it is getting modified by the api input we will give ->
        System.out.println("Enter the updated API_KEY = ");
        String NEW_API_KEY = sc.next();
        apifield.setAccessible(true);
        apifield.set(null,NEW_API_KEY); //Modifying the api key
        System.out.println("Modified API_KEY: " + Configuration.getApiKey());

    }
}
