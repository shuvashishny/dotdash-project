package apitest;

import browser.Browser;
import objects.ApiObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by Shuvashish on 3/10/2018.
 */
public class FakeApiCallApiTest extends ApiTestBase {

    @Test
    //This test is to test the service status
    //I used HttpURLConnection class to get the response
    //IN the end just validated the response is 200
    public void testStatus(){
        HttpURLConnection huc = null;

        try{
            huc = (HttpURLConnection)(new URL(Browser.url).openConnection());
            huc.setRequestMethod("GET");
            huc.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) !=null){
                response.append(inputLine);
            }
            in.close();

            int responseCode = huc.getResponseCode();

            Assert.assertEquals(responseCode, 200, "Status code is "+responseCode);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    // This test will print number of tasks with out category
    // I used Selenium to navigate to the api page and get the response
    // I used gson framework to convert json object to java object
    // In the end just printed the number
    public void findNonAssignedCategory(){
        int count =0;
        ApiObject[] apiObjects =getApiObject();
        for(ApiObject apiObject : apiObjects){
            if(apiObject.getCategory().equals(""))
                count++;
        }
        System.out.println("Count is "+count);
    }

    //This test is to aggregate all the task name and print them
    // I could print the task names from taskNames list
    //But did not create another loop
    //taskNames should have all the task names
    @Test
    public void printTaskName(){
        ApiObject[] apiObjects =getApiObject();
        List<String> taskNames = new ArrayList<String>();

        for(ApiObject apiObject : apiObjects){
            taskNames.add(apiObject.getTaskName());
            System.out.println("Task name is "+apiObject.getTaskName());
        }
    }

    @Test
    public void printDescendingOrderTask(){
        ApiObject[] apiObjects =getApiObject();
        List<String> dueDates = new ArrayList<String>();

        //Here trying to add all the due dates in a list
        for(ApiObject apiObject : apiObjects){
            dueDates.add(apiObject.getDueDate());
        }
        //Rearrange the dueDates list in descending order
        Collections.sort(dueDates, Collections.reverseOrder());

        //Now print all the task in descending due date
        //It will not print tasks which do not have due date
        for(String str : dueDates){
            for (ApiObject apiObject : apiObjects){
                if(apiObject.getDueDate().equals(str) && !str.equals("\r\n")){
                    printApiObject(apiObject);
                }
            }
        }
        //Following loop will print all the tasks with out due dates
        for (ApiObject apiObject : apiObjects){
            if(apiObject.getDueDate().equals("\r\n")){
                printApiObject(apiObject);
            }
        }
    }
    @Test
    //Get the task number from UI
    //Then get task number from Api
    //Then compare the results
    public void validateNumberOfTasks(){
        int taskNumber = Browser.openBrowser()
                                   .getTodoListSize();
        ApiObject[] apiObjects =getApiObject();
        Assert.assertEquals(apiObjects.length, taskNumber, apiObjects.length+
                " did not match with "+ taskNumber);
    }
}
