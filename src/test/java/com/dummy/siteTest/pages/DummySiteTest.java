package com.dummy.siteTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummySiteTest {
	public String URL="Dummysite.com";
	
	@Test
	public void testSuccessfulLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys("pradipjaybhaye1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("pRAD079");
		driver.findElement(By.name("login")).click();
		
	   driver.wait(2000);
	
     String successMessageActual = driver.findElement(By.id("MessageBox")).getText() ;
     
     String expectedSuccessMessage= "Login Successful";
     Assert.assertEquals(successMessageActual, expectedSuccessMessage);
	}
	
	@Test 
	public void testFAiledLogin() throws InterruptedException
	{ 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.findElement(By.name("email")).sendKeys("WrongEmail@abc.com");
    driver.findElement(By.name("password")).sendKeys("wrong Password");	
	driver.findElement(By.name("login")).click();
	driver.wait(2000);
	String failureMessageActual = driver.findElement(By.id("MessageBox")).getText();
	String expectedFailureMessage= "Login Failure";
	Assert.assertEquals(failureMessageActual, expectedFailureMessage);
	}
	
	
	
	
	
	
	
	
	
	static public int add(int a, int b) {
		return a+b;
	}
	
	@Test
	public void testAddReturns8For3and5() {
		//setup
		int actual = add(3,5);
		int expected = 8;
		
		
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test
	public void testAddReturn9For4and5() {
		
		int actual  = add(4,5);
		int expected = 9;
		Assert.assertEquals(actual, expected);
	}


	static public int division(int c, int d) {
		return c/d;
	}
	@Test
	public void testDivisionTRetuern2For8and4() {
		int actual= division(8,4);
		int expected = 2;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testDivisionReturn3For12and4() {
		//setup
		
		int actual= division(12,4);
		int expected= 3;
		Assert.assertEquals(actual, expected);
	}
	
	
	
	
	
	
	
	
	

	
}
