/*
 * This class stores all the locators and methods of Application / Registration page.
 * @url: https://job.lhsystems.hu/en/apply/-/0/internet
 *
 */

package com.lufthansa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ApplicationRegistration {

    WebDriver driver;

    By title_text = By.xpath("//h1[contains(.,\'Application / Registration')]");


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
        assertTrue("title of the page in 'h1': 'Application / Registration' ", toText.contains(input_text));

    }
}
