package common;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import stepdefenition.Hooks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomVerify {
    public static void verifyEqual(String expectedValue, WebElement element, VerifyTypes type)
    {
        Hooks.activityElement = element;
        if(type == VerifyTypes.TEXT)
        {
            Assert.assertEquals(expectedValue, element.getText());
        }
        else if(type == VerifyTypes.VALUE)
        {
            Assert.assertEquals(expectedValue, element.getAttribute("value"));
        }
        else if(type == VerifyTypes.PLACEHOLDER)
        {
            Assert.assertEquals(expectedValue, element.getAttribute("placeholder"));
        }
        else if(type == VerifyTypes.INNER_TEXT)
        {
            Assert.assertEquals(expectedValue, element.getAttribute("innertext"));
        }
        else if (type == VerifyTypes.TYPE)
        {
            Assert.assertEquals(expectedValue, element.getAttribute("type"));
        }
        else if (type == VerifyTypes.CLASS)
        {
            Assert.assertEquals(expectedValue, element.getAttribute("class"));
        }
        else
        {
            throw new IllegalArgumentException("The verify type is invalid");
        }
    }
    public static void verifyRemoteResource(String resource)
    {
        try {
            URL url = new URL(resource);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int statusCode = http.getResponseCode();
            Assert.assertEquals("Resource: " + resource +" is not existed.",200, statusCode);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
