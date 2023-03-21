package pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Elements
{
	
	public Pom_Elements(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	//WebTable Elements
	@FindBy(xpath = "(//li[@id='item-3'])[1]")
	private WebElement WebTable;
	
	@FindBy(id = "addNewRecordButton")
	private WebElement AddBtn;

	//Registration Form Elements
	@FindBy(id = "firstName")
	private WebElement RegIptFirstName;

	@FindBy(id = "lastName")
	private WebElement RegIptLastName;

	@FindBy(id = "userEmail")
	private WebElement RegIptEmail;

	@FindBy(id = "age")
	private WebElement RegIptAge;

	@FindBy(id = "salary")
	private WebElement RegIptSalary;

	@FindBy(id = "department")
	private WebElement RegIptDepartment;

	@FindBy(id = "submit")
	private WebElement submitBtn;
	
	//Added Records
	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[22]")
	private WebElement TCFname;
	
	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[23]")
	private WebElement TCLname;

	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[24]")
	private WebElement TCAge;
	
	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[25]")
	private WebElement TCEmail;
	
	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[26]")
	private WebElement TCSalary;
	
	@FindBy(xpath="(//div[@class='rt-table']//div[@class='rt-td'])[27]")
	private WebElement TCDept;
	
	@FindBy(id="delete-record-4")
	private WebElement deleteBtn;
	
	public void clickOnWebTablesSection()
	{
		WebTable.click();
	}

	public void clickOnAddBtn()
	{
		AddBtn.click();
	}

	public void enterFirstName(String FName)
	{
		RegIptFirstName.sendKeys(FName);
	}

	public void enterLastName(String LName)
	{
		RegIptLastName.sendKeys(LName);
	}

	public void enterEmail(String Email)
	{
		RegIptEmail.sendKeys(Email);
	}

	public void enterAge(String age)
	{
		RegIptAge.sendKeys(age);
	}

	public void enterSalary(String salary)
	{
		RegIptSalary.sendKeys(salary);
	}

	public void enterDepartment(String dept)
	{
		RegIptDepartment.sendKeys(dept);
	}

	public void clickonSubmitBtn()
	{
		submitBtn.click();
	}
	
	public void clickOnDeleteBtn()
	{
		deleteBtn.click();
	}
	
	//Verify Status Methods
	
	public boolean verifyEnabledAddBtn()
	{
		boolean status = AddBtn.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledFirstName()
	{
		boolean status = RegIptFirstName.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledLastName()
	{
		boolean status = RegIptLastName.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledEmail()
	{
		boolean status = RegIptEmail.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledAge()
	{
		boolean status = RegIptAge.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledSalary()
	{
		boolean status = RegIptSalary.isEnabled();
		return status;
	}
	
	public boolean verifyEnabledDept()
	{
		boolean status = RegIptDepartment.isEnabled();
		return status;
	}
	
	public boolean verifySubmitBtn()
	{
		boolean status = submitBtn.isEnabled();
		return status;
	}
	
	//Fetch Data from WebTable
	public String getFirstName()
	{
		String value = TCFname.getText();
		return value;
	}
	public String getLastName()
	{
		String value = TCLname.getText();
		return value;
	}
	public String getEmail()
	{
		String value = TCEmail.getText();
		return value;
	}
	public String getAge()
	{
		String value = TCAge.getText();
		return value;
	}
	public String getSalary()
	{
		String value = TCSalary.getText();
		return value;
	}
	public String getDept()
	{
		String value = TCDept.getText();
		return value;
	}

	
	
}
