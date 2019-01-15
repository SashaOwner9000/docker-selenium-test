package test.java.com.testautomationguru.container.test;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class Base {

    protected WebDriver driver;
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        
        if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();

        driver = new RemoteWebDriver(new URL("http://" + System.getProperty("seleniumHubHost") + ":" + 
        System.getProperty("port") + "/wd/hub"), dc);
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }  
}
