package com.qa.client;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {
	/**
	 * GET METHOD
	 * @param https://pickle.rick
	 * @throws IOException
	 * @throws JSONException
	 */
	
    public void get(String url) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault(); //create one http connection
        HttpGet httpGet = new HttpGet(url); //http get request
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); //hit the GET URL
        //Status Code

        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code -->>" + statuscode);
        //JSON String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        System.out.println("ResponeString :" + responseString);

        JSONObject responseJsonObject = new JSONObject(responseString);
        System.out.println("ResponseJSONfromAPI" +responseJsonObject);

        //HeaderTesting
        Header[] headersArray = closeableHttpResponse.getAllHeaders();
        HashMap<String,String> allheaders = new HashMap<String,String>();

        for(Header header : headersArray){
            allheaders.put(header.getName(),header.getValue());
        }
        System.out.println("Headers Array" + allheaders);

    }

}
