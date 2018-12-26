package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraProcesoRemesaAgregarGeneral {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://54.235.81.157/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCCarteraProcesoRemesaAgregarGeneral() throws Exception {
    driver.get(baseUrl + "/carteratest/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Evo3.");
    driver.findElement(By.name("BTNENTER")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//li[10]/a/span")).getText(), "Procesos");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[11]/a[8]")).click();
    driver.findElement(By.id("IMGINSERTREMESA")).click();
    driver.findElement(By.id("vREMESAFECHACORTE")).clear();
    driver.findElement(By.id("vREMESAFECHACORTE")).sendKeys("26122018");
    driver.findElement(By.id("vREMESAOBSERVACION")).clear();
    driver.findElement(By.id("vREMESAOBSERVACION")).sendKeys("Remesa");
    driver.findElement(By.name("BTNENTER")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |  | 30000]]
    boolean remesaGenerada = isElementPresent(By.xpath("//span/div"));
    driver.findElement(By.name("BTNCANCELAR")).click();
    driver.findElement(By.xpath("//td[4]/span/a")).click();
    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/span/a")).click();
    driver.findElement(By.id("W0016W0037EXPORT")).click();
    try {
      assertEquals(driver.findElement(By.id("vIMGPDF_0001")).getText(), "");
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
