package cartera;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TC_Cartera_Creditos_SeguimientoLeasing {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"src/cartera/driver/phantomjs.exe");
		driver = new PhantomJSDriver(capabilities);
		baseUrl = "http://54.235.81.157/carteragx15/seclogin.aspx";
	}

	public void testTCCarteraCreditosSeguimientoLeasing() throws Exception {
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
		driver.findElement(By.xpath("//span/a")).click();
		Thread.sleep(10000);
		boolean simbolo = isElementPresent(By.id("ADDDYNAMICFILTERS1"));
		if (simbolo == true) {
			System.out.println("Accede al menú Créditos");
		} else {
			System.out.println("No accede al menú Créditos");
		}
		driver.findElement(By.id("ADDDYNAMICFILTERS1")).click();
		Thread.sleep(20000);
		new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR1"))).selectByVisibleText("Tipo Crédito");
		Thread.sleep(15000);
		new Select(driver.findElement(By.id("vSOLICITUDTIPOCREDITO1"))).selectByVisibleText("LEASING");
		Thread.sleep(10000);
		new Select(driver.findElement(By.id("vDYNAMICFILTERSSELECTOR2"))).selectByVisibleText("Estado Pago");
		Thread.sleep(15000);
		new Select(driver.findElement(By.id("vCREESTADOPAGO2"))).selectByVisibleText("VENCIDO");
		Thread.sleep(10000);
		boolean boton = isElementPresent(By.id("vINFOCLIENTE1_0001"));
		if (boton == true) {
			System.out.println("Apertura de ventana para registrar seguimiento");
			driver.findElement(By.id("vINFOCLIENTE1_0001")).click();
			Thread.sleep(15000);
		} else {
			System.out.println("Error al acceder a ventana de registro de seguimiento");
		}
		driver.switchTo().frame(driver.findElement(By.id("gxp0_ifrm")));
		boolean registrarSeguimiento = isElementPresent(By.xpath("//*[@id=\"vIMGCLIENTE\"]"));
		if (registrarSeguimiento == true) {
			System.out.println("Se procede a registrar seguimiento");
			driver.findElement(By.id("REGISTRARSEGUIMIENTO")).click();
			Thread.sleep(15000);
			driver.switchTo().defaultContent();
		} else {
			System.out.println("Error al registrar seguimiento");
		}
		driver.switchTo().frame(driver.findElement(By.id("gxp1_ifrm")));
		new Select(driver.findElement(By.id("vTIPOGESTIONID"))).selectByVisibleText("Carta");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("vTIPOCONTACTOID"))).selectByVisibleText("Sin Contacto");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("vCAUSALNOPAGOID"))).selectByVisibleText("No contesta");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("vESTADOSEGUIMIENTOID"))).selectByVisibleText("Volver a Llamar");
		Thread.sleep(1000);
		SimpleDateFormat dia = new SimpleDateFormat("dd");
		SimpleDateFormat mes = new SimpleDateFormat("MM");
		SimpleDateFormat anno = new SimpleDateFormat("yy");
		String diaActual = dia.format(new Date());
		String mesActual = mes.format(new Date());
		String annoActual = anno.format(new Date());
		int diaHoy = Integer.parseInt(diaActual);
		int mesHoy = Integer.parseInt(mesActual);
		int annoHoy = Integer.parseInt(annoActual);
		System.out.println("Se ingresa fecha: " + diaHoy + "/" + mesHoy + "/" + annoHoy);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('vSEGCREDITOPROXIMAFECHA').value=" + diaHoy + "+'/'+" + mesActual
				+ "+'/'+" + annoActual + ";");
		Thread.sleep(1000);
		driver.findElement(By.id("vSEGCREDITOCOMENTARIO")).clear();
		driver.findElement(By.id("vSEGCREDITOCOMENTARIO")).sendKeys("Seguimiento Leasing");
		Thread.sleep(1000);
		driver.findElement(By.id("BTNENTER")).click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		try {
			assertEquals(driver.getTitle(), "Créditos");
			System.out.println("Registro de seguimiento de manera exitosa");
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