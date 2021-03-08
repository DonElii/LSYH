/*
 * This class optionally used, if a known job should be opened
 * This class stores all the locators and methods of Test Automation Engineer - Szeged page.
 * @url: https://job.lhsystems.hu/en/job/test-automation-engineer-szeged-2283
 *
 */

package com.lufthansa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestAutomationEngineerSzeged {

    WebDriver driver;

    By position1 = By.xpath("//a[@id='description_cart_2283']");
    By title_text = By.xpath("//h1[contains(.,\'Test Automation Engineer - Szeged')]");
    By description_text = By.xpath("//p[contains(.,\'Lufthansa Systems is looking for new team member for our office in Szeged!')]");
    By apply = By.xpath("//a[@id='event-apply-apply']");


    public TestAutomationEngineerSzeged(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPosition()
    //Click on the job: Test Automation Engineer - Szeged in JobOpenings
    {
        driver.findElement(position1).click();
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
        //assertTrue(textTitle.equals(input_text));
    }

    public void descriptionText(String input_description)
    //captures the description of the Job
    //asserting if the description = parameter (input_description)
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
