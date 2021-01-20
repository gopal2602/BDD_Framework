package com.gowrisoft.usermgmt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GowriSoftPages {
	
	public GowriSoftPages(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}
	
	/**
	 * Email Text field WebElement
	 */
	private WebElement student_email;
	public WebElement getLoginEmail()
	{
		return student_email;
	}
	
	/**
	 * Password Text field WebElement
	 */
	private WebElement student_password;
	public WebElement getLoginPassword()
	{
		return student_password;
	}
	
	/**
	 * Login button WebElement
	 */
	private WebElement commit;
	public WebElement getCreateAction()
	{
		return commit;
	}
	
	/**
	 * Users tab WebElement
	 */
	@FindBy(xpath="//a[text()='Users']")
	private WebElement oUsers;
	public WebElement getUsersTab()
	{
		return oUsers;
	}
	
	/**
	 * New User Button WebElement
	 */
	@FindBy(xpath="//a[text()='New User']")
	private WebElement oNewUser;
	public WebElement getNewUser()
	{
		return oNewUser;
	}
	
	/**
	 * First Name Text field WebElement
	 */
	private WebElement user_first_name;
	public WebElement getFirstName()
	{
		return user_first_name;
	}
	
	/**
	 * Last Name Text field WebElement
	 */
	private WebElement user_last_name;
	public WebElement getLastName()
	{
		return user_last_name;
	}
	
	/**
	 * User Email Text field WebElement
	 */
	private WebElement user_email;
	public WebElement getUserEmail()
	{
		return user_email;
	}
	
	/**
	 * User Phone Text field WebElement
	 */
	private WebElement user_phone_number;
	public WebElement getUserPhone()
	{
		return user_phone_number;
	}
	
	/**
	 * User Address Text field WebElement
	 */
	private WebElement user_address;
	public WebElement getUserAddress()
	{
		return user_address;
	}
	
	/**
	 * User State Select field WebElement
	 */
	private WebElement user_state;
	public WebElement getUserState()
	{
		return user_state;
	}
	
	/**
	 * User ZipCode Text field WebElement
	 */
	private WebElement user_zipcode;
	public WebElement getUserZipcode()
	{
		return user_zipcode;
	}
	
	/**
	 * Status Text WebElement
	 */
	@FindBy(xpath="//p[@id='notice']")
	private WebElement oStatusMessage;
	public WebElement getStatusMessage()
	{
		return oStatusMessage;
	}
	
	/**
	 * Back Button field WebElement
	 */
	@FindBy(linkText="Back")
	private WebElement backpage;
	public WebElement getBackPage()
	{
		return backpage;
	}
	
	/**
	 * Logout Button WebElement
	 */
	@FindBy(xpath="//div[@id='nav']/a[5]")
	private WebElement logout;
	public WebElement getLogout()
	{
		return logout;
	}
	
	
	/**
	 * Edit Button WebElement
	 */
	@FindBy(linkText="Edit")
	private WebElement oEdit;
	public WebElement getEditButton()
	{
		return oEdit;
	}
	
	/**
	 * Companies tab WebElement
	 */
	@FindBy(xpath="//a[text()='Companies']")
	private WebElement oCompanies;
	public WebElement getCompaniesTab()
	{
		return oCompanies;
	}
	
	/**
	 * New Company Button WebElement
	 */
	@FindBy(xpath="//a[text()='New Company']")
	private WebElement oNewCompany;
	public WebElement getNewCompany()
	{
		return oNewCompany;
	}
	
	/**
	 * Name Text field WebElement
	 */
	private WebElement company_name;
	public WebElement getCompanyName()
	{
		return company_name;
	}
	
	/**
	 * Company Email Text field WebElement
	 */
	private WebElement company_email;
	public WebElement getCompanyEmail()
	{
		return company_email;
	}
	
	/**
	 * Company Phone Text field WebElement
	 */
	private WebElement company_phone_number;
	public WebElement getCompanyPhone()
	{
		return company_phone_number;
	}
	
	/**
	 * Company Address Text field WebElement
	 */
	private WebElement company_address;
	public WebElement getCompanyAddress()
	{
		return company_address;
	}
}
