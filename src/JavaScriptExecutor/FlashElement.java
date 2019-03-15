package JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlashElement {

	public static WebDriver driver;
	//JS commands are very powerful, you can perform DOM commands using JS

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));

		username.sendKeys("....");
		password.sendKeys("....");

		// driver.findElement(By.xpath("//input[contains(@type,'submit')]")).submit();

		WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		flash(loginBtn, driver); // highlight element

		drawBorder(loginBtn, driver); // draw border around indicated element

		takeScreeenshot(); // to take a screenshot of you error
		
		WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		scrollIntoView(forgotPasswordLink, driver);
		//forgotPasswordLink.click();
		
		
		//scrollPageDown(driver);	
		
		
		//generateAlert(driver, "There is an issue with login button"); //will generate alert message and block further execution
	
		System.out.println(getPageInenerText(driver)); //print all Text available on the PAge
		
		clickElementByJS(loginBtn, driver); //click on element using JavaScriptExecutor
		//refresh page
		//1 
		//driver.navigate().refresh(); 
		//2
		refreshBrowserByJS(driver);
		
		// getTitle using JS
		//1
		System.out.println(getTitleByJS(driver)); // getTitle using JS
		//2
		System.out.println(driver.getTitle());
		
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i <= 15; i++) {
			changeColor("rgb(178,34,34)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void takeScreeenshot() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File("C:\\Users\\Sviatik\\eclipse-workspace\\SeleniumLabsNaveen\\src\\JavaScriptExecutor\\element"
						+ ".png"));

	}
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);  //argument[0]--meaning there is only one element to perfor action on
	//We can perform click operation through JS in case if we're getting StaleElementException; JS is powerful tool
	}
	
	public static void refreshBrowserByJS (WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)"); //history.go[0]---means refresh first history
	}
	
	public static String getTitleByJS (WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInenerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageText=js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	public static void scrollPageDown (WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //scroll up and down
	}
	
	public static void scrollIntoView (WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
}
