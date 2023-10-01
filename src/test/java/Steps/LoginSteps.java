package Steps;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import hooks.DriverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverInstance{


	@And("User Enter USerName as {string}")
	public void userEnterUSerNameAsStandardUser(String USerName) throws InterruptedException {
		Thread.sleep(1000);
		Thread.sleep(1000);
		//(//input[contains(@class,'input_error form_input')])[1]
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys(USerName);
	}
	
	@And ("User Enter Password as {string}")
	public void userEnterPasswordAsSecretSauce(String Password) throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys(Password);
	}
	
	@When("User Click on login button")
	public void userClickOnLoginButton() throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
			Thread.sleep(1000);

		
	}
	
	
	@Then("Login Should be Success")
	public void loginShouldBeSuccess() {
		
		String check_verif=driver.findElement(By.xpath("(//div[@class='header_secondary_container']//span)[1]")).getText();	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Products", check_verif);
		
	}
	
	

/* Starting -ve test case that i am checking here */
	
	@And("User Enter Wrong_USerName as {string}")
	public void userEnterWrongUSerNameAs(String Wrong_USerName) throws InterruptedException { 
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys(Wrong_USerName);
		
	}
	
	
	@And("User Enter Wrong_Password as {string}")
	public void userEnterWrongPasswordAs(String Wrong_Password) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys(Wrong_Password);
	}


	
	
	
	@Then("Login Should be not Success")
	public void loginShouldBeNotSuccess() {
	
		SoftAssert softAssert = new SoftAssert();
		String err=driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		System.out.println(err);
		softAssert.assertEquals("Epic sadface: Username and password do not match any user in this service", err);
	
	}
	
	@Then("Login Should fail")
	public void loginShouldFail() throws InterruptedException {
		System.out.println("Login Failed with wrong password");
	
		
	}

	
	
}
