package pom_Classes;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

public class Pom_Widgets
{
	public Pom_Widgets(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	//Date Month Year Container Elements
	@FindBy(xpath = "//li[@id='item-2']/span[text()='Date Picker']")
	private WebElement datePickerLink;

	@FindBy(id = "datePickerMonthYearInput")
	private WebElement datePickerInput;

	@FindBy(className = "react-datepicker__month-select")
	private WebElement month;

	@FindBy(className = "react-datepicker__year-select")
	private WebElement year;

	@FindBy(xpath = "//div[@class='react-datepicker__month']//div[@role='option']")
	private List<WebElement> datesOptions;

	//Date and Time Picker Container Elements
	@FindBy(id = "dateAndTimePickerInput")
	private WebElement dateAndTimePickerInput;

	@FindBy(xpath = "(//div[@class='react-datepicker__header']//span)[2]")
	private WebElement selectedMonth;

	@FindBy(xpath = "(//div[@class='react-datepicker__header']//span)[4]")
	private WebElement selectedYear;

	@FindBy(xpath = "//div[@class='react-datepicker__month']//div[@role]")
	private List<WebElement> dateOptions;

	@FindBy(xpath = "//div[@class='react-datepicker__month-option']")
	private List<WebElement> monthList;

	@FindBy(xpath = "//div[@class='react-datepicker__year-dropdown']//div[@class='react-datepicker__year-option']")
	private List<WebElement> yearList;

	@FindBy(xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming']")
	private WebElement nextLink;

	@FindBy(xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous']")
	private WebElement prevLink;
	
	@FindBy(xpath="//div[@class='react-datepicker__time-box']//ul/li")
	private List<WebElement> timeList;

	/*
	 * Date Picker Container Methods
	 */

	public void clickOnDatePickerSection()
	{
		datePickerLink.click();
	}

	public void clickOnDateInput()
	{
		datePickerInput.click();
	}

	public boolean VerifyDatePicker()
	{
		return datePickerInput.isEnabled();
	}
	public void enterDate(WebDriver d, String date)
	{
		Actions act = new Actions(d);
		for (int i = 1; i <= 10; i++)
		{
			act.sendKeys(Keys.BACK_SPACE).perform();
		}
		act.sendKeys(date).sendKeys(Keys.ENTER).build().perform();
	}
	
	/*
	 * Date and Time Picker Container Methods
	 */
	
	public void clickOnDateAndTimeInput()
	{
		dateAndTimePickerInput.click();
	}
	
	public void enterDateAndTime(WebDriver d, String dateAndTime)
	{
		Actions act = new Actions(d);
		for (int i = 1; i <= 26; i++)
		{
			act.sendKeys(Keys.BACK_SPACE).perform();
		}
		act.sendKeys(dateAndTime).sendKeys(Keys.ENTER).build().perform();
	}
	
	public boolean VerifyDateAndTimePicker()
	{
		return dateAndTimePickerInput.isEnabled();
	}
	
}
