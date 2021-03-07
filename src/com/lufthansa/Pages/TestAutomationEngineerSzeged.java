/*
 * This class stores all the locators and methods of Test Automation Engineer - Szeged page.
 * @url: https://job.lhsystems.hu/en/job/test-automation-engineer-szeged-2283
 *
 */

package com.lufthansa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class TestAutomationEngineerSzeged {

    WebDriver driver;

    By title_text = By.xpath("//h1[contains(.,\'Test Automation Engineer - Szeged')]");
    By description_text = By.xpath("//p[contains(.,\'Lufthansa Systems is looking for new team member for our office in Szeged!')]");
    By apply = By.xpath("//a[@id='event-apply-apply']");


    public TestAutomationEngineerSzeged(WebDriver driver) {
        this.driver = driver;
    }


    public void PageTitle()
    //Explicitly waits for the title of Test Automation Engineer - Szeged page
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.titleIs("Test Automation Engineer - Szeged - Lufthansa Systems Hungária"));
        String title = driver.getTitle();
        assertTrue("Title is: Test Automation Engineer - Szeged - Lufthansa Systems Hungária", (driver.getTitle().contains("Test Automation Engineer - Szeged - Lufthansa Systems Hungária")));

    }

    public void titleText(String input_text)
    //captures the title of the Job
    //asserting if the text = parameter (input_text)
    {
        String textTitle = driver.findElement(title_text).getText();
        assertEquals(textTitle,input_text);
        assertTrue(textTitle.equals(input_text));
    }

    public void descriptionText(String input_description)
    //captures the description of the Job
    //asserting if the description = parameter (input_description)
    //optional message also added before the condition
    {
        String TextDesc = driver.findElement(description_text).getText();
        assertTrue("Description contains: Lufthansa Systems is looking for new team member for our office in Szeged!", TextDesc.contains(input_description));
    }

    public void clickOnApply()
    //clicks on "Apply" button
    {
        driver.findElement(apply).click();
    }

}
