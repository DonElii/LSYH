/*
 * This test case verifies the workflow till Application/Registration page for Software Testing position in Szeged.
 * @author: Zoltán Liptai (example ID: ABC123)
 * @ide: IntelliJ IDEA v2020.2.3
 * @framework: JUnit v4.13
 */

package com.lufthansa.Testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.lufthansa.Pages.JobOpenings;
import com.lufthansa.Pages.TestAutomationEngineerSzeged;
import com.lufthansa.Pages.ApplicationRegistration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

        //Page Object Model @jobd for JobOpenings Page
        JobOpenings jobs = new JobOpenings(driver);

        //Scroll down by 800px
        js.executeScript("window.scrollBy(0,800)");

        //Select Location as Szeged (keywords: Szeged, Budapest, BpSzeged - else no location doesn't filtered)
        jobs.selectLocation("Szeged");
        Thread.sleep(1000);

        //Select Category as Software Testing (keywords: Software testing, Application Operations, Consulting/BA/PM, Corporate function, Infrastructure Operations, Leadership, Software Development, User Experience and Design - else category doesn't filtered)
        jobs.selectCategory("Software testing");
        Thread.sleep(1000);

        //Wait timer before clicking to position
        Thread.sleep(1500);

        //Opening Test Automation Engineer - Szeged position
        jobs.clickOnPosition();

        //Page Object Model @position for Test Automation Engineer - Szeged Page
        TestAutomationEngineerSzeged position = new TestAutomationEngineerSzeged(driver);

        //Explicitly waits for the title of Automation Engineer page
        position.PageTitle();

        //Scroll down by 800px
        js.executeScript("window.scrollBy(0,800)");

        //Asserting if title of position = "Test Automation Engineer - Szeged
        position.titleText("Test Automation Engineer - Szeged");

        //Asserting if description of position contains "Lufthansa Systems is looking for new team member for our office in Szeged!"
        position.descriptionText("Lufthansa Systems is looking for new team member for our office in Szeged!");

        //Clicking on Apply button
        position.clickOnApply();


        //Page Object Model @position for ApplicationRegistration Page
        ApplicationRegistration appli = new ApplicationRegistration(driver);

        //Explicitly waits for the title of ApplicationRegistration page
        appli.PageTitle();

        //Scroll down by 400px
        js.executeScript("window.scrollBy(0,400)");

        //Asserting if title of the Application = "Application / Registration"
        appli.titleText("Application / Registration");

        //Asserting if description of the Application contains "Would you like to join us as Test Automation Engineer - Szeged?"
        appli.descriptionText("Would you like to join us as Test Automation Engineer - Szeged?");

        //Optional wait time to see the actual ending before quitting
        Thread.sleep(3000);

    }
}
