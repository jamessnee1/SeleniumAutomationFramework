package com.webtests.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestSuite {

    //protected static ChromeDriver driver;
    protected static WebDriver driver;

    @BeforeAll
    public static void Setup() throws MalformedURLException {

        //Local
        //System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        //driver = new ChromeDriver();

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setCapability("browserVersion", "92");

        //Run via localhost against Selenium grid
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

        //Set driver timeout
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void Startup(){
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void Cleanup(){
        driver.quit();
    }
}
