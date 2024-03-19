package culture.learning.ci.config;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        glue = {"com.decathlon.tzatziki.steps", "culture.learning.ci.cucumber.steps"},
        features = "src/test/resources/features",
        tags = "not @ignore")
public class CucumberTest {
}
