import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utilities.API;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class APITests {

    private static Logger logger = LogManager.getLogger();

    @BeforeClass
    private void setUp() {

        System.out.println("Make sure that ZebraTester is up and running");

    }

    @AfterClass
    private void tearDown() {

    }

    @Test
    public void GetRecorderVersion_Test()  {


        RequestSpecification request = RestAssured.given();
        logger.info(API.getRecorderVersion());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.getRecorderVersion());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get("RecorderVersion").toString(), API.getinstalledZTVersion_data());
    }


    @Test
    public void getRecorderSSLVersion_Test() {

        RequestSpecification request = RestAssured.given();
        logger.info(API.getRecorderSSLVersion());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.getRecorderSSLVersion());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get("SSLVersion").toString(),API.getinstalledSSLVersion_data());

    }

    @Test
    public void setRecorderSSLVersion_Test() {

        RequestSpecification request;

        request = RestAssured.given();
        logger.info(API.setRecorderSSLVersiontls12());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.setRecorderSSLVersiontls12());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

        logger.info(API.getRecorderSSLVersion());
        request = RestAssured.given();
        request.contentType(ContentType.JSON);
        response = request.get(API.getRecorderSSLVersion());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get("SSLVersion").toString(),"tls12");

        logger.info(API.setRecorderSSLVersionAll());
        request = RestAssured.given();
        request.contentType(ContentType.JSON);
        response = request.post(API.setRecorderSSLVersionAll());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

        logger.info(API.getRecorderSSLVersion());
        request = RestAssured.given();
        request.contentType(ContentType.JSON);
        response = request.get(API.getRecorderSSLVersion());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get("SSLVersion").toString(),"all");


    }

    @Test
    public void getRecorderDNSConfig_Test() {


        RequestSpecification request = RestAssured.given();
        logger.info(API.getRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.getRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }

    @Test
    public void getRecorderDNSTranslationTable_Test() {

        RequestSpecification request;

        request = RestAssured.given();
        logger.info(API.setRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        request.body(API.DNSconfig_data());
        Response response = request.get(API.setRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        request = RestAssured.given();
        logger.info(API.getRecorderDNSTranslationTable());
        request.contentType(ContentType.JSON);
        response = request.get(API.getRecorderDNSTranslationTable());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }


    @Test
    public void recorderPluginsGetList_Test() {

        RequestSpecification request = RestAssured.given();
        logger.info(API.recorderPluginsGetList());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.recorderPluginsGetList());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get("RecorderPlugins").toString(), "[]");

    }


    @Test
    public void clearRecorderDNSResolveCache_Test() {

        RequestSpecification request;

        request = RestAssured.given();
        logger.info(API.setRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        request.body(API.DNSconfig_data());
        Response response = request.get(API.setRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        request = RestAssured.given();
        logger.info(API.clearRecorderDNSResolveCache());
        request.contentType(ContentType.JSON);
        response = request.get(API.clearRecorderDNSResolveCache());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        request = RestAssured.given();
        logger.info(API.setRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        request.body("{}");
        response = request.get(API.setRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");



    }

    @Test
    public void setRecorderDNSConfig_Test() {

        RequestSpecification request;

        request = RestAssured.given();
        logger.info(API.setRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        request.body(API.DNSconfig_data());
        Response response = request.get(API.setRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");


        logger.info(API.getRecorderDNSConfig());
        request = RestAssured.given();
        request.contentType(ContentType.JSON);
        response = request.get(API.getRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertTrue(response.jsonPath().get().toString().contains("DNSServers"));
        Assert.assertEquals(response.jsonPath().get("DNSServers").toString(),"[1.2.3.4, 10.2.28.5]");


        request = RestAssured.given();
        logger.info(API.setRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        request.body("{}");
        response = request.get(API.setRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

        logger.info(API.getRecorderDNSConfig());
        request.contentType(ContentType.JSON);
        response = request.get(API.getRecorderDNSConfig());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertEquals(response.jsonPath().get().toString(), "{}");

    }


}
