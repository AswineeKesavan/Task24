package Task24;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	public class Register {
	    public static void main(String[] args) throws Exception {
	
	        WebDriver driver = new ChromeDriver();
	        
	        // Navigate to the registration page
	        driver.get("https://www.guvi.in/register");
			// Maximize the browser window
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			// Step 4: Fill the sign up form
			WebElement nameField = driver.findElement(By.id("name"));
			WebElement emailField = driver.findElement(By.cssSelector("#email"));
			WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement mobileNo = driver.findElement(By.xpath("//input[@id='mobileNumber']"));

			nameField.sendKeys("Aswinee");
			emailField.sendKeys("aswinee109@gmail.com");
			passwordField.sendKeys("Test12344");
			mobileNo.sendKeys("9345678908");

			// Step 5: Click the signup button
			Thread.sleep(2000);
			driver.findElement(By.id("signup-btn")).click();

			Thread.sleep(2000);
			Select objSelect = new Select(driver.findElement(By.id("profileDrpDwn")));
			objSelect.selectByVisibleText("Student");

			
			Select degree = new Select(driver.findElement(By.id("degreeDrpDwn")));
			degree.selectByVisibleText("B.E. / B.Tech. Computer Science");

			Thread.sleep(2000);
			driver.findElement(By.id("year")).sendKeys("2017");

			// Wait for the page to load
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();

			Thread.sleep(5000);
			String txt = driver.findElement(By.xpath("//h1[contains(text(),'Almost Done! Check Your Inbox!')]"))
					.getText();
			// Verify registration
			if (txt.equals("Almost Done! Check Your Inbox!")) {
				System.out.println("Registration successful.");
			} else {
				System.out.println("Registration failed.");
			}

	        // Close the browser
	        driver.quit();
	    }
	}
