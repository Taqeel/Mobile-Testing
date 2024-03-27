package myTestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.swing.JButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCases {

	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;
	
	Assertion myassert = new Assertion();
	


	@BeforeTest

	public void mySetup() {
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mobile One");
		
		File myApplicationCalaulator = new File("src/myApplications/calculator.apk");
		
		caps.setCapability(MobileCapabilityType.APP, myApplicationCalaulator.getAbsolutePath());

	}

	@Test(priority = 1 )

	public void myTest() throws MalformedURLException {
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		WebElement number9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		
		number9.click();
		
		WebElement Multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		
		Multiply.click();
		
		WebElement number5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		
		number5.click();
		
		WebElement results = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		
		results.click();
		
		myassert.assertNotEquals(results.getText(), 45 , "My first Test");
		
		
	}
	
	
	@Test(priority = 2)
	 
	public void preesonAllNumbersOnlyNumbers() {
		
		List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));
     
		for (int i = 0 ; i < allNumbers.size() ; i++ ) {
			
//			System.out.println((allNumbers.get(i).getAttribute("resource-id")));
			
			if(allNumbers.get(i).getAttribute("resource-id").contains("digit")) {
				allNumbers.get(i).click();
				
			}
			 
		}}
		
		@Test(priority = 3)
		 
		public void pressOnEvenNumbers() {
			
			List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));
			
	     
			for (int i = 0 ; i < allNumbers.size() ; i++ ) {
				
//				if (allButtons.get(i).getAttribute("resource-id").contains("digit_2")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_4")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_6")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_8")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_0")) {
//			allButtons.get(i).click(); 
//		} 
				
			
			if(allNumbers.get(i).getAttribute("resource-id").contains("digit")) {
				
				String EveNumber = allNumbers.get(i).getAttribute("content-desc");
				int NUM = Integer.parseInt(EveNumber);
				
				if (NUM % 2 == 0) {
					
					System.out.println(NUM);
					
					allNumbers.get(i).click();
				}
				
			}
				 
			}
			
			
	}
		@Test(priority = 4)
		 
		public void pressOnOddNumbers() {
			
			List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));
			
	     
			for (int i = 0 ; i < allNumbers.size() ; i++ ) {
				
//				if (allButtons.get(i).getAttribute("resource-id").contains("digit_2")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_4")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_6")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_8")
//				|| allButtons.get(i).getAttribute("resource-id").contains("digit_0")) {
//			allButtons.get(i).click(); 
//		} 
				
			
			if(allNumbers.get(i).getAttribute("resource-id").contains("digit")) {
				
				String EveNumber = allNumbers.get(i).getAttribute("content-desc");
				int NUM = Integer.parseInt(EveNumber);
				
				if (NUM % 2 != 0) {
					
					System.out.println(NUM);
					
					allNumbers.get(i).click();
				}
				
			}
				 
			}
			
			
	}




}


