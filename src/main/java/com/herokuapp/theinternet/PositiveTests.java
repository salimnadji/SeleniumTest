package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
    @Test
    public void loginTest() {

        System.out.println("starting the test");
        System.setProperty("webdriver.chrome.drive", "./driver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        sleep(3000);
        webDriver.manage().window().maximize();

        String url = "http://the-internet.herokuapp.com/login";
        webDriver.get(url);
        sleep(3000);
        System.out.println("page is opened");

        sleep(2000);

        System.out.println("------->now to check username");

        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        sleep(2000);

        System.out.println("------->now to check password");

        WebElement password = webDriver.findElement(By.id("password"));

        password.sendKeys("SuperSecretPassword!");
        sleep(3000);
        System.out.println("------->now to check longIn");
        WebElement logInButton = webDriver.findElement(By.tagName("button"));
        logInButton.click();

        sleep(4000);


        System.out.println("****************Starting Verifications   :");


        //new URL;
        String expectedUrl="http://the-internet.herokuapp.com/secure";
        String currentUrl=webDriver.getCurrentUrl();

        Assert.assertEquals(currentUrl,expectedUrl,"Url is different than expected!! something went wrong!");
        //existance of a logout button.

        WebElement logOutButton = webDriver.findElement(By.ByXPath.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logOutButton.isDisplayed(),"Something went wrong !");
        Assert.assertTrue(logOutButton.getText().equals("Logout"),"Button not displayed! Failure");
        //successful login message.

        WebElement successMessage = webDriver.findElement(By.cssSelector("#flash"));
        String expectedSuccessMessage="You logged into a secure area!";
        String currentText=successMessage.getText().substring(0,successMessage.getText().length()-2);
        Assert.assertEquals(currentText,expectedSuccessMessage,"targeted text is not the same!");

        System.out.println("test finished!!! goodbye!");
        webDriver.quit();


    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
