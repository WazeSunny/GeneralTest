package testClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import libraryfiles.BaseClass;
import libraryfiles.UtilityClass;
import pom_Classes.Pom_Alerts;
import pom_Classes.Pom_Home;

public class AlertsAndWindows extends BaseClass
{

	SoftAssert softassert;

	@BeforeClass
	public void openBrowser()
	{
		launchBrowser();
		home = new Pom_Home(driver);
		alerts = new Pom_Alerts(driver);
		softassert = new SoftAssert();
	}

	@Test(priority = 1)
	public void openAlertsSection()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		home.clickOnAlerts();
		alerts.clickOnAlertsSection();
	}

	@Test(priority = 2)
	public void handleAlert() throws InterruptedException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		alerts.clickOnAlertBtn();
		Alert alrt = driver.switchTo().alert();

		System.out.println(alrt.getText());
		alrt.accept();

	}

	@Test(priority = 3)
	public void handleTimerAlert() throws InterruptedException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		alerts.clickOnTimerAlertBtn();
		Thread.sleep(6000);
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
	}

	@Test(priority = 4)
	public void acceptConfirmAlert()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		alerts.clickOnConfirmAlertBtn();
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
	}

	@Test(dependsOnMethods = "acceptConfirmAlert")
	public void verifyAcceptConfirmAlert()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		softassert.assertEquals(alerts.verifyConfirmResult(), "You selected Ok");
	}

	@Test(priority = 4)
	public void dismissConfirmAlert()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		alerts.clickOnConfirmAlertBtn();
		Alert alrt = driver.switchTo().alert();
		alrt.dismiss();
	}

	@Test(dependsOnMethods = "dismissConfirmAlert")
	public void verifyDismissConfirmAlertResult()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		softassert.assertEquals(alerts.verifyConfirmResult(), "You selected Cancel");
	}

	@Test(priority = 5)
	public void handlePromptAlert()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		alerts.clickOnPromptAlertBtn();
		Alert alrt = driver.switchTo().alert();
		alrt.sendKeys("Sunny");
		alrt.accept();
	}
	
	@Test(dependsOnMethods = "handlePromptAlert")
	public void verifyPromptAlertResult() throws IOException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		softassert.assertEquals(alerts.verifyPromptResult(), "You entered "+UtilityClass.getDataFromPropertyFile("AlertTestData"));
	}
	
	@AfterMethod
	public void captureFailedTestCase(ITestResult Result) throws IOException
	{
		if (Result.getStatus() == ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TestCaseName);
		}
	}

	@AfterClass
	public void exports()
	{
		softassert.assertAll();
		driver.quit();
	}
}
