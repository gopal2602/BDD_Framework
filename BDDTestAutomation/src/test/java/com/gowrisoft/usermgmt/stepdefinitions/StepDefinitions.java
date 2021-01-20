package com.gowrisoft.usermgmt.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.gowrisoft.usermgmt.App;
import com.gowrisoft.usermgmt.pages.GowriSoftPages;
import com.gowrisoft.usermgmt.utility.ApplicationDependent;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	public static WebDriver oBrowser=null;
	public static GowriSoftPages oPages=null;
	public static String email=null;
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("^I launch the application$")
	public void I_launch_the_application()
	{
		try
		{
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oPages=new GowriSoftPages(oBrowser);
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I navigate to the url of the application$")
	public void I_navigate_to_the_url_of_the_application(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String url=data.get(0).get("url");
			oBrowser.navigate().to(url);
			final By by=By.linkText("Sign up");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("I login using valid credentials")
	public void I_login_using_valid_credentials(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String username=data.get(0).get("username");
			String password=data.get(0).get("password");
			oPages.getLoginEmail().sendKeys(username);
			oPages.getLoginPassword().sendKeys(password);
			oPages.getCreateAction().click();
			final By by=By.xpath("//h1[text()='Welcome To ']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("the Home page should display")
	public void the_Home_page_should_display()
	{
		try
		{
			By by=By.xpath("//h1[text()='Welcome To ']");
			boolean status = ApplicationDependent.isObjectPresent(oBrowser, by);
			Assert.assertTrue(status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("I click on Users tab")
	public void I_click_on_Users_tab()
	{
		try
		{
			oPages.getUsersTab().click();
			final By by=By.xpath("//a[text()='New User']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on New User button$")
	public void I_click_on_New_User_button()
	{
		try
		{
			oPages.getNewUser().click();
			final By by=By.xpath("//h1[text()='New User']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("^I enter all mandatory fields$")
	public void I_enter_all_mandatory_fields(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String firstname=data.get(0).get("firstname");
			String lastname=data.get(0).get("lastname");
			email=data.get(0).get("email");
			String phoneno=data.get(0).get("phonenumber");
			String address=data.get(0).get("address");
			String state=data.get(0).get("state");
			String zipcode=data.get(0).get("zipcode");
			oPages.getFirstName().sendKeys(firstname);
			oPages.getLastName().sendKeys(lastname);
			oPages.getUserEmail().sendKeys(email);
			oPages.getUserPhone().sendKeys(phoneno);
			oPages.getUserAddress().sendKeys(address);
			ApplicationDependent.selectListItem(oPages.getUserState(), state);
			oPages.getUserZipcode().sendKeys(zipcode);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on Create User button$")
	public void I_click_on_Create_User_button()
	{
		try
		{
			oPages.getCreateAction().click();
			final By by=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful user creation message$")
	public void I_get_a_successful_user_creation_message()
	{
		try
		{
			String expectedResult="User was successfully created.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("^I click on back button$")
	public void I_click_on_back_button()
	{
		try
		{
			oPages.getBackPage().click();
			By by=By.xpath("//td[text()='"+email+"']/following-sibling::td[7]/a");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on destroy button$")
	public void I_click_on_destroy_button()
	{
		try
		{
			By by=By.xpath("//td[text()='"+email+"']/following-sibling::td[7]/a");
			oBrowser.findElement(by).click();
			boolean status=ApplicationDependent.isAlertPresent(oBrowser);
			if(status==true)
			{
				ApplicationDependent.getAlert(oBrowser).accept();
			}
			final By by1=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForTextPresent(oBrowser, by1, "User was successfully destroyed.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful user deletion message$")
	public void I_get_a_successful_user_deletion_message()
	{
		try
		{
			String expectedResult="User was successfully destroyed.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("^I click on Logout button$")
	public void I_click_on_Logout_button()
	{
		try
		{
			oPages.getLogout().click();
			final By by=By.linkText("Sign up");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I find the login page$")
	public void I_find_the_login_page()
	{
		try
		{
			String expectedresult="Gowri Soft";
			String actualResult=oBrowser.getTitle();
			Assert.assertEquals(expectedresult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("^I click on edit button$")
	public void I_click_on_edit_button()
	{
		try
		{
			oPages.getEditButton().click();
			final By by=By.xpath("//h1[text()='Editing User']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("^I update the user$")
	public void I_update_the_user(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String firstname=data.get(0).get("firstname");
			String lastname=data.get(0).get("lastname");
			email=data.get(0).get("email");
			String phoneno=data.get(0).get("phonenumber");
			String address=data.get(0).get("address");
			String state=data.get(0).get("state");
			String zipcode=data.get(0).get("zipcode");
			oPages.getFirstName().clear();
			oPages.getFirstName().sendKeys(firstname);
			oPages.getLastName().clear();
			oPages.getLastName().sendKeys(lastname);
			oPages.getUserEmail().clear();
			oPages.getUserEmail().sendKeys(email);
			oPages.getUserPhone().clear();
			oPages.getUserPhone().sendKeys(phoneno);
			oPages.getUserAddress().clear();
			oPages.getUserAddress().sendKeys(address);
			ApplicationDependent.selectListItem(oPages.getUserState(), state);
			oPages.getUserZipcode().clear();
			oPages.getUserZipcode().sendKeys(zipcode);
			oPages.getCreateAction().click();
			final By by=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful user updation message$")
	public void I_get_a_successful_user_updation_message()
	{
		try
		{
			String expectedResult="User was successfully updated.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I close the Application$")
	public void I_close_the_Application()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("I click on Companies tab")
	public void I_click_on_Companies_tab()
	{
		try
		{
			oPages.getCompaniesTab().click();
			final By by=By.xpath("//a[text()='New Company']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on New Company button$")
	public void I_click_on_New_Company_button()
	{
		try
		{
			oPages.getNewCompany().click();
			final By by=By.xpath("//h1[text()='New Company']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("^I enter all mandatory fields for company$")
	public void I_enter_all_mandatory_fields_for_company(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String name=data.get(0).get("name");
			email=data.get(0).get("email");
			String phoneno=data.get(0).get("phonenumber");
			String address=data.get(0).get("address");

			oPages.getCompanyName().sendKeys(name);
			oPages.getCompanyEmail().sendKeys(email);
			oPages.getCompanyPhone().sendKeys(phoneno);
			oPages.getCompanyAddress().sendKeys(address);
			By by=By.xpath("//input[@value='Create Company']");
			ApplicationDependent.waitForTextPresentInElementValue(oBrowser, by, "Create Company");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on Create Company button$")
	public void I_click_on_Create_Company_button()
	{
		try
		{
		//	oPages.getCreateAction().click();
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("arguments[0].click();", oPages.getCreateAction());
			final By by=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful company creation message$")
	public void I_get_a_successful_company_creation_message()
	{
		try
		{
			String expectedResult="Company was successfully created.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@And("^I click on destroy button for company$")
	public void I_click_on_destroy_button_for_company()
	{
		try
		{
			By by=By.xpath("//td[text()='"+email+"']/following-sibling::td[5]/a");
			oBrowser.findElement(by).click();
			boolean status=ApplicationDependent.isAlertPresent(oBrowser);
			if(status==true)
			{
				ApplicationDependent.getAlert(oBrowser).accept();
			}
			final By by1=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForTextPresent(oBrowser, by1, "Company was successfully destroyed.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful company deletion message$")
	public void I_get_a_successful_company_deletion_message()
	{
		try
		{
			String expectedResult="Company was successfully destroyed.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@When("^I update the company$")
	public void I_update_the_company(DataTable credentials)
	{
		try
		{
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			String name=data.get(0).get("name");
			email=data.get(0).get("email");
			String phoneno=data.get(0).get("phonenumber");
			String address=data.get(0).get("address");

			oPages.getCompanyName().clear();
			oPages.getCompanyName().sendKeys(name);
			oPages.getCompanyEmail().clear();
			oPages.getCompanyEmail().sendKeys(email);
			oPages.getCompanyPhone().clear();
			oPages.getCompanyPhone().sendKeys(phoneno);
			oPages.getCompanyAddress().clear();
			oPages.getCompanyAddress().sendKeys(address);
		//	oPages.getCreateAction().click();
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("arguments[0].click();", oPages.getCreateAction());
			final By by=By.xpath("//p[@id='notice']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Then("^I get a successful company updation message$")
	public void I_get_a_successful_company_updation_message()
	{
		try
		{
			String expectedResult="Company was successfully updated.";
			String actualResult=oPages.getStatusMessage().getText();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("^I click on back button for company$")
	public void I_click_on_back_button_for_company()
	{
		try
		{
			oPages.getBackPage().click();
			By by=By.xpath("//td[text()='"+email+"']/following-sibling::td[5]/a");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	@Given("^I click on edit button for company$")
	public void I_click_on_edit_button_for_company()
	{
		try
		{
			oPages.getEditButton().click();
			final By by=By.xpath("//h1[text()='Editing Company']");
			ApplicationDependent.waitForElement(oBrowser, by);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
