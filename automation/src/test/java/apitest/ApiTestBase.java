package apitest;

import com.google.gson.Gson;
import objects.ApiObject;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Shuvashish on 3/12/2018.
 */
public class ApiTestBase {

    public static final String apiUrl = "http://localhost/dotdash/fake-API-call.php";

    public ApiObject[] getApiObject(){
        HttpURLConnection huc = null;
        StringBuffer response = new StringBuffer();
        int responseCode;
        Gson gson = new Gson();
        String inputLine;

        try{
            huc = (HttpURLConnection)(new URL(apiUrl).openConnection());
            huc.setRequestMethod("GET");
            huc.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));

            while((inputLine = in.readLine()) !=null){
                response.append(inputLine);
            }
            in.close();
            responseCode = huc.getResponseCode();
            Assert.assertEquals(responseCode, 200, "Status code is " + responseCode);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response.toString(), ApiObject[].class);
    }

    public void printApiObject(ApiObject apiObject){
        System.out.println("\"id\":"+apiObject.getId());
        System.out.println("\"status\":"+apiObject.getStatus());
        System.out.println("\"task name\":"+apiObject.getTaskName());
        System.out.println("\"category\":"+apiObject.getCategory());
        System.out.println("\"due date\":"+apiObject.getDueDate());
    }
}
