package stepdefenition;

import common.DriverManage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hooks {
    public static WebDriver driver;
    public static WebElement activityElement;

    @Before
    public void testStart() {
        String platformName = System.getProperty("browser", "chrome");
        if(!platformName.equals(""))
        {
            driver = DriverManage.GetBrowser(platformName);
        }
        else
        {
            throw new IllegalArgumentException("The Browser name is missing from command");
        }

    }

    @After
    public void scenarioFinish(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            /*
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", this.activityElement, "color: yellow; border: 2px solid red;");

            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");*/
        }
        driver.quit();
    }
}
