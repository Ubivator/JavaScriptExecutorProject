package SeleniumLabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("sviatka");
		driver.findElement(By.name("password")).sendKeys("Gnhg765c");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");
		
		String date = "31-September-2017";
		String dateArray[] = date.split("-"); // split will have to be store in array var
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];

		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);

		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);

		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// *[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]

		String before_xpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";

		// 2-1, 2-2, 2-3, 2-4, 2-5, 2-6,2-7
		// 3-1, 3-2, 3-3, 3-4, 3-5, 3-6, 3-7
		final int totalWeekDays = 7;
		boolean flag = false;
		String dayVal = null;

		for (int rawNum = 2; rawNum <= 7; rawNum++) {
			for (int colNum = 1; colNum <= 7; colNum++) {
				try {
					dayVal = driver.findElement(By.xpath(before_xpath + rawNum + after_xpath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Please enter correct day value");
					flag = false;
					break;
				}

				System.out.println(dayVal);
				if (dayVal.equals(day)) {
					driver.findElement(By.xpath(before_xpath + rawNum + after_xpath + colNum + "]")).click();
					flag = true;
					break;
				}

			}
			if (flag) {
				break;
			}
		}

	}

}
