package com.pranicompany.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


// ============== CogMento WEBSITE====================
public class Demo1_test {

	public WebDriver driver;

	@Parameters({ "URL" })
	@BeforeMethod
	public void config(String url) {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("email")).sendKeys("praneshsk070@gmail.com");
		driver.findElement(By.name("password")).sendKeys("NewUser@12345");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}

	@Test(priority = 0)
	public void menu_Elements() {
		WebElement menu = driver.findElement(By.id("main-nav"));
		List<WebElement> links = menu.findElements(By.tagName("a"));
		int count = links.size();
		for (int i = 0; i < count; i++) {
			System.out.println(links.get(i).getText());
			links.get(i).click();
			System.out.println(driver.getTitle());
		}
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
