package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraChequesProtestoCambioCheque {
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
  public void testTCCarteraChequesProtestoCambioCheque() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[6]/td/table/tbody/tr/td[2]/p/span/a")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Estado");
    driver.findElement(By.xpath("//option[6]")).click();
    new Select(driver.findElement(By.id("vCHEQUEESTADO1"))).selectByVisibleText("PROTESTADO");
    boolean nroCheque = isElementPresent(By.xpath("//td[8]/span/a"));
    driver.findElement(By.id("vCAMBIAR_0001")).click();
    new Select(driver.findElement(By.id("vFORMADEPAGOID"))).selectByVisibleText("Efectivo");
    String montoCheque = driver.findElement(By.id("span_vCHEQUEMONTO")).getText();
    driver.findElement(By.id("vRECCAMBIOFORMADEPAGOMONTO")).clear();
    driver.findElement(By.id("vRECCAMBIOFORMADEPAGOMONTO")).sendKeys("514030");
    driver.findElement(By.id("AGREGAR")).click();
    driver.findElement(By.id("BTNCONFIRMAR")).click();
    boolean confirmarCambio = isElementPresent(By.xpath("//div/div/div[3]"));
    driver.findElement(By.id("DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer_SaveButton")).click();
    boolean nroCheque2 = isElementPresent(By.xpath("//td[8]/span/a"));
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
