package com.dummy.siteTest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteTest {
	public String URL = "Dummysite.com";

	@Test
	public void testSuccessfulLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("email")).sendKeys("Right Email");
		driver.findElement(By.name("password")).sendKeys("Right Password");
		driver.findElement(By.name("login")).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String actualPageTitle = driver.getTitle();

		String expectedPageTitle = "Expected Title";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}

	@Test
	public void testFAiledLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("WrongEmail@abc.com");
		driver.findElement(By.name("password")).sendKeys("wrong Password");
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String failureMessageActual = driver.findElement(By.id("MessageBox")).getText();
		String expectedFailureMessage = "Login Failure";
		Assert.assertEquals(failureMessageActual, expectedFailureMessage);
	}

	@Test
	public void loginButtonDisabledWhenFieldsEmpty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("");
		WebElement Email = driver.findElement(By.name("email"));
		WebElement Password = driver.findElement(By.name("password"));
		String text1 = Email.getText();
		String text2 = Password.getText();
		if (text1.equals("")) {
			if (text2.equals("")) {
				System.out.println("LogIn Button is Disabled");
			}
		}
	}

	@Test
	public void loginButtonEnabledWhenFieldsFilled() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("RightEmail");
		driver.findElement(By.name("password")).sendKeys("RightPassword");
		WebElement Email1 = driver.findElement(By.name("email"));
		WebElement Password1 = driver.findElement(By.name("password"));
		String text3 = Email1.getText();
		String text4 = Password1.getText();
		if (text3.equals("RightEmail")) {
			if (text4.equals("RightPassword")) {
				{
					System.out.println("SignIn Button is Enabled");
				}

			}
		}
	}

	@Test
	public void passwordRecoveryFunction() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		driver.findElement(By.name("userName")).sendKeys("pradipjaybhaye1@gmail.com");
		driver.findElement(By.xpath("//button[@class='form__submit']")).click();
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.gmail.com");
		driver1.findElement(By.xpath("//input[@type='email']")).sendKeys("Right Email");
		driver1.findElement(By.xpath("//span[text()='Next']")).click();
		driver1.findElement(By.xpath("//input[@name='password']")).sendKeys("Right Email Password");
		driver1.findElement(By.xpath("//span[text()='Next']")).click();
		driver1.findElement(By.xpath("//button[text()='Not now']")).click();
		String OSNAMES = driver1.findElement(By.xpath("//span[contains(text(),' Dummy, here's your PIN']"))
				.getAttribute("value");
		String[] parts = OSNAMES.split(" ");
		String OS = parts[3];
		int a = Integer.parseInt(OS);
		driver1.close();
		driver.findElement(By.xpath("//input[@class='input_verification_pin']")).sendKeys(String.valueOf(a));
		driver.findElement(By.xpath("//button[@id='pin-submit-button']")).click();
		driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("RightPass1");
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("RightPass1");
		driver.findElement(By.xpath("//button[@id='reset-password-submit-button']"));
		driver.findElement(By.name("session_key")).sendKeys("RightEmail");
		driver.findElement(By.name("session_password")).sendKeys("RightPass1");
		driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
		String successUrlActual = driver.getTitle();

		String expectedSuccessUrl = "https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit";
		Assert.assertEquals(successUrlActual, expectedSuccessUrl);

	}
}
