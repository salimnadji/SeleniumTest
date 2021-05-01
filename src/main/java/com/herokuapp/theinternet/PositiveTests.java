package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //existance of a logout button.

        WebElement logOutButton = webDriver.findElement(By.ByXPath.xpath("//a[@class='button secondary radius']"));
        //successful login message.

        WebElement successMessage = webDriver.findElement(By.cssSelector("#flash"));

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
