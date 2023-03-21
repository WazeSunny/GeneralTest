package pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Alerts
{

	public Pom_Alerts(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	
	//List of Elements for Alerts
	@FindBy(xpath = "//span[text()='Alerts']")
	private WebElement alertsSection;
	
	@FindBy(id = "alertButton")
	private WebElement alertBtn;
	
	@FindBy(id = "timerAlertButton")
	private WebElement timerAlertBtn;
	
	@FindBy(id = "confirmButton")
	private WebElement confirmAlertBtn;
	
	@FindBy(id = "promtButton")
	private WebElement promptAlertBtn;
	
	@FindBy(id = "promptResult")
	private WebElement promptResult;

	@FindBy(id = "confirmResult")
	private WebElement confirmResult;
	
	public void clickOnAlertsSection()
	{
		alertsSection.click();
	}

	public void clickOnAlertBtn()
	{
		alertBtn.click();
	}
	
	public void clickOnTimerAlertBtn()
	{
		timerAlertBtn.click();
	}
	
	public void clickOnConfirmAlertBtn()
	{
		confirmAlertBtn.click();
	}
	
	public void clickOnPromptAlertBtn()
	{
		promptAlertBtn.click();
	}
	
	public String verifyConfirmResult()
	{
		String result = confirmResult.getText();
		return result;
	}
	
	public String verifyPromptResult()
	{
		String result = promptResult.getText();
		return result;
	}
	
	
}
