package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraCreditosLeasingPreJudicial {
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
  public void testTCCarteraCreditosLeasingPreJudicial() throws Exception {
    driver.get(baseUrl + "/carteratest/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Evo3.");
    driver.findElement(By.name("BTNENTER")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//span/a")).getText(), "Créditos");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//span/a")).click();
    driver.findElement(By.id("ADDDYNAMICFILTERS1")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Tipo Crédito");
    new Select(driver.findElement(By.id("vSOLICITUDTIPOCREDITO1"))).selectByVisibleText("LEASING");
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR2"))).selectByVisibleText("Estado Pago");
    new Select(driver.findElement(By.id("vCREESTADOPAGO2"))).selectByVisibleText("PRE JUDICIAL");
    driver.findElement(By.id("vEDITARCONVENIDO_0001")).click();
    String monto1 = driver.findElement(By.id("span_SDTCONVENIDO__DETCRETOTALSALDOS_0001")).getText();
    String op = driver.findElement(By.id("span_vCRENROOPE")).getText();
    driver.findElement(By.id("SDTCONVENIDO__DETCRECUO_0001")).clear();
    driver.findElement(By.id("SDTCONVENIDO__DETCRECUO_0001")).sendKeys("1290899");
    driver.findElement(By.id("SDTCONVENIDO__DETCREPAGTOT_0001")).clear();
    driver.findElement(By.id("SDTCONVENIDO__DETCREPAGTOT_0001")).sendKeys("1290899");
    driver.findElement(By.name("BTNCONFIRMAR")).click();
    driver.findElement(By.id("vEDITARCONVENIDO_0001")).click();
    String monto2 = driver.findElement(By.id("span_SDTCONVENIDO__DETCRETOTALSALDOS_0001")).getText();
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
