package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraCreditosSeguimientoInteligente {
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
  public void testTCCarteraCreditosSeguimientoInteligente() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//span/a")).click();
    driver.findElement(By.id("ADDDYNAMICFILTERS1")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Tipo Crédito");
    driver.findElement(By.xpath("//option[10]")).click();
    new Select(driver.findElement(By.id("vSOLICITUDTIPOCREDITO1"))).selectByVisibleText("INTELIGENTE");
    driver.findElement(By.xpath("//select[4]/option[2]")).click();
    new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR2"))).selectByVisibleText("Estado Pago");
    driver.findElement(By.xpath("//tr[2]/td[2]/select/option[8]")).click();
    new Select(driver.findElement(By.id("vCREESTADOPAGO2"))).selectByVisibleText("AL DíA");
    driver.findElement(By.xpath("//tr[2]/td[4]/select[3]/option[2]")).click();
    driver.findElement(By.id("vINFOCLIENTE1_0001")).click();
    boolean registrarSeguimiento = isElementPresent(By.xpath("//tr[2]/td"));
    driver.findElement(By.id("REGISTRARSEGUIMIENTO")).click();
    new Select(driver.findElement(By.id("vTIPOGESTIONID"))).selectByVisibleText("Administrativa");
    new Select(driver.findElement(By.id("vTIPOCONTACTOID"))).selectByVisibleText("Administrativo");
    new Select(driver.findElement(By.id("vCAUSALNOPAGOID"))).selectByVisibleText("Gestion Administrativa");
    new Select(driver.findElement(By.id("vESTADOSEGUIMIENTOID"))).selectByVisibleText("Bienvenida Cliente");
    driver.findElement(By.id("vSEGCREDITOPROXIMAFECHA")).clear();
    driver.findElement(By.id("vSEGCREDITOPROXIMAFECHA")).sendKeys("191118");
    driver.findElement(By.id("vSEGCREDITOCOMENTARIO")).clear();
    driver.findElement(By.id("vSEGCREDITOCOMENTARIO")).sendKeys("Prueba de registrar seguimiento");
    driver.findElement(By.id("BTNENTER")).click();
    try {
      assertEquals(driver.getTitle(), "Créditos");
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
