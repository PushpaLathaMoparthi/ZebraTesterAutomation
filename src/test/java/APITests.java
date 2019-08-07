import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.HTTPMethods;

import java.io.IOException;
import utilities.API;
import org.json.JSONObject;


public class APITests {

    @BeforeClass
    private void setUp() {
        System.out.println("Make sure that ZebraTester is up and running");
    }

    @AfterClass
    private void tearDown() {

    }

    @Test
    public void testGetRecorderVersion() {

        try {

            String response = HTTPMethods.GETRequestResponse(API.getRecorderVersion());
            System.out.println("Response Code: " + response.toString());

            JSONObject apiJsonObj = new JSONObject(response);

            String versionValue = HTTPMethods.getValuefromJSON(apiJsonObj, "RecorderVersion");
            System.out.println("Recorded Version is :" + versionValue);

        } catch (IOException e) {

            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace().toString());
        }
    }

        @Test
        public void verifyGetRecorderVersion()  {

            try{

                String response = HTTPMethods.GETRequestResponse(API.getRecorderVersion());
                System.out.println("Response Code: " + response.toString());

                JSONObject apiJsonObj = new JSONObject(response);

                String versionValue = HTTPMethods.getValuefromJSON(apiJsonObj, "RecorderVersion");
                System.out.println("Recorded Version is :" + versionValue);
                Assert.assertEquals(versionValue, API.getinstalledVersion());

            }
            catch(IOException e){

                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace().toString());
            }

    }



}
