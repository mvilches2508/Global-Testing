package cartera;

import org.testng.annotations.*;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_Cartera_Recaudacion_ExportarExcel {
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
	public void testTCCarteraRecaudacionExportarExcel() throws Exception {
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
		boolean btnExportarExcel = isElementPresent(By.id("EXPORT"));
		if(btnExportarExcel==true) {
			System.out.println("Se procede a descargar archivo excel");
		}else {
			System.out.println("Ejecución interrumpida debido a timeout");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("EXPORT")).click();
		Thread.sleep(30000);
		//driver.manage().getCookieNamed(arg0)
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
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