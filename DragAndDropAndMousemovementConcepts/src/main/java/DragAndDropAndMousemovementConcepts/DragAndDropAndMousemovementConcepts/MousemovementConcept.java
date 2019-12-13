package DragAndDropAndMousemovementConcepts.DragAndDropAndMousemovementConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MousemovementConcept {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver d = new FirefoxDriver();

		d.get("https://www.jabong.com/");  

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page loaded before that remaining time will be ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page loaded before that remaining time will be ignored 
		//Also this timeouts() are global variable no need to assign again & again to wait until the page loads.
		
		Actions act = new Actions(d);  //Focus will change to mouse movement particular element
		
		act.moveToElement(d.findElement(By.linkText("KIDS"))).build().perform();
		
		d.findElement(By.linkText("Causual Dresses")).click();
		
	}

}
