package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions (
        features = "src/test/java/FutureFiles/_01_AutomatedMatchingTest.feature",
        glue = "StepDefinitions",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class _01_Runner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeOnExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name","Tunahan Boyaci");
        ExtentService.getInstance().setSystemInfo("Application Name","dhtmlgoodies");
        ExtentService.getInstance().setSystemInfo("Operating System Info",System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department","QA");
        ExtentService.getInstance().setSystemInfo("Additional line","Additional info");
    }

}
