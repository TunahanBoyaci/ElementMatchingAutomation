package StepDefinitions;

import Pages.DialogContent;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _01_AutomatedMatchingTest {
    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to the page")
    public void navigateToThePage() {
        ParameterDriver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
    }

    @Then("Put all Cities to the correct Countries")
    public void putAllCitiesToTheCorrectCountries() {
        // Close the ad manually in 2 seconds
        MyMethods2.myWait(2);

        Actions actions = new Actions(ParameterDriver.getDriver());

        for (WebElement city : dialogContent.cities) {
            for (WebElement countryBox : dialogContent.countriesBox) {
                Action action = actions.clickAndHold(city).moveToElement(countryBox).release(countryBox).build();
                action.perform();

                // if it is not green, remove that country from the list
                if (city.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) {
                    dialogContent.countriesBox.remove(countryBox);
                    break;
                }

            }
        }
    }
}
