/*
 * This test case verifies the workflow till Application/Registration page for a randomly selected Szeged based Software Testing position.
 * @author: Zoltán Liptai (example ID: ABC123)
 * @ide: IntelliJ IDEA v2020.2.3
 * @framework: JUnit v4.13
 */

package com.lufthansa.Testcases;

import com.lufthansa.Pages.JobOpenings;
import com.lufthansa.Pages.RandomTesterPosition;
import com.lufthansa.Pages.ApplicationRegistration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class ApplyToPosition {

    WebDriver driver;
    Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        //options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void ApplyToPosition_test() throws InterruptedException {

        //navigate to the URL
        driver.get("https://job.lhsystems.hu/en/job-offers");
        //maximize the window
        driver.manage().window().maximize();

        //Page Object Model @job for JobOpenings Page
        JobOpenings jobs = new JobOpenings(driver);

        //Scroll down by 800px
        js.executeScript("window.scrollBy(0,800)");

        //Select Location as Szeged (keywords: Szeged, Budapest, BpSzeged - else no location doesn't filtered)
        jobs.selectLocation("Szeged");
        Thread.sleep(1000);

        //Select Category as Software Testing (keywords: Software testing, Software Development, Application Operations, Consulting/BA/PM, Corporate function, Infrastructure Operations, Leadership, User Experience and Design - else category doesn't filtered)
        jobs.selectCategory("Software testing");
        //jobs.selectCategory("Software Development");

        //Wait timer before clicking to position
        Thread.sleep(1500);

        //Page Object Model @randomjob for RandomTesterPosition Page
        RandomTesterPosition randomjob = new RandomTesterPosition(driver);

        //Opening Random open position based on previous filtering (Szeged & Software testing)
        randomjob.clickOnRandomPosition();

        //Scroll down by 800px
        js.executeScript("window.scrollBy(0,500)");

        //optional : Asserting if title of random position contains the below text
        //randomjob.titleText("Test");

        //optional: Asserting if description of random position contains the below text
        //randomjob.descriptionText("Szeged");

        //Clicking on Apply button
        randomjob.clickOnApply();

        //Page Object Model @appli for ApplicationRegistration Page
        ApplicationRegistration appli = new ApplicationRegistration(driver);

        //Explicitly waits for the title of ApplicationRegistration page
        appli.PageTitle();

        //Scroll down by 400px
        js.executeScript("window.scrollBy(0,200)");

        //Asserting if title of the Application Page is "Application / Registration"
        appli.titleText("Application / Registration");

        //Optional wait time to see the actual ending before quitting
        Thread.sleep(3000);

    }
}
