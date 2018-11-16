package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TCCarteraNuevaRecaudacionPaso123 {
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
  public void testTCCarteraNuevaRecaudacionPaso123() throws Exception {
    driver.get(baseUrl + "/carteragx15/seclogin.aspx");
    driver.findElement(By.id("vUSUARIONOMBRE")).clear();
    driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
    driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
    driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
    driver.findElement(By.id("BTNENTER")).click();
    driver.findElement(By.xpath("//tr[2]/td/table/tbody/tr/td[2]/p/span/a")).click();
    new Select(driver.findElement(By.id("vCREESTADOCONTRATO"))).selectByVisibleText("VIGENTE");
    driver.findElement(By.id("BTNBUSCAR")).click();
    driver.findElement(By.id("vSELECCIONAR_0009")).click();
    new Select(driver.findElement(By.id("vRECAUDACIONOTROSID"))).selectByVisibleText("Otros");
    driver.findElement(By.name("selectAllCheckboxGridCuotas")).click();
    driver.findElement(By.id("BTNSIGUIENTE")).click();
    boolean ingresarFecha = isElementPresent(By.xpath("//tr[3]/td"));
    driver.findElement(By.id("vCREFCHPAGOREAL")).clear();
    driver.findElement(By.id("vCREFCHPAGOREAL")).sendKeys("16/11/18");
    driver.findElement(By.id("BTNENTER")).click();
    try {
      assertEquals(driver.getTitle(), "Pagar Cuotas - Paso 2");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String montoDesc1 = driver.findElement(By.id("span_vRECAUDACIONINTERESESMORAFINAL")).getText();
    driver.findElement(By.id("MODIFDESCINTERESES")).click();
    driver.findElement(By.id("vRECAUDACIONDESCINTERESESMORA")).clear();
    driver.findElement(By.id("vRECAUDACIONDESCINTERESESMORA")).sendKeys("35,20%");
    driver.findElement(By.id("MODIFDESCGASTOS")).click();
    String montoDesc2 = driver.findElement(By.id("span_vRECAUDACIONINTERESESMORAFINAL")).getText();
    driver.findElement(By.id("vRECAUDACIONDESCGASTOSCOBRANZA")).clear();
    driver.findElement(By.id("vRECAUDACIONDESCGASTOSCOBRANZA")).sendKeys("7,4");
    driver.findElement(By.id("MODIFDESCINTERESES")).click();
    String montoDesc3 = driver.findElement(By.id("span_vRECAUDACIONGASTOSCOBRANZAFINAL")).getText();
    driver.findElement(By.id("BTNSIGUIENTE")).click();
    try {
      assertEquals(driver.getTitle(), "Pagar Cuotas - Paso 3");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String totalAbonar = driver.findElement(By.id("span_vTOTALABONAR")).getText();
    new Select(driver.findElement(By.id("vFORMADEPAGOID"))).selectByVisibleText("Efectivo");
    driver.findElement(By.id("vRECAUDACIONFORMADEPAGOMONTO")).clear();
    driver.findElement(By.id("vRECAUDACIONFORMADEPAGOMONTO")).sendKeys("9275736");
    driver.findElement(By.id("AGREGAR")).click();
    driver.findElement(By.id("BTNCONFIRMAR")).click();
    boolean confirmarPagoCuotas = isElementPresent(By.xpath("//div/div/div/div[2]"));
    driver.findElement(By.id("DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer_SaveButton")).click();
    try {
      assertEquals(driver.getTitle(), "Recaudacion");
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
