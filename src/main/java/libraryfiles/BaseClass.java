package libraryfiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Classes.Pom_Alerts;
import pom_Classes.Pom_Elements;
import pom_Classes.Pom_Home;
import pom_Classes.Pom_Widgets;

public class BaseClass
{
	//Instantiation of Classes
		public WebDriver driver;
		public ExtentReports extent;
		public ExtentSparkReporter spark;
		
		//POM Class Instances
		public Pom_Home home;
		public Pom_Widgets widgets;
		public Pom_Alerts alerts;
		public Pom_Elements elements;
		
		//Global Variables 
		public String TestCaseName;
		public String authorName= "Sunny";
		public String testingType = "Functional Testing";

		public void launchBrowser()
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
}
