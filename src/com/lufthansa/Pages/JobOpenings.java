/*
 * This class stores all the locators and methods of Job Openings page.
 * @url: https://job.lhsystems.hu/en/job-offers
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


public class JobOpenings
{

    WebDriver driver;

    By location = By.xpath("//div[@id='ms-list-1']//button[@type='button']");
    By Szeged = By.xpath("//input[@value='Szeged']");
    By Budapest = By.xpath("//input[@value='Budapest']");
    By BpSzeged = By.xpath("//input[@value='Budapest vagy Szeged']");

    By category = By.xpath("//div[@id='ms-list-4']//button[@type='button']");
    By testing = By.xpath("//input[@value='Software testing']");
    By operations = By.xpath("//input[@value='Application Operations']");
    By consulting = By.xpath("//input[@value='Consulting/BA/PM']");
    By corporate = By.xpath("//input[@value='Corporate function']");
    By infra = By.xpath("//input[@value='Infrastructure Operations']");
    By leader = By.xpath("//input[@value='Leadership']");
    By dev = By.xpath("//input[@value='Software Development']");
    By ued = By.xpath("//input[@value='User Experience and Design']");

    By position1 = By.xpath("//a[@id='description_cart_2283']");

    public JobOpenings(WebDriver driver)
    {
        this.driver=driver;
    }


    public void PageTitle()
    //Explicitly waits for the title of JobOpenings page
    {
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.titleIs("Job openings - Lufthansa System Hungária"));
        String title = driver.getTitle();
        assertTrue("Title is: Job openings - Lufthansa System Hungária",(title.contains("Job openings - Lufthansa System Hungária")));
    }

/*
    public void FilltheForm(String Szeged,String testing, String position1)
    //Fill the form in one go
    {
        driver.findElement(Szeged).click();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }

        driver.findElement(testing).click();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }

        driver.findElement(position1).click();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
    }
*/


    public void selectLocation(String loc)
    //selecting the location based on the parameter set in the test case.

    {
        String locVar = loc;
        driver.findElement(location).click();

        switch (locVar) {
            case "Szeged":
                driver.findElement(Szeged).click();
                System.out.println("Szeged selected");
                break;
            case "Budapest":
                driver.findElement(Budapest).click();
                System.out.println("Budapest selected");
                break;
            case "BpSzeged":
                driver.findElement(BpSzeged).click();
                System.out.println("Budapest & Szeged selected");
                break;
            default:
                System.out.println("Location filter hasn't been selected");
                break;
        }

    }


    public void selectCategory(String cat)
    //selecting the category based on the parameter set in the test case.

    {
        String catVar = cat;
        driver.findElement(category).click();

        switch (catVar) {
            case "Software testing":
                driver.findElement(testing).click();
                System.out.println("Software testing selected");
                break;
            case "Application Operations":
                driver.findElement(operations).click();
                System.out.println("Application Operations");
                break;
            case "Consulting/BA/PM":
                driver.findElement(consulting).click();
                System.out.println("Consulting/BA/PM selected");
                break;
            case "Corporate function":
                driver.findElement(corporate).click();
                System.out.println("Corporate function selected");
                break;
            case "Infrastructure Operations":
                driver.findElement(infra).click();
                System.out.println("Infrastructure Operations selected");
                break;
            case "Leadership":
                driver.findElement(leader).click();
                System.out.println("Leadership selected");
                break;
            case "Software Development":
                driver.findElement(dev).click();
                System.out.println("Software Development selected");
                break;
            case "User Experience and Design":
                driver.findElement(ued).click();
                System.out.println("User Experience and Design selected");
                break;
            default:
                System.out.println("Category filter hasn't been selected");
                break;
        }

    }


    public void clickOnPosition()
    {
        driver.findElement(position1).click();
    }
}
