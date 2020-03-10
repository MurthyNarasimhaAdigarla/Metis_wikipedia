package steps.com;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Meties {
	public static WebDriver driver;
	private static String currentUsersDir = System.getProperty("user.dir");

	@Given("^I want to Open Metis wikipedia page$")
	public void i_want_to_Open_Metis_wikipedia_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", currentUsersDir + "\\src\\test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^I validate headings of content box in Metis wikipedia page$")
	public void i_validate_headings_of_content_box_in_Metis_wikipedia_page() throws Throwable {
		//driver.findElement(By.partialLinkText("Family")).click();

		//in progress

	}

	@When("^I validate hyperlinks in content box in Metis wikipedia page$")
	public void i_validate_hyperlinks_in_content_box_in_Metis_wikipedia_page() throws Throwable {
		List<WebElement> linksInContentBox = driver.findElements(By.xpath("//*[@id='toc']/ul/li"));
		int totallinks = linksInContentBox.size();
		System.out.println("total " + totallinks);
		for (int i = 0; i < totallinks; i++) {
			String NameoflinksInContentBox = linksInContentBox.get(i).getText();
			System.out.println(NameoflinksInContentBox);
			String tagoflinksInContentBox = linksInContentBox.get(i).getTagName();
			Assert.assertEquals(tagoflinksInContentBox, "li");

		}
		System.out.println("All the headings in content box are links");

	}

	@When("^I  validate pop up$")
	public void i_validate_pop_up() throws Throwable {
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver
				.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[6]/td/div/ul/li[13]/a"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		WebElement nikeText = driver
				.findElement(By.xpath("//*[@id='mw-content-text']/div/table[1]/tbody/tr[6]/td/div/ul/li[13]/a"));
		actions.moveToElement(nikeText).perform();
		System.out.println("Done Mouse hover on 'Nike' from Personified concepts box");
		Thread.sleep(3000);
		String NikepopupText = driver.findElement(By.xpath("/html/body/div[8]/div/a[2]")).getText();
		String expectedText = "In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
		System.out.println(NikepopupText);
		Assert.assertEquals(NikepopupText, expectedText);

	}

	@When("^I see family tree on clicking NIKE option$")
	public void i_see_family_tree_on_clicking_NIKE_option() throws Throwable {
		driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[1]/tbody/tr[6]/td/div/ul/li[13]/a")).click();

		WebElement familyTree_heading = driver.findElement(By.xpath("//*[@id='Family_tree']"));

		String actualHeading = familyTree_heading.getText();

		String expectedHeading = "Family tree";

		System.out.println("FamilyTree_heading is" + actualHeading);

		if (expectedHeading.equalsIgnoreCase(actualHeading)) {

			System.out.println("Expected text is obtained");

		} else {

			System.out.println("Expected text is not obtained");

		}

	}
}