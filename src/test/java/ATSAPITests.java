import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.API;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ATSAPITests {

    private static Logger logger = LogManager.getLogger();

    @BeforeClass
    private void setUp() {
        System.out.println("Make sure that ZebraTester and ATS are up and running");
    }

    @AfterClass
    private void tearDown() {

    }

    @Test
    public void retrive_row_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        RestAssured.baseURI = API.getATShostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.ats_rowdata());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        //  Assert.assertEquals(response.jsonPath().get().toString(), "{Country=India}");

    }

    @Test
    public void retrive_column_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        RestAssured.baseURI = API.getATShostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.ats_columndata());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        //  Assert.assertEquals(response.jsonPath().get().toString(), "{Country=India}");

    }

    @Test
    public void ats_send_row_test() {

        logger.info(API.getATShostIP() + API.ats_send_row());
        RestAssured.baseURI = API.getATShostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.ats_sendrowdata());
        logger.info(API.ats_sendrowdata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        //  Assert.assertEquals(response.jsonPath().get().toString(), "{Country=India}");

    }

    @Test
    public void ats_send_column_test() {

        logger.info(API.getATShostIP() + API.ats_send_column());
        RestAssured.baseURI = API.getATShostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.ats_sendcolumndata());
        logger.info(API.ats_sendcolumndata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        //  Assert.assertEquals(response.jsonPath().get().toString(), "{Country=India}");

    }

    @Test
    public void ats_update_column_test() {

        logger.info(API.getATShostIP() + API.ats_update_column());
        RestAssured.baseURI = API.getATShostIP();
        RequestSpecification request = RestAssured.given();
        request.body(API.ats_updatecolumndata());
        logger.info(API.ats_updatecolumndata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_update_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        //  Assert.assertEquals(response.jsonPath().get().toString(), "{Country=India}");

    }


}
