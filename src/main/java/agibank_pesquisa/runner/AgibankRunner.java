package agibank_pesquisa.runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = "src/main/resources/agibank_pesquisa.feature", glue = "agibank_pesquisa/steps_defs/AgibankSteps.java")
public class AgibankRunner {

}
