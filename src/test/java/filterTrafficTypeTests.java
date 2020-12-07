
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.API;
import org.testng.Assert;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;


public class filterTrafficTypeTests {


    private static Logger logger = LogManager.getLogger();

    /**
     * Test to get the response from the api http://127.0.0.1:7996/?cmd=getRecorderBlacklist
     * @Description Get a list of DNS names and IP addresses for which recording is suppressed by the proxy recorder.
     */

    @Test
    public void getRecorderBlackList_Test() {

        logger.info(API.getRecorderBlacklist());
        Response response = RestAssured.when().get(API.getRecorderBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderBlacklist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderBlacklist");
        logger.info(RecorderBlack);

    }


    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderBlacklist&format=<JSON|TEXT>
     * @Description Set a list of DNS names and IP addresses for which recording is suppressed by the proxy recorder.
     *
     */
    @Test
    public void setRecorderBlacklistTest() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        logger.info( API.setRecorderBlacklist());
        request.body(API.recorderBlacklistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderBlacklist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        logger.info( API.getRecorderBlacklist());
        RestAssured.given().when().get(API.getRecorderBlacklist());
        response = RestAssured.when().get(API.getRecorderBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().get().toString().contains("RecorderBlacklist"));

        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderBlacklist");
        Assert.assertEquals(RecorderBlacklist.size(), 1);
        String RecorderBlack = response.jsonPath().getString("RecorderBlacklist");
        logger.info(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        logger.info( API.setRecorderBlacklist());
        request.body(API.defaultRecorderBlacklistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklistD = response.jsonPath().getList("RecorderBlacklist");
        Assert.assertEquals(RecorderBlacklistD.size(), 0);
        String RecorderBlackD = response.jsonPath().getString("RecorderBlacklist");
        logger.info(RecorderBlackD);


    }

    /**
     * Get the response from the api http://127.0.0.1:7996/?cmd=getRecorderWhitelist
     * @Description: Get a list of DNS names and IP addresses that are exceptions of the recorder blacklist.
     */
    @Test
    public void getRecorderWhitelistTest() {

        Response response = RestAssured.when().get(API.getRecorderWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderWhitelist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderWhitelist");
        System.out.println(RecorderBlack);

    }

    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderWhitelist&format=<JSON|TEXT>
     * @Description Set a list of DNS names and IP addresses that are exceptions of the recorder blacklist.
     */
    @Test
    public void setRecorderWhitelistTest() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.recorderWhitelistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderWhitelist = response.jsonPath().getList("RecorderWhitelist");
        logger.info(RecorderWhitelist.size());
        Assert.assertEquals(RecorderWhitelist.size(), 2);
        String RecorderBlack = response.jsonPath().getString("RecorderWhitelist");
        System.out.println(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        request.body(API.defaultRecorderWhitelistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }

    /*
     * Get the response from the api http://127.0.0.1:7996/?cmd=getRecorderURLBlacklist
     * @Description: Get a list of URLs for which recording is suppressed by the proxy recorder.
     */
    @Test
    public void getRecorderURLBlacklist_Test() {

        Response response = RestAssured.when().get(API.getRecorderURLBlacklist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLBlacklist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderURLBlacklist");
        System.out.println(RecorderBlack);

    }

    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderURLBlacklist&format=<JSON|TEXT>
     * @Description Set a list of URLs for which recording is suppressed by the proxy recorder.
     */
    @Test
    public void setRecorderURLBlacklist_Test() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.recorderURLBlacklistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderURLBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderURLBlacklist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLBlacklist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 3);
        String RecorderBlack = response.jsonPath().getString("RecorderURLBlacklist");
        System.out.println(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        request.body(API.defaultRecorderURLBlacklistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderURLBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }

    /*
     * Get the response from the api http://127.0.0.1:7996/?cmd=getRecorderURLWhitelist
     * @Description: Get a list of URLs that are exceptions of the recorder URL blacklist.
     */
    @Test
    public void getRecorderURLWhitelist_Test() {

        Response response = RestAssured.when().get(API.getRecorderURLWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLWhitelist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderURLWhitelist");
        System.out.println(RecorderBlack);

    }

    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderURLWhitelist&format=<JSON|TEXT>
     * @Description Set a list of URLs that are exceptions of the recorder URL blacklist.
     * @Param
     */
    @Test
    public void setRecorderURLWhitelist_Test() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.recorderURLWhitelistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderURLWhitelist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderURLWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLWhitelist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 2);
        String RecorderBlack = response.jsonPath().getString("RecorderURLWhitelist");
        System.out.println(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        request.body(API.defaultRecorderURLWhitelistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderURLWhitelist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }

    /*
     * Get the response from the api http://127.0.0.1:7996/?cmd=getRecorderURLRegexBlacklist
     * @Description: Get a list of regex matching to URLs for which recording is suppressed by the proxy recorder.
     */
    @Test
    public void getRecorderURLRegexBlacklist_Test() {

        Response response = RestAssured.when().get(API.getRecorderURLRegexBlacklist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLRegexBlacklist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderURLRegexBlacklist");
        System.out.println(RecorderBlack);

    }


    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderURLRegexBlacklist&format=<JSON|TEXT>
     * @Description Set a list of regex matching to URLs for which recording is suppressed by the proxy recorder.
     * @Param
     */
    @Test
    public void setRecorderURLRegexBlacklist_Test() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.recorderURLRegexBlacklistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderURLRegexBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderURLRegexBlacklist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLRegexBlacklist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 1);
        String RecorderBlack = response.jsonPath().getString("RecorderURLRegexBlacklist");
        System.out.println(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        request.body(API.defaultRecorderURLRegexBlacklistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderURLRegexBlacklist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }

    /*
     * Get the response from the api http://127.0.0.1:7996/?cmd=getRecorderURLRegexWhitelist
     * @Description: Get a list of regex matching to URLs that are exceptions of the recorder URL regex blacklist.
     */
    @Test
    public void getRecorderURLRegexWhitelist_Test() {

        Response response = RestAssured.when().get(API.getRecorderURLRegexWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLRegexWhitelist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 0);
        String RecorderBlack = response.jsonPath().getString("RecorderURLRegexWhitelist");
        System.out.println(RecorderBlack);

    }

    /**
     * Get the response from the api POST http://127.0.0.1:7996/?cmd=setRecorderURLRegexWhitelist&format=<JSON|TEXT>
     * @Description Set a list of regex matching to URLs that are exceptions of the recorder URL regex blacklist.
     * @Param
     */
    @Test
    public void setRecorderURLRegexWhitelist_Test() {

        RestAssured.baseURI = API.getHostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.recorderURLRegexWhitelistdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderURLRegexWhitelist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        response = RestAssured.when().get(API.getRecorderURLRegexWhitelist());
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.getStatusCode(), 200);
        List <String> RecorderBlacklist = response.jsonPath().getList("RecorderURLRegexWhitelist");
        logger.info(RecorderBlacklist.size());
        Assert.assertEquals(RecorderBlacklist.size(), 1);
        String RecorderBlack = response.jsonPath().getString("RecorderURLRegexWhitelist");
        System.out.println(RecorderBlack);

        RestAssured.baseURI = API.getHostIP();
        request = RestAssured.given();
        request.body(API.defaultRecorderURLRegexWhitelistdata());
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderURLRegexWhitelist());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");
    }




}
