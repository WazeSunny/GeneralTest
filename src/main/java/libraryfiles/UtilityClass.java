package libraryfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass
{
	/*
	 * To Fetch data from Property File.
	 */
	public static String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("F:\\Eclipse-Workspace\\SophosSolutions\\PropertyFile.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
	
	/*
	 *  To Capture Screenshot of failed TestCase
	 * */
	
	public static void captureScreenshot(WebDriver driver, String TestCaseName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F:\\Eclipse-Workspace\\SophosSolutions\\screenshot\\"+TestCaseName+".jpg"));
	}
}
