package stepdefenition;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.ResultPage;

public class Finds_Hotel_Defs
{
    WebDriver driver;
    HomePage homePage;
    ResultPage resultPage;

    public Finds_Hotel_Defs()
    {
        this.driver = Hooks.driver;
        this.homePage = new HomePage();
        this.resultPage = new ResultPage();

    }

    @Given("^He finds hotel on the vntrip website$")
    public void he_finds_hotel_on_the_vntrip_website() throws Throwable {
        this.homePage.Open();
    }

    @When("^He attempts to search with a destination, check in date and check out date$")
    public void he_attempts_to_search_with_a_destination_check_in_date_and_check_out_date() throws Throwable {
        this.homePage.visitor_go_to("Phu Quoc").from("06/04/2020").to("10/04/2020").Search();
    }

    @Then("^He sees that the list of hotel will be shown$")
    public void he_sees_that_the_list_of_hotel_will_be_shown() throws Throwable {
        this.resultPage.Verify_The_List_Of_Hotel_Will_Be_Show_With("Phú Quốc", "06-04-2020", "10-04-2020");
    }
}
