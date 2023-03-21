package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import libraryfiles.BaseClass;
import libraryfiles.UtilityClass;
import pom_Classes.Pom_Home;
import pom_Classes.Pom_Widgets;

public class DatePicker extends BaseClass
{

	SoftAssert softassert;
	
	@BeforeClass
	public void OpenBrowser()
	{
		launchBrowser();
		home = new Pom_Home(driver);
		widgets = new Pom_Widgets(driver);
		softassert = new SoftAssert();
	}
	
	@Test(priority=0)
	public void openDatePickerSection()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		home.clickOnWidgets();
		widgets.clickOnDatePickerSection();
	}
	
	//Verify Date Picker Input Enabled
	@Test(priority=1)
	public void verifyDateInput()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		Assert.assertTrue(widgets.VerifyDatePicker(), "The Date Picker is not enabled.");
	}
	@Test(dependsOnMethods= "verifyDateInput")
	public void handleDatePicker() throws IOException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		widgets.clickOnDateInput();
		widgets.enterDate(driver, UtilityClass.getDataFromPropertyFile("DatePickerDate"));
	}

	//Verify Date And Time Picker Input Enabled
	@Test(priority=3)
	public void verifyDateAndTimeInput()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		Assert.assertTrue(widgets.VerifyDateAndTimePicker(), "The Date And Time Picker is not enabled.");
	}
	
	@Test(dependsOnMethods= "verifyDateAndTimeInput")
	public void handleDateAndTimePicker() throws IOException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		widgets.clickOnDateAndTimeInput();
		widgets.enterDateAndTime(driver, UtilityClass.getDataFromPropertyFile("DateAndTime"));
	}
	
	@AfterMethod
	public void captureFailedTestCase(ITestResult Result) throws IOException 
	{
		if(Result.getStatus() == ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TestCaseName);
		}

	}

}
