package Steps;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddCartSteps extends DriverInstance {

	
	private int T_products_check=0;


	@Given("User Login into Website with {string} and {string}")
	public void userLoginIntoWebsiteWithUsernameAsAndPasswordAs(String user_name, String User_password) throws InterruptedException {

		Thread.sleep(1000);
		Thread.sleep(1000);
		//Here is for UserName
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys(user_name);
		Thread.sleep(1000);

		//Here is For Password 
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys(User_password);
		driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
		Thread.sleep(1000);

	}
	@Given("User Sort Product with Price high to low")
	public void userSortProductWithPriceHighToLow() throws InterruptedException {
		
		//driver.findElement(By.xpath("//span[@class='active_option']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("(//option[text()='Name (A to Z)']/following-sibling::option)[3]")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		//String prdouct1=
		
				String prdouct1=driver.findElement(By.xpath("(//div[@class='pricebar']//div)[1]")).getText().replace("$", "");
		Thread.sleep(1000);
		String prdouct2=driver.findElement(By.xpath("(//div[@class='pricebar']//div)[2]")).getText().replace("$", "");;
		
		double p1=Double.parseDouble(prdouct1);
		double p2=Double.parseDouble(prdouct2);
		
		
		if(p1>p2) {
			System.out.println("Test Case Pass High to low");
		}


	}
	@Given("User Sort Product with Price low to high")
	public void userSortProductWithPriceLowToHigh() {

		driver.findElement(By.xpath("//span[@class='active_option']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("(//option[text()='Name (A to Z)']/following-sibling::option)[2]")).click();

		String prdouct1= null ,prdouct2 = null;

		prdouct1=driver.findElement(By.xpath("(//div[@class='pricebar']//div)[1]")).getText().replace("$", "");

		prdouct2=driver.findElement(By.xpath("(//div[@class='pricebar']//div)[2]")).getText().replace("$", "");

		double p1=Double.parseDouble(prdouct1);
		double p2=Double.parseDouble(prdouct2);

		if(p1<p2) {
			System.out.println("Test Case Pass low to High");
		}

	}
	@Given("User Sort Product with Name A to Z")
	public void userSortProductWithNameAToZ() {
		driver.findElement(By.xpath("//span[@class='active_option']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("//select[@class='product_sort_container']//option[1]")).click();

	}
	@Given("User Sort Product with Name Z to A")
	public void userSortProductWithNameZToA() {
		
		driver.findElement(By.xpath("//span[@class='active_option']/following-sibling::select[1]")).click();
		driver.findElement(By.xpath("(//select[@data-test='product_sort_container']//option)[2]")).click();
	}
	int totatprodust=0;

	@Given("User Add product to cart")
	public void userAddProductToCart() {
		//Adding 1st product
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		totatprodust ++;
		//Adding 2nd product
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		totatprodust ++;
		//Adding 3rd product
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		totatprodust ++;
	}
	
	@Then("the Cart badge should be update")
	public void theCartBadgeShouldBeUpdate() {
		String T_products=driver.findElement(By.xpath("//a[@class='shopping_cart_link']//span[1]")).getText();
		 setT_products_check(Integer.parseInt(T_products));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(totatprodust, Integer.parseInt(T_products));
	}
	
	
	@Given("User Remove product which is alredy selected")
	public void userRemoveProductWhichIsAlredySelected() {
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		totatprodust--;
	}
	@Then("the Cart badge should be update with less")
	public void theCartBadgeShouldBeUpdateWithLess() {
		String T_products=driver.findElement(By.xpath("//a[@class='shopping_cart_link']//span[1]")).getText();
		 setT_products_check(Integer.parseInt(T_products));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(totatprodust, Integer.parseInt(T_products));
	}
	public int getT_products_check() {
		return T_products_check;
	}
	public void setT_products_check(int t_products_check) {
		T_products_check = t_products_check;
	}




}
