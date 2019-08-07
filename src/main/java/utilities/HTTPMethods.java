package utilities;

import org.apache.http.HttpResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;


/**
 * Common Methods for HTTP Requests
 */
public class HTTPMethods {

	public static StringBuffer GETRequest(String urlname) throws IOException{

		URL urlForGetRequest = new URL(urlname);
		System.out.println(urlForGetRequest);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		int responseCode = conection.getResponseCode();
		System.out.println("responseCode"+ responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} in .close();
			// print result
			System.out.println("JSON String Result " + response.toString());
			return response;

			//GetAndPost.POSTRequest(response.toString());
		} else {
			System.out.println("GET NOT WORKED");
		}
		return null;
	}


	public static String GETRequestResponse(String urlname) throws IOException {

		URL urlForGetRequest = new URL(urlname);
		System.out.println(urlForGetRequest);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		int responseCode = conection.getResponseCode();
		System.out.println("responseCode" + responseCode);
		StringBuilder response = null;
		if (responseCode == HttpURLConnection.HTTP_OK) {

			BufferedReader in = new BufferedReader(new InputStreamReader(
					conection.getInputStream()));
			response = new StringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
				response.append(line);

			}
			in.close();
			// print result
			System.out.println("JSON String Result " + response.toString());


			//GetAndPost.POSTRequest(response.toString());
		} else {
			System.out.println("GET Request is not WORKED");
		}
		return response.toString();
	}


	public static StringBuffer POSTRequest(String urlname) throws IOException{
		URL urlForPOSTRequest = new URL(urlname);
		System.out.println(urlForPOSTRequest);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForPOSTRequest.openConnection();

		conection.setRequestMethod("POST");
		conection.setRequestProperty("Content-Type", "femto/binary");

		int responseCode = conection.getResponseCode();
		System.out.println("responseCode"+ responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} in .close();
			// print result
			System.out.println("JSON String Result " + response.toString());
			//GetAndPost.POSTRequest(response.toString());
			return response;
		} else {
			System.out.println("GET NOT WORKED");
		}
		return null;
	}

	public String readResponse(HttpResponse response)
			throws IllegalStateException, IOException {
		BufferedReader breader = new BufferedReader(new InputStreamReader(
				(response).getEntity().getContent()));
		StringBuilder responseString = new StringBuilder();
		String line = "";
		while ((line = breader.readLine()) != null) {
			responseString.append(line);
		}
		breader.close();
		return responseString.toString();
	}

	public static String getValuefromJSON(JSONObject apiJsonObj, String key){
		//		HashMap<String, Object> map = new HashMap<>();
		String retrievedvalue = null;
		Iterator <String> iter = apiJsonObj.keys();
		while (iter.hasNext()) {
			String retrievedkey = iter.next().toString();
			if (retrievedkey.equalsIgnoreCase(key)){
				retrievedvalue = apiJsonObj.get(key).toString();
			}
//			map.put(key, value);
		}
		return retrievedvalue;
	}

}
