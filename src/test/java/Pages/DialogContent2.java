package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class    DialogContent2 extends MyMethods {
    public DialogContent2(){
        PageFactory.initElements(ParameterDriver.getDriver(),this);
    }

    @FindBy (css = "ul[id='allItems'] > li")
    public List<WebElement> listOfStudents;

    @FindBy (css = "div[id=\"dhtmlgoodies_mainContainer\"] > div > ul")
    public List<WebElement> listOfTeams;


}
