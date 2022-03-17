package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.Test;
import org.junit.Before;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private RemoteWebDriver driver;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        System.out.println("Iniciando configuración...");
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        //cap.setPlatform(Platform.WIN10);

        ChromeOptions options = new ChromeOptions();
        options.merge(cap);

        String huburl = "http://localhost:4445/wd/hub";
        driver = new RemoteWebDriver(new URL(huburl), options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.get("https://www.amazon.com");
        //driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
    }
}
