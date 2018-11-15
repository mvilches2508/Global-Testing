package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraChequesConsolidadoError {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://54.235.81.157/carteragx15/seclogin.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCCarteraChequesConsolidadoError() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[6]/td/table/tbody/tr/td[2]/p/span/a")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Estado");
    new Select(driver.findElement(By.id("vCHEQUEESTADO1"))).selectByVisibleText("COBRADO");
    driver.findElement(By.id("vSELECTED_0001")).click();
    driver.findElement(By.id("NUEVAUBICACION")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "Los cheques deben estar en cartera para poder ser re ubicados.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.id("vCHEQUEESTADO1"))).selectByVisibleText("PROTESTADO");
    driver.findElement(By.id("vSELECTED_0001")).click();
    driver.findElement(By.id("DEPOSITAR")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "Los cheques deben estar en cartera para poder ser depositados.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.id("vCHEQUEESTADO1"))).selectByVisibleText("EN CARTERA");
    driver.findElement(By.id("vSELECTED_0001")).click();
    driver.findElement(By.id("COBRAR")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "Los cheques deben estar depositados para poder ser cobrados.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("IMAGE2_MPAGE")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
