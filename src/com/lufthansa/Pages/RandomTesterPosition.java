/*
 * This class stores all the locators and methods of any randomly selected Szeged based Tester job.
 * @url: any opened Tester jobs in Szeged: https://job.lhsystems.hu/en/job-offers?Y2l0aWVzJTVCJTVEJTNEU3plZ2VkJTI2c3BlY2lhbGl0aWVzJTVCJTVEJTNEU29mdHdhcmUlMjB0ZXN0aW5nJTI2#!
 *
 */

package com.lufthansa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RandomTesterPosition {

    WebDriver driver;

    By title_text = By.xpath("//h1[contains(.,\'Test')]");
    By description_text = By.xpath("//p[contains(.,\'Szeged')]");
    By apply = By.xpath("//a[@id='event-apply-apply']");


    public RandomTesterPosition(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRandomPosition()
    //Open random open position visible on the screen
    {
        List<WebElement> div_elements = driver.findElements(By.xpath("//a[@class='job_list_item']"));
        Random random = new Random();

        int num = random.nextInt(div_elements.size());

            WebElement item = div_elements.get(num);
            if (item.isDisplayed()) {
                System.out.println("Open position found. Proceeding to application");
                item.click();
            } else {
                System.out.println("No open positions found matching with criteria");
            }
    }


    public void titleText(String input_text)
    //captures the title of the Job
    //asserting if the text = parameter (input_text)
    {
        String textTitle = driver.findElement(title_text).getText();
        assertTrue("Title in 'h1' tag contains:", textTitle.contains(input_text));
    }


    public void descriptionText(String input_description)
    //captures the description of the Job
    //asserting if the description = parameter (input_description)
    {
        String TextDesc = driver.findElement(description_text).getText();
        assertTrue("Description contains: Szeged", TextDesc.contains(input_description));
    }

    public void clickOnApply()
    //clicks on "Apply" button
    {
        driver.findElement(apply).click();
    }

}
