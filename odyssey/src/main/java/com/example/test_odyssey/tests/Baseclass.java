package com.example.test_odyssey.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.example.test_odyseyy.utils.Extent_report;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    protected WebDriver driver;
    protected Extent_report extentReport;

    @BeforeSuite
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        Extent_report.setupExtentReport();
        extentReport = new Extent_report(driver);
    }
    @AfterSuite
    public void tearDown() {
        Extent_report.tearDown();
        driver.quit();
    }
}
