
import org.testng.annotations.Test;
import utilities.API;
import org.testng.Assert;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.response.Response;




public class filterTrafficTypeTests {


    /**
     * Test to get the response from the api http://127.0.0.1:7996/?cmd=getRecorderBlacklist
     * @Description Get a list of DNS names and IP addresses for which recording is suppressed by the proxy recorder.
     */

    @Test
    public void getRecorderBlackListTest() {

        System.out.println("JSON Response " + API.getRecorderBlacklist());
        RestAssured.given().when().get(API.getRecorderBlacklist());
        Response response = RestAssured.when().get(API.getRecorderBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderBlacklist");
        System.out.println(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderBlacklist");
        System.out.println(RecorderBlack);

    }



}
