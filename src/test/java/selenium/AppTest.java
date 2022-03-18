package selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }

    @Test
    public void busquedaDevOpsHandbook() {
        driver.navigate().to("https://www.google.com");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        WebElement element = wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(
                "#rso a"))));

        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement productTitle = wait
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("productTitle"))));

        assertEquals(
                "The DevOps Handbook: How to Create World-Class Agility, Reliability, and Security in Technology Organizations",
                productTitle.getText());
    }

    @Test
    public void busquedaThePhoenixProject() {
        driver.navigate().to("https://www.amazon.com");
        WebElement searchbox = driver.findElement(By.name("field-keywords"));
        searchbox.sendKeys("The Phoenix Project");
        searchbox.submit();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        WebElement element = wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(
                ".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > a:nth-child(1) > span:nth-child(1)"))));

        assertEquals(
                "The Phoenix Project: A Novel about IT, DevOps, and Helping Your Business Win 5th Anniversary Edition",
                element.getText());

    }
}
