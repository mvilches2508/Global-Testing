package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraGenerarPrepagoNroOperacionError {
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
  public void testTCCarteraGenerarPrepagoNroOperacionError() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[7]/td/table/tbody/tr/td[2]/p/span/a")).click();
    new Select(driver.findElement(By.id("vTIPODEPREPAGO"))).selectByVisibleText("Prepago");
    new Select(driver.findElement(By.id("vRECAUDACIONDESCJUDICIALES"))).selectByVisibleText("5%");
    driver.findElement(By.id("vCREFCHPREPAGO")).clear();
    driver.findElement(By.id("vCREFCHPREPAGO")).sendKeys("221118");
    driver.findElement(By.id("vAUXCRENROOPE")).clear();
    driver.findElement(By.id("vAUXCRENROOPE")).sendKeys("170180332");
    driver.findElement(By.id("BTNENTER")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "No es posible generar el prepago : El crédito no está vigente.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("vAUXCRENROOPE")).clear();
    driver.findElement(By.id("vAUXCRENROOPE")).sendKeys("160084699");
    driver.findElement(By.id("BTNENTER")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "Ya existe una recaudación para el crédito. Retómela o borrela para ingresar una nueva.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("vAUXCRENROOPE")).clear();
    driver.findElement(By.id("vAUXCRENROOPE")).sendKeys("180229273");
    driver.findElement(By.id("vCREFCHPREPAGO")).clear();
    driver.findElement(By.id("vCREFCHPREPAGO")).sendKeys("");
    driver.findElement(By.id("BTNENTER")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/div")).getText(), "Debe especificar una fecha para poder emitir el prepago.");
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
