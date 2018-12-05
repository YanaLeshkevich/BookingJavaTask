package stepsDefinition;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    private BaseUtil baseUtil;

    public Hook(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Before
    public void initializeTest(){
        System.out.println("Run Before Test!!!");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUtil.setDriver(driver);
    }

    @After
    public void tearDownTest(){
        System.out.println("Run after Test!!!");
        baseUtil.getDriver().quit();
    }
}
