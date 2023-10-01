package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks extends DriverInstance {
	
	@Before
	public void beforeScenario(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver, 20);
		driver.get("https://www.saucedemo.com/");
		//System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		byte[] screenshotAs=((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshotAs, "image/png", scenario.getName());
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		byte[] screenshotAs=((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshotAs, "image/png", scenario.getName());
		driver.close();
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStep(Scenario scenario) {

	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		
		
	}

}
