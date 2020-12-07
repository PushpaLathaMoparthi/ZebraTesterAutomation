
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
        RestAssured.baseURI = API.getATShostIP();
    }

    @AfterClass
    private void tearDown() {

    }

    /**
     * Test to get the response from the api http://127.0.0.1:7996/?cmd=getRecorderBlacklist
     * @Description Get a list of DNS names and IP addresses for which recording is suppressed by the proxy recorder.
     * @param
     * @outout
     * @Assertion
     *
     */

    @Test
    public void Retrieve_Row_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_rowdata());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

    }

    @Test
    public void Retrieve_Row_WrongTableName_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongtable());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_row());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);
        logger.info("JSON Response " + response.getStatusLine());

    }

    @Test
    public void Retrieve_Row_WrongJSON_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongJSON());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_row());
        logger.info(response.getStatusLine());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);


    }

    @Test
    public void Retrieve_Row_WrongColumn_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongColumn());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_row());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);

    }

    @Test
    public void Retrieve_Column_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_columndata());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertTrue(response.jsonPath().get().toString().contains("{Item Type="));

    }


    @Test
    public void Retrieve_Column_WrongColumn_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongColumn());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_column());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);

    }

    @Test
    public void Retrieve_Column_WrongTableName_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongtable());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_column());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);

    }

    @Test
    public void Retrieve_Column_WrongJSON_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongJSON());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_column());
        logger.info("JSON Response " + response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 422);


    }



    @Test
    public void ats_send_row_Test() {

        logger.info(API.getATShostIP() + API.ats_send_row());

        RequestSpecification request = RestAssured.given();
        request.body(API.data_sendRowData());
        logger.info(API.data_sendRowData());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertTrue(response.jsonPath().get().toString().contains("{}"));

    }

    @Test
    public void SendStackedRowData_Test() {

        logger.info(API.getATShostIP() + API.ats_send_row());

        RequestSpecification request = RestAssured.given();
        request.body(API.data_sendStackedRowData());
        logger.info(API.data_sendStackedRowData());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertTrue(response.jsonPath().get().toString().contains("{}"));

    }

    @Test
    public void SendUniqueRowData_Test() {

        logger.info(API.getATShostIP() + API.ats_send_row());

        RequestSpecification request = RestAssured.given();
        request.body(API.data_sendUniqueRowData());
        logger.info(API.data_sendUniqueRowData());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void ats_send_column_Test() {

        logger.info(API.getATShostIP() + API.ats_send_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_sendcolumndata());
        logger.info(API.data_sendcolumndata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_send_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

    }

    @Test
    public void ats_update_column_Test() {

        logger.info(API.getATShostIP() + API.ats_update_column());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_updatecolumndata());
        logger.info(API.data_updatecolumndata());
        request.contentType(ContentType.JSON);
        Response response = request.post(API.ats_update_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

    }

    @Test
    public void Retrieve_Table_Size_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_tableJSON());
        logger.info(API.data_tableJSON());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

    }

    @Test
    public void AddRows_Retrieve_Table_Size_Test() {

        RequestSpecification request = null;
        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int initial_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Initial Table Size : " + initial_tablesize);

        logger.info(API.getATShostIP() + API.ats_send_row());
        request = null;
        request = RestAssured.given().body(API.data_sendnewrowdata()).contentType(ContentType.JSON);
        response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response : " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = null;
        request = RestAssured.given().body(API.data_tableJSON()).contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int end_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Table Size After adding rows : " + end_tablesize);

        Assert.assertEquals((initial_tablesize+1), end_tablesize);

    }

    @Test
    public void AddUniqueRows_Retrieve_Table_Size_Test() {

        Long uniqueNumber = System.currentTimeMillis();

        RequestSpecification request = null;
        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int initial_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Initial Table Size : " + initial_tablesize);

        logger.info(API.getATShostIP() + API.ats_send_row());
        request = null;
        String data_sendUniqueRowData  = API.data_sendUniqueRowData().replace("{random.int}", uniqueNumber.toString());
        request = RestAssured.given().body(data_sendUniqueRowData).contentType(ContentType.JSON);
        response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response : " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = null;
        request = RestAssured.given().body(API.data_tableJSON()).contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int end_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Table Size After adding rows : " + end_tablesize);

        Assert.assertEquals(initial_tablesize+1, end_tablesize);

        logger.info(API.getATShostIP() + API.ats_send_row());
        request = null;
        request = RestAssured.given().body(data_sendUniqueRowData).contentType(ContentType.JSON);
        response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response : " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int final_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Final Table Size : " + final_tablesize);

        Assert.assertEquals(final_tablesize, end_tablesize);

    }

    @Test
    public void AddStackedRows_Retrieve_Table_Size_Test() {

        RequestSpecification request = null;
        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int initial_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Initial Table Size : " + initial_tablesize);

        logger.info(API.getATShostIP() + API.ats_send_row());
        request = null;
        request = RestAssured.given().body(API.data_sendStackedRowData()).contentType(ContentType.JSON);
        response = request.post(API.ats_send_row());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response : " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = null;
        request = RestAssured.given().body(API.data_tableJSON()).contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int end_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Table Size After adding rows : " + end_tablesize);

        Assert.assertEquals((initial_tablesize+1), end_tablesize);

    }

    @Test
    public void Retrieve_Table_Size_WrongTableName_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongtable());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 422);
        logger.info("JSON Response " + response.getStatusLine());

    }

    @Test
    public void Retrieve_Table_Size_WrongJSON_Test() {

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        RequestSpecification request = RestAssured.given();
        request.body(API.data_wrongJSON());
        request.contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 422);
        logger.info("JSON Response " + response.getStatusLine());

    }

    @Test
    public void AddColumn_Retrieve_Table_Size_Test() {

        Long uniqueNumber = System.currentTimeMillis();

        RequestSpecification request = null;
        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        logger.info(API.data_tableJSON());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);
        Response response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int initial_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Initial Table Size : " + initial_tablesize);

        logger.info(API.getATShostIP() + API.ats_send_column());
        request = null;
        String updatecolumndata  = API.data_sendcolumndata().replace("{random.int}", uniqueNumber.toString());
        request = RestAssured.given().body(updatecolumndata).contentType(ContentType.JSON);
        response = request.post(API.ats_send_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response : " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = null;
        request = RestAssured.given().body(API.data_tableJSON()).contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int end_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Table Size After adding unique Columns : " + end_tablesize);

        Assert.assertTrue((initial_tablesize+1)==end_tablesize,
                "Table size is not changed. "
                        + " Initial size: " + initial_tablesize
                        + " Table size after adding new column is: " + end_tablesize );

    }

    @Test
    public void RetrieveAllRows_Test() {

        RequestSpecification request = null;
        Response response =null;
        logger.info(API.getATShostIP() + API.ats_retrieve_table_size());
        request = RestAssured.given()
                .body(API.data_tableJSON())
                .contentType(ContentType.JSON);

        response = request.get(API.ats_retrieve_table_size());
        Assert.assertEquals(response.getStatusCode(), 200);
        int initial_tablesize = response.jsonPath().getInt("TableLength");
        logger.info("Initial Table Size : " + initial_tablesize);


        logger.info(API.getATShostIP() + API.ats_retrieve_row());
        for(int i =0; i< initial_tablesize; i++){
            request = null;
            request = RestAssured.given();
            request.body(API.data_rowdata());
            request.contentType(ContentType.JSON);
            response = request.get(API.ats_retrieve_row());
            Assert.assertEquals(response.getStatusCode(), 200);
            logger.info("JSON Response " + i + response.jsonPath().get() );

        }

    }

    @Test
    public void UpdateAndRetrieveRows_Test() {

        Long uniqueNumber = System.currentTimeMillis();

        RequestSpecification request = null;
        Response response =null;
        logger.info(API.getATShostIP() + API.ats_update_column());
        request = RestAssured.given();
        String updatecolumndata  = API.data_updatecolumndata().replace("{random.int}", uniqueNumber.toString());
        logger.info(updatecolumndata);
        request.body(updatecolumndata);
        request.contentType(ContentType.JSON);
        response = request.post(API.ats_update_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());

        logger.info(API.getATShostIP() + API.ats_retrieve_column());
        request = RestAssured.given();
        request.body(API.data_columndata());
        request.contentType(ContentType.JSON);
        response = request.get(API.ats_retrieve_column());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("JSON Response " + response.jsonPath().get());
        Assert.assertTrue(response.jsonPath().get().toString().contains(uniqueNumber.toString()));

    }


}
