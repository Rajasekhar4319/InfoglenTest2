package com.infoglen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.io.Files;

public class PageObjects {

	WebDriver driver;
	File f = new File(System.getProperty("user.dir"));

	PageObjects(WebDriver driver) {

		this.driver = driver;

	}

	// Question1 Objects

	By serachTextBox = By.xpath("//input[@type='search']");
	By serachButton = By.xpath("//form/input[@type='submit']");
	By numberOfResult = By.xpath("//div[@class='results']/h1");
	By yearTitle = By.xpath("//ul[@class='search-results']/li//div[@class='title']");
	By movieTitle = By.xpath("//ul[@class='search-results']/li//div[@class='title']/a");

	By genres = By.xpath("//span[@class='header-movie-genres']/a");
	By MPPARating = By.xpath("//hgroup[@class='details']/span[6]/span");

	By castCrewTab = By.xpath("//ul/li[@class='tab cast-crew']/a");
	By directorName = By.xpath("//div[@class='director_container']//div[2]//dt/a");

	// // Question2 Objects

	By topStories = By.xpath("//div[@class='nwid_top']/a/h2[contains(text(),'Top Stories')]");

	public void test1() {

		driver.get(UserData.q1_URL);
		// driver.findElement(By.xpath("//button[text()='Reload']")).click();
		// driver.findElement(serachButton).click();
		driver.findElement(serachTextBox).sendKeys(UserData.searchMovieName);
		driver.findElement(serachTextBox).sendKeys(Keys.ENTER);
		// driver.findElement(serachButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String results = driver.findElement(numberOfResult).getText();
		System.out.println(results);
		Assert.assertEquals(results.contains("98"), true, "98 is not avaiable");

		List<WebElement> years = driver.findElements(yearTitle);

		System.out.println(years);

		for (WebElement year : years) {

			try {
				String yearText = year.getText();
				if (yearText.contains("1972")) {

					driver.findElement(movieTitle).click();

				}

			} catch (StaleElementReferenceException e) {
				// TODO: handle exception

			}

		}

		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */

		String genresText = driver.findElement(genres).getText();
		System.out.println(genresText);

		Assert.assertEquals(genresText.contains("Crime"), true, "Crime is not aviable");

		String MPPAText = driver.findElement(MPPARating).getText();
		System.out.println(MPPAText);
		Assert.assertEquals(MPPAText.contains("R"), true, "R is not aviable");

		driver.findElement(castCrewTab).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String director = driver.findElement(directorName).getText();
		System.out.println(director);

		Assert.assertEquals(director.contains("Francis Ford Coppola"), true, "Francis Ford Coppola is not availble");

	}

	public void test2() {

		driver.get(UserData.q2_URL);
		String topStory = driver.findElement(topStories).getText();
		System.out.println(topStory);

		WebElement nifty = driver.findElement(By.xpath(
				"//div[@class='common-wrapper btm-section clearfix']//div[@class='indicator-inner']//div/a/h5[text()='NIFTY50']"));
		if (nifty.isDisplayed()) {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				org.apache.commons.io.FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// The below method will save the screen shot in d drive with name
			// "screenshot.png"

		}
	}
	
	
	
}
