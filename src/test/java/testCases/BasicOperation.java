package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicOperation {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create ChromeOptions to set browser configurations
        ChromeOptions options = new ChromeOptions();

        // Add incognito mode
        options.addArguments("--incognito");

        // (Optional) disable notifications and infobars for cleaner runs
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to Google
        driver.get("https://www.google.com");
    }

    @Test
    public void searchTest() throws InterruptedException {
        // Locate search box
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type the search text
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the search
        searchBox.submit();

        // Wait for page to load
        Thread.sleep(2000);

        // Validate title contains "Selenium WebDriver"
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.contains("Selenium WebDriver"), "Title does not contain search term!");
    }

    @AfterClass
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
