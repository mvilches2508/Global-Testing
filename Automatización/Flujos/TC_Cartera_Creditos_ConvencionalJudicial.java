package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraCreditosConvencionalJudicial {
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
  public void testTCCarteraCreditosConvencionalJudicial() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//span/a")).click();
    String formulario = driver.findElement(By.id("CREDITOSTITLE")).getText();
    driver.findElement(By.id("ADDDYNAMICFILTERS1")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Tipo Crédito");
    new Select(driver.findElement(By.id("vSOLICITUDTIPOCREDITO1"))).selectByVisibleText("CONVENCIONAL");
    driver.findElement(By.xpath("//select[4]/option[3]")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR2"))).selectByVisibleText("Estado Pago");
    driver.findElement(By.xpath("//tr[2]/td[2]/select/option[8]")).click();
    new Select(driver.findElement(By.id("vCREESTADOPAGO2"))).selectByVisibleText("JUDICIAL");
    String op = driver.findElement(By.xpath("//tr[9]/td[3]/span/a")).getText();
    driver.findElement(By.id("vEDITARCONVENIDO_0009")).click();
    String estado1 = driver.findElement(By.id("span_SDTCONVENIDO__DETCREESTCUO_0005")).getText();
    driver.findElement(By.id("SDTCONVENIDO__DETCREFCHVENCUO_0005")).clear();
    driver.findElement(By.id("SDTCONVENIDO__DETCREFCHVENCUO_0005")).sendKeys("291118");
    String estado2 = driver.findElement(By.id("span_SDTCONVENIDO__DETCREESTCUO_0006")).getText();
    driver.findElement(By.id("SDTCONVENIDO__DETCREFCHVENCUO_0006")).clear();
    driver.findElement(By.id("SDTCONVENIDO__DETCREFCHVENCUO_0006")).sendKeys("291118");
    driver.findElement(By.id("BTNCONFIRMAR")).click();
    driver.findElement(By.id("vEDITARCONVENIDO_0009")).click();
    String estado3 = driver.findElement(By.id("span_SDTCONVENIDO__DETCREESTCUO_0005")).getText();
    String estado4 = driver.findElement(By.id("span_SDTCONVENIDO__DETCREESTCUO_0006")).getText();
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
