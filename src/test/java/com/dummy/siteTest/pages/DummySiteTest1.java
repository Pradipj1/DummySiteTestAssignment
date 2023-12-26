package com.dummy.siteTest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DummySiteTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Documents\\cs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String URL = "https://www.linkedin.com/home";

		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("session_key")).sendKeys("pradipjaybhaye1@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("Prad99901");
		driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String successUrlActual = driver.getCurrentUrl();

		String expectedSuccessUrl = "https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit";
		Assert.assertEquals(successUrlActual, expectedSuccessUrl);
		driver.close();
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get(URL);
		driver1.findElement(By.name("session_key")).sendKeys("WrongEmail");
		driver1.findElement(By.name("session_password")).sendKeys("wrong Password");
		driver1.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
		driver1.findElement(By.name("session_password")).sendKeys("wrong Password");
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String failureUrlActual = driver1.getCurrentUrl();
		String expectedFailureUrl = "https://www.linkedin.com/uas/login-submit";
		Assert.assertEquals(failureUrlActual, expectedFailureUrl);
		driver1.close();
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().window().maximize();
		driver2.get(URL);
		driver2.findElement(By.name("session_key")).sendKeys("");
		driver2.findElement(By.name("session_password")).sendKeys("");
		WebElement Email = driver2.findElement(By.name("session_key"));
		WebElement Password = driver2.findElement(By.name("session_password"));
		String text1 = Email.getText();
		String text2 = Password.getText();
		if (text1.equals("")) {
			if (text2.equals("")) {
				System.out.println("SignIn Button is Disabled");
			}
		}
		driver2.close();
		WebDriver driver3 = new ChromeDriver();
		driver3.manage().window().maximize();
		driver3.get(URL);
		driver3.findElement(By.name("session_key")).sendKeys("pradipjaybhaye1@gmail.com");
		driver3.findElement(By.name("session_password")).sendKeys("Prad99901");
		WebElement Email1 = driver3.findElement(By.name("session_key"));
		WebElement Password1 = driver3.findElement(By.name("session_password"));
		String text3 = Email1.getText();
		String text4 = Password1.getText();
		if (text3.equals("pradipjaybhaye1@gmail.com")) {
			if (text4.equals("Prad99901")) {
				{
					System.out.println("SignIn Button is Enabled");
				}
			}
		}
		driver3.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		driver3.findElement(By.name("userName")).sendKeys("pradipjaybhaye1@gmail.com");
		driver3.findElement(By.xpath("//button[@class='form__submit']")).click();
		WebDriver driver4 = new ChromeDriver();
		driver4.get("https://www.gmail.com");
		driver4.findElement(By.xpath("//input[@type='email']")).sendKeys("Right Email");
		driver4.findElement(By.xpath("//span[text()='Next']")).click();
		driver4.findElement(By.xpath("//input[@name='password']")).sendKeys("Right Email Password");
		driver4.findElement(By.xpath("//span[text()='Next']")).click();
		driver4.findElement(By.xpath("//button[text()='Not now']")).click();
		String OSNAMES = driver4.findElement(By.xpath("//span[contains(text(),' Dummy, here's your PIN']"))
				.getAttribute("value");
		String[] parts = OSNAMES.split(" ");
		String OS = parts[3];
		int a = Integer.parseInt(OS);
		driver4.close();
		driver3.findElement(By.xpath("//input[@class='input_verification_pin']")).sendKeys(String.valueOf(a));
		driver3.findElement(By.xpath("//button[@id='pin-submit-button']")).click();
		driver3.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("RightPass1");
		driver3.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("RightPass1");
		driver3.findElement(By.xpath("//button[@id='reset-password-submit-button']"));
		driver3.findElement(By.name("session_key")).sendKeys("pradipjaybhaye1@gmail.com");
		driver3.findElement(By.name("session_password")).sendKeys("RightPass1");
		driver3.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();

	}
}
