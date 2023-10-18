package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends MyMethods {
    public DialogContent() {
        PageFactory.initElements(ParameterDriver.getDriver(), this);
    }

    @FindBy(css = "div[id='answerDiv'] > div[class='dragDropSmallBox']")
    public List<WebElement> cities;

    @FindBy(css = "div[id='questionDiv'] > div[class='destinationBox']")
    public List<WebElement> countriesBox;

}
