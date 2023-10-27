package StepDefinitions;

import Pages.DialogContent3;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class _03_CityCountryMatchingTest {
    DialogContent3 dialogContent3 = new DialogContent3();

    @Given("Navigate to the page for City Country")
    public void navigateToThePageForCityCountry() {
        ParameterDriver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
    }

    @Then("Distribute the cities to the correct Countries")
    public void distributeTheCitiesToTheCorrectCountries() {
        dialogContent3.scrollDownByPixel(400);

        Actions actions = new Actions(ParameterDriver.getDriver());

        for (WebElement city : dialogContent3.cities){
            for (WebElement country : dialogContent3.countries){
                Action action = actions.clickAndHold(city).moveToElement(country).release(country).build();
                action.perform();

                // At the end of the distribution, we have alert to handle
                try {
                    Alert alert = ParameterDriver.getDriver().switchTo().alert();
                    String alertText = alert.getText();
                    Assert.assertEquals(alertText, "Congratulations! Everything is correct");
                    alert.accept();
                } catch (NoAlertPresentException e) {

                }

                if (city.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) {
                    break;
                }

            }
        }

    }

    @Then("Verify all the answers are correct")
    public void verifyAllTheAnswersAreCorrect() {
        for (WebElement correctAnswer : dialogContent3.correctAnswers){
            Assert.assertTrue(correctAnswer.getCssValue("background-color").equals("rgba(0, 128, 0, 1)"));
        }
    }
}
