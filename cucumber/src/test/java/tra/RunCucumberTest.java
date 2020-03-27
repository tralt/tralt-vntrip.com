package tra;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"},
        glue = "stepdefenition",
        features = "C:\\TRA\\cucumber\\src\\test\\resources\\tra\\FindHotel.feature",
        //tags = {"@new"},
        monochrome = true,
        strict = true)
public class RunCucumberTest {
}
