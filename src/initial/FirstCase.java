package initial;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String originalURL = "http://newtours.demoaut.com/";
		
		//Initialization
		System.setProperty("webdriver.gecko.driver", "F://Software/Gecko Driver/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//opne url in firefox
		driver.get("http://newtours.demoaut.com/");
		
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		
		//writing the page source into a text file
		String fileSource = driver.getPageSource().toString();
		
		try {
			PrintWriter writer = new PrintWriter("pagesource.txt", "UTF-8");
			writer.println(fileSource);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getCurrentUrl());
		
		String url = driver.getCurrentUrl().toString();
		//System.out.println(url);
		
		//driver.close();
		
		if(url.equals(originalURL)){
			System.out.println("test case passed");
		}else{
			System.out.println("test case failed");
		}
	}

}
