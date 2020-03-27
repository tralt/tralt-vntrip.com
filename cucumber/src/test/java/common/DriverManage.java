package common;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverManage
{
    public static Set<Cookie> browserCookie;
    public static WebDriver GetBrowser(String browser)
    {
        WebDriver driver = null;
        if(browser.equalsIgnoreCase ("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/webdriver/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("dom.push.enabled", false);
            driver = new FirefoxDriver(options);

        }
        else if (browser.equalsIgnoreCase ("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/webdriver/chromedriver80.exe");
            Map prefs = new HashMap();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            options.addArguments("--whitelist-ip %*");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase ("appium"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        }

        //Append cookie if existed
        if(browserCookie!=null && browserCookie.size()>0)
        {
            for(Cookie ck : browserCookie)
            {
                driver.manage().addCookie(ck);
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}
