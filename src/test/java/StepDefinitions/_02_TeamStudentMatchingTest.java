package StepDefinitions;

import Pages.DialogContent2;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_TeamStudentMatchingTest {
    DialogContent2 dialogContent2 = new DialogContent2();

    @Given("Navigate to the page for Team Student")
    public void navigateToThePageForTeamStudent() {
        ParameterDriver.getDriver().get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
    }

    @Then("Distribute the students to the teams")
    public void distributeTheStudentsToTheTeams() {
        Actions actions = new Actions(ParameterDriver.getDriver());

        while (dialogContent2.listOfStudents.size() != 0) {

            int currentTeam = 4;
            for (WebElement s : dialogContent2.listOfStudents) {
                Action action = actions.clickAndHold(s).moveToElement(dialogContent2.listOfTeams.get(currentTeam)).release(dialogContent2.listOfTeams.get(currentTeam)).build();
                action.perform();
                currentTeam--;

                if (currentTeam < 0) {
                    currentTeam = 4;
                }
            }
        }


    }
}
