package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent3 extends MyMethods {
    public DialogContent3() {
        PageFactory.initElements(ParameterDriver.getDriver(), this);
    }

    @FindBy (css = "ul[id=\"allItems\"] > li")
    public List<WebElement> cities;

    @FindBy (css = "div[id=\"dhtmlgoodies_mainContainer\"] > div > ul")
    public List<WebElement> countries;

    @FindBy (css = "div > ul > li[class=\"correctAnswer\"]")
    public List<WebElement> correctAnswers;


}
