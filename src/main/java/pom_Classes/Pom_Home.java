package pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Home
{

	@FindBy(xpath = "//h5[text()='Elements']")
	private WebElement elementsLink;

	@FindBy(xpath = "//h5[text()='Widgets']")
	private WebElement widgetsLink;

	@FindBy(xpath = "(//div[@class='card-body'])[3]")
	private WebElement alertsLink;

	public Pom_Home(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public void clickOnElements()
	{
		elementsLink.click();
	}

	public void clickOnWidgets()
	{
		widgetsLink.click();
	}

	public void clickOnAlerts()
	{
		alertsLink.click();
	}
}
