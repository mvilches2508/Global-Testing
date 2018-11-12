package cartera;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_Cartera_Recaudacion_Retomar {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new HtmlUnitDriver(true);
		baseUrl = "http://54.235.81.157/carteragx15/seclogin.aspx";
	}

	@Test
	public void testTCCarteraRecaudacionRetomar() throws Exception {
		Robot robot = new Robot();
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
		driver.get(baseUrl);
		Thread.sleep(8000);
		driver.findElement(By.id("vUSUARIONOMBRE")).clear();
		driver.findElement(By.id("vUSUARIONOMBRE")).sendKeys("mvalles");
		Thread.sleep(1000);
		driver.findElement(By.id("vUSUARIOPASSWORD")).clear();
		driver.findElement(By.id("vUSUARIOPASSWORD")).sendKeys("Mvll18.");
		Thread.sleep(1000);
		driver.findElement(By.id("BTNENTER")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//tr[3]/td/table/tbody/tr/td[2]/p/span/a")).click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Estado");
		Thread.sleep(10000);
		new Select(driver.findElement(By.id("vRECAUDACIONESTADO1"))).selectByVisibleText("INGRESADA");
		Thread.sleep(10000);
		driver.findElement(By.id("vRETOMARPASO2_0001")).click();
		Thread.sleep(3000);
		try {
			assertEquals(driver.findElement(By.id("TEXTBLOCKTITLE")).getText(), "Pagar Cuotas - Paso 2 de 3");
			System.out.println("Texto encontrado: Pagar Cuotas - Paso 2 de 3");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Thread.sleep(1000);
		driver.findElement(By.id("BTNSIGUIENTE")).click();
		Thread.sleep(6000);
		String montoPagar = driver.findElement(By.id("span_vTOTALAPAGAR")).getText();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("vFORMADEPAGOID"))).selectByVisibleText("Efectivo");
		Thread.sleep(3000);
		driver.findElement(By.id("vRECAUDACIONFORMADEPAGOMONTO")).clear();
		driver.findElement(By.id("vRECAUDACIONFORMADEPAGOMONTO")).sendKeys(montoPagar);
		Thread.sleep(1000);
		driver.findElement(By.id("AGREGAR")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("BTNCONFIRMAR")).click();
		Thread.sleep(3000);
		boolean ventanaConfirmacion = isElementPresent(By.xpath("//table[2]/tbody/tr/td/div/div/div/div"));
		if(ventanaConfirmacion==true){
			System.out.println("Ventana de confirmación generada");
		}else {
			System.out.println("Error al emitir ventana de confirmación");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("DVELOP_CONFIRMPANEL_BTNCONFIRMARContainer_SaveButton")).click();
		Thread.sleep(8000);
		try {
			assertEquals(driver.findElement(By.id("RECAUDACIONTITLE")).getText(), "Recaudaciones");
			System.out.println("Texto encontrado: Recaudaciones");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Thread.sleep(1000);
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