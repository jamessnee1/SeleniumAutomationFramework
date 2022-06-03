package com.webtests.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //protected static ChromeDriver driver;
    protected static WebDriver driver;

    @BeforeAll
    public static void Setup() throws MalformedURLException {

        //Uncomment whether running local or running remote
        initLocalWebDriver("D:\\ChromeDriver\\chromedriver.exe");
        //initRemoteWebDriver("http://localhost:4444/wd/hub");
        setDriverTimeout(3);

    }

    @BeforeEach
    public void Startup(){
        //Set URL to navigate to here
        //AccessHQ Forms Planets Website
        //driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        //PizzaHQ Website
        driver.get("https://d3udduv23dv8b4.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void Cleanup(){
        driver.quit();
    }

    public static void initRemoteWebDriver(String url) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //Run via localhost against Selenium grid
        driver = new RemoteWebDriver(new URL(url), chromeOptions);
    }

    public static void initLocalWebDriver(String webDriverLocation){
        System.setProperty("webdriver.chrome.driver", webDriverLocation);
        driver = new ChromeDriver();
    }

    public static void setDriverTimeout(int timeoutSecs){
        //Set driver timeout
        driver.manage().timeouts().implicitlyWait(timeoutSecs, TimeUnit.SECONDS);
    }
}
