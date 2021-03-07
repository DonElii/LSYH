/*
 * This class stores all the locators and methods of Application / Registration page.
 * @url: https://job.lhsystems.hu/en/apply/-/0/internet
 *
 */

package com.lufthansa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class ApplicationRegistration {

    WebDriver driver;

    By title_text = By.xpath("//h1[contains(.,\'Application / Registration')]");
    By description_text = By.xpath("//h2[contains(.,\'Would you like to join us as Test Automation Engineer - Szeged? ')]");


    public ApplicationRegistration(WebDriver driver) {
        this.driver = driver;
    }


    public void PageTitle()
    //Explicitly waits for the title of Application / Registration page
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.titleIs("Application / Registration - Lufthansa Systems Hungári"));
        String title = driver.getTitle();
        assertTrue("Title is: Application / Registration - Lufthansa Systems Hungária", (driver.getTitle().contains("Application / Registration - Lufthansa Systems Hungári")));

    }

    public void titleText(String input_text)
    //captures the title of the Application / Registration page
    //asserting if the title = parameter (input_text)
    {
        String toText = driver.findElement(title_text).getText();
        assertTrue(toText.contains(input_text));

    }

    public void descriptionText(String input_description)
    //captures the description of Application / Registration page
    //asserting if the description = parameter (input_description)
    //optional message also added before the condition
    {
        String toText = driver.findElement(description_text).getText();
        assertTrue("Description contains: Would you like to join us as Test Automation Engineer - Szeged?", toText.contains(input_description));
    }

}
