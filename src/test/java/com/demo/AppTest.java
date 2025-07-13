package com.demo;

/**
 * Unit test for simple App.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class AppTest {
  WebDriver driver;

  @BeforeClass
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }

  @Test
  public void openGoogle() {
    driver.get("https://www.google.com");
    assertTrue(driver.getTitle().contains("Google"));
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
