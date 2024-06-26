package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {

	public String captureScreenshot(WebDriver driver, String filename) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		File screenshot = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png";
		
		File destinationpath = new File(path);

		FileHandler.copy(screenshot, destinationpath);
		return path;
	}
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		 String path = System.getProperty("user.dir")+"\\screenshots\\testimage.png";
		 
		File destinationpath = new File(path);

		FileHandler.copy(source, destinationpath);

	}

}
