package DragAndDropAndMousemovementConcepts.DragAndDropAndMousemovementConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.get("https://www.ebay.com/");

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page loaded before that remaining time will be ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page loaded before that remaining time will be ignored 
		//Also this timeouts() are global variable no need to assign again & again to wait until the page loads.
		d.get("https://jqueryui.com/droppable/");
		
		d.switchTo().frame(0); //0 is index & string also can be used.
		
		Actions act = new Actions(d);
		
		act.clickAndHold(d.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(d.findElement(By.xpath("//div[@id='droppable']"))).release().build().perform();
	}
}
