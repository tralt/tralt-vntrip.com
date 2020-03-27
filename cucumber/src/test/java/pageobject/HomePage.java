package pageobject;

import common.PageObject;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HomePage extends PageObject {
    public HomePage()
    {
        super();
        this.Url = "https://www.vntrip.vn/";
    }

    By SEARCH_FIELD = By.cssSelector("#trip-keywords");
    By SUGGESTION_TOP_ITEM = By.cssSelector("ul.search-suggest >li:nth-child(2)");
    By CHECK_IN_FIELD = By.cssSelector("div.t-date-check-in");
    By SEARCH_BUTTON  = By.cssSelector("#trip-submit");


    public HomePage visitor_go_to(String destination)
    {
        this.findElement(SEARCH_FIELD).sendKeys(destination);
        try{Thread.sleep(3000);} catch (Exception e){e.printStackTrace();}
        this.findElement(SUGGESTION_TOP_ITEM).click();
        try{Thread.sleep(2000);} catch (Exception e){e.printStackTrace();}
        return this;
    }

    public HomePage from(String from) throws ParseException
    {
        this.findElement(CHECK_IN_FIELD).click();
        try { Thread.sleep(2000); } catch (Exception e){e.printStackTrace();}

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date =  formatter.parse(from); //1586044800000

        long millis = date.getTime();
        this.findElement(By.xpath("//td[@data-t-date=\""+millis+"\"]")).click();
        try { Thread.sleep(2000); } catch (Exception e){e.printStackTrace();}
        return this;
    }

    public HomePage to(String to) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = formatter.parse(to);

        long millis = date.getTime();
        this.findElement(By.xpath("//td[@data-t-date=\""+millis+"\"]")).click();
        try { Thread.sleep(2000); } catch (Exception e){e.printStackTrace();}
        return this;
    }

    public void Search()
    {
        this.findElement(SEARCH_BUTTON).click();
        try{Thread.sleep(6000);} catch (Exception e){e.printStackTrace();}
    }
}
