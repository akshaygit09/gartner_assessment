package com.qa.test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GETAPITest extends TestBase{
	TestBase testBase;
    String serviceURL;
    String apiurl;
    String url;
    RestClient restClient;
@BeforeMethod
    public void setUp() throws IOException, JSONException {
    testBase = new TestBase();
     serviceURL = prop.getProperty("URL");
     apiurl = prop.getProperty("ServiceURL");
      url = serviceURL + apiurl ;
}
@Test
public void getTest() throws IOException, JSONException {
    restClient = new RestClient();
    restClient.get(url);
}

}
