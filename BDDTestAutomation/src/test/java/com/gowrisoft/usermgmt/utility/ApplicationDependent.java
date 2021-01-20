package com.gowrisoft.usermgmt.utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ApplicationDependent {
	public static WebDriverWait wait=null;
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
	public static void waitForElement(WebDriver oBrowser,final By by)
	{
		try
		{
			Wait<WebDriver> wait=new FluentWait<WebDriver>(oBrowser)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			WebElement oEle=wait.until(new Function<WebDriver, WebElement>()
			{
				public WebElement apply(WebDriver driver)
				{
					return driver.findElement(by);
				}
			});
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
	public static void waitForTextPresent(WebDriver oBrowser,By by,String text)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(oBrowser,10);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
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
	public static void waitForTextPresentInElementValue(WebDriver oBrowser,By by,String text)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(oBrowser,10);
			wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
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
	public static void selectListItem(WebElement oEle,String itemName)
	{
		try
		{
			Select oSElect=new Select(oEle);
			oSElect.selectByVisibleText(itemName);
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
	public static boolean isObjectPresent(WebDriver oBrowser,By by)
	{
		boolean status=false;
		try
		{
			oBrowser.findElement(by);
			status=true;
		}catch(Exception e)
		{
			status=false;
		}
		return status;
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
	public static boolean isAlertPresent(WebDriver oBrowser)
	{
		boolean status=false;
		try
		{
			oBrowser.switchTo().alert();
			status=true;
		}catch(Exception e)
		{
			status=false;
		}
		return status;
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
	public static Alert getAlert(WebDriver oBrowser)
	{
		Alert oAlert=null;
		try
		{
			oAlert=oBrowser.switchTo().alert();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return oAlert;
	}
}
