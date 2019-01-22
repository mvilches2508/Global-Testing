package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraPagaresTrasladoAprobar {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://54.235.81.157/carteragx15/seclogin.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCCarteraPagaresTrasladoAprobar() throws Exception {
    driver.get(baseUrl + "/carteratest/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Evo3.");
    driver.findElement(By.name("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[8]/td/table/tbody/tr/td[2]/p/span/a")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Guia Tipo");
    new Select(driver.findElement(By.id("vCARTAGUIATIPO1"))).selectByVisibleText("TRASLADO");
    String estado1 = driver.findElement(By.id("span_CARTAGUIAESTADO_0002")).getText();
    driver.findElement(By.id("vACEPTARCARTAGUIA_0002")).click();
    String  = driver.findElement(By.id("DVELOP_CONFIRMPANEL_ACEPTARCARTAGUIAContainer_ConfirmationText")).getText();
    try {
      assertTrue(driver.findElement(By.id("DVELOP_CONFIRMPANEL_ACEPTARCARTAGUIAContainer_ConfirmationText")).getText().matches("^exact:¿ Desea Confirmar la aceptación de ésta carta guía [\\s\\S]$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("DVELOP_CONFIRMPANEL_ACEPTARCARTAGUIAContainer_SaveButton")).click();
    String estado2 = driver.findElement(By.id("span_CARTAGUIAESTADO_0002")).getText();
    driver.findElement(By.id("IMAGE2_MPAGE")).click();
  }

  @After
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
