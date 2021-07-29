package com.browserstack.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class BrowserStackToolDemo {

    public static final String AUTOMATE_USERNAME = "diliprathod_3kLBpK";
    public static final String AUTOMATE_ACCESS_KEY = "XXepahh7M1hFg8SqepCx";
    public static final String url = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "91.0");
        caps.setCapability("project", "Test");
        caps.setCapability("build", "Build1");// CI/CD job or build name
        caps.setCapability("name", "test1");// test name
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.selenium_version", "3.14.0");

        WebDriver driver = new RemoteWebDriver(new URL(url), caps);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
