import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class P2_LoginPage {

    @Test
    public void verifyLoginWithValidCredentials() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Open Login Page
        driver.get("https://logicnextgen.com/projects/logiccart/upload/index.php?route=account/login&language=en-gb");

        // Enter Email
        driver.findElement(By.id("input-email")).sendKeys("kundan@gmail.com");

        // Enter Password
        driver.findElement(By.id("input-password")).sendKeys("123456");

        Thread.sleep(5000);
        
        driver.findElement( By.xpath("//button[text()='Login']")).click();
        

        // Validation
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

       // driver.quit();

}
    
}
