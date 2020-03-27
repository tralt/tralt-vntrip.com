package pageobject;

import common.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends PageObject
{

    By CHECKIN_FIELD = By.cssSelector("input.t-input-check-in");
    By CHECKOUT_FIELD = By.cssSelector("input.t-input-check-out");

    public void Verify_The_List_Of_Hotel_Will_Be_Show_With(String destination, String from, String to)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        boolean isDestination = js.executeScript(" return document.querySelector('input.input-provinces').value")
                .toString().equalsIgnoreCase(destination);

        boolean isCheckInDate = this.findElement(CHECKIN_FIELD).getAttribute("value").equalsIgnoreCase(from);

        boolean isCheckOutDate = this.findElement(CHECKOUT_FIELD).getAttribute("value").equalsIgnoreCase(to);

        if (isDestination && isCheckInDate && isCheckOutDate)
        {
            List<WebElement> lstResults = this.driver.findElements(By.cssSelector("section.prdList"));
            boolean isShown = lstResults.size() != 0;
            if (isShown)
            {
                Assert.assertTrue(isShown);
            }
            else {
                System.out.println("ERROR!!! no hotel found");
            }
        }
    }
}
