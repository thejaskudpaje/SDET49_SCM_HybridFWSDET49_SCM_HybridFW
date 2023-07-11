package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefoxlaunch {
	
public static void main(String[] args) {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver1=new FirefoxDriver();

	WebDriverManager.chromedriver().setup();
	WebDriver driver2=new ChromeDriver();
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver3=new EdgeDriver();
	
	System.out.println("end");
}
}
