package testClasses;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import libraryfiles.BaseClass;
import libraryfiles.UtilityClass;
import pom_Classes.Pom_Alerts;
import pom_Classes.Pom_Elements;
import pom_Classes.Pom_Home;

public class WebTable extends BaseClass
{

	SoftAssert softassert;
	
	@BeforeClass
	public void openBrowser()
	{
		launchBrowser();
		home = new Pom_Home(driver);
		alerts = new Pom_Alerts(driver);
		elements = new Pom_Elements(driver);
		softassert = new SoftAssert();
	}
	
	@Test(priority = 0)
	public void openWebTableSection()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		home.clickOnElements();
		elements.clickOnWebTablesSection();
	}
	
	@Test(priority = 1)
	public void verifyAddBtn()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		softassert.assertTrue(elements.verifyEnabledAddBtn(),"Add Button is not enabled");
	}
	
	@Test(dependsOnMethods = "verifyAddBtn")
	public void openRegistrationForm()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		elements.clickOnAddBtn();
	}
	
	@Test(priority = 2)
	public void verifyRegFields()
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		softassert.assertTrue(elements.verifyEnabledFirstName(),"Firstname is not enabled");
		softassert.assertTrue(elements.verifyEnabledLastName(),"Lastname is not enabled");
		softassert.assertTrue(elements.verifyEnabledEmail(),"EMail is not enabled");
		softassert.assertTrue(elements.verifyEnabledAge(),"Age is not enabled");
		softassert.assertTrue(elements.verifyEnabledSalary(),"Salary is not enabled");
		softassert.assertTrue(elements.verifyEnabledDept(),"Department is not enabled");
		softassert.assertTrue(elements.verifySubmitBtn(),"Submit Button is not enabled");
		
	}
	
	@Test(dependsOnMethods = "verifyRegFields")
	public void addNewRecord() throws IOException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		elements.enterFirstName(UtilityClass.getDataFromPropertyFile("WebTableFirstname"));
		elements.enterLastName(UtilityClass.getDataFromPropertyFile("WebTableLastname"));
		elements.enterEmail(UtilityClass.getDataFromPropertyFile("WebTableEmail"));
		elements.enterAge(UtilityClass.getDataFromPropertyFile("WebTableAge"));
		elements.enterSalary(UtilityClass.getDataFromPropertyFile("WebTableSalary"));
		elements.enterDepartment(UtilityClass.getDataFromPropertyFile("WebTableDepartment"));
		elements.clickonSubmitBtn();
	}
	
	@Test(priority = 3)
	public void verifyRecord() throws IOException
	{
		TestCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		String actualFname = elements.getFirstName();
		String expectedFname = UtilityClass.getDataFromPropertyFile("WebTableFirstname");
		softassert.assertTrue(actualFname.equals(expectedFname),"Fname is not matching.");
		
		String actualLname = elements.getLastName();
		String expectedLname = UtilityClass.getDataFromPropertyFile("WebTableLastname");
		softassert.assertTrue(actualLname.equals(expectedLname),"Lname is not matching.");
		
		String actualEmail = elements.getEmail();
		String expectedEmail = UtilityClass.getDataFromPropertyFile("WebTableEmail");
		softassert.assertTrue(actualEmail.equals(expectedEmail),"Email is not matching.");
		
		String actualAge = elements.getAge();
		String expectedAge = UtilityClass.getDataFromPropertyFile("WebTableAge");
		softassert.assertTrue(actualAge.equals(expectedAge),"Age is not matching.");
		
		String actualSalary = elements.getSalary();
		String expectedSalary = UtilityClass.getDataFromPropertyFile("WebTableSalary");
		softassert.assertTrue(actualSalary.equals(expectedSalary),"Salary is not matching.");
		
		String actualDept = elements.getDept();
		String expectedDept = UtilityClass.getDataFromPropertyFile("WebTableDepartment");
		softassert.assertTrue(actualDept.equals(expectedDept),"Dept is not matching.");
	}
	
	@Test(priority = 4)
	public void deleteRecord()
	{
		elements.clickOnDeleteBtn();
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
