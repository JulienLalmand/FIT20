package be.odisee.fit20;

 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
 
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber"},tags={"~@skip"})
public class RunTests {
}
