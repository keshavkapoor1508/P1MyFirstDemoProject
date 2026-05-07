import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P1_RegisterPage {

	@Test
	public void verifyRegisteringWithMandatoryFields() throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open URL
		driver.get("https://logicnextgen.com/projects/logiccart/upload/index.php?route=account/register&language=en-gb");
		driver.findElement(By.id("input-firstname")).sendKeys("Kundan");
		driver.findElement(By.id("input-lastname")).sendKeys("Kapoor");
		driver.findElement(By.id("input-email")).sendKeys("kundan" + System.currentTimeMillis() + "@test.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		
		
		Thread.sleep(5000);
		driver.findElement(By.id("newsletter-yes")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("k_kapoor_check_box")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("k_kapoor_developer_button")).click();
		

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		String expectedHeading = "Your Account Has Been Created!";

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);

		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		String expectedProperDetails = driver.findElement(By.id("content")).getText();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		//driver.quit();

		

	}

}
