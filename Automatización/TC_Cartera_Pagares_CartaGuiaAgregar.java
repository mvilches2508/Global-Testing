package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraPagaresCartaGuiaAgregar {
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
  public void testTCCarteraPagaresCartaGuiaAgregar() throws Exception {
    driver.get(baseUrl + "/carteratest/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Evo3.");
    driver.findElement(By.name("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[8]/td/table/tbody/tr/td[2]/p/span/a")).click();
    driver.findElement(By.id("INSERTARCARTAGUIAPAGARE")).click();
    new Select(driver.findElement(By.id("vUBICACIONESPAGARES"))).selectByVisibleText("Banco Itau");
    new Select(driver.findElement(By.id("vINVERSIONISTA"))).selectByVisibleText("No Aplica");
    new Select(driver.findElement(By.id("vUBICACIONESPAGAREFISICAID"))).selectByVisibleText("Itau");
    new Select(driver.findElement(By.id("vMOTIVOTRASLADOID"))).selectByVisibleText("N/A");
    driver.findElement(By.name("BTNENTER")).click();
    driver.findElement(By.id("vAGREGARPAGARE_0001")).click();
    driver.findElement(By.id("vAGREGARPAGARE_0001")).click();
    driver.findElement(By.id("vAGREGARPAGARE_0001")).click();
    String nomina = driver.findElement(By.id("span_vCARTAGUIANOMINA")).getText();
    driver.findElement(By.name("BTNCANCELAR")).click();
    driver.findElement(By.xpath("//td[10]/span/a")).click();
    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/span/a")).click();
    driver.findElement(By.xpath("//td[2]/span/a")).click();
    driver.findElement(By.id("vVERCARTAGUIAPAGARE_0001")).click();
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
