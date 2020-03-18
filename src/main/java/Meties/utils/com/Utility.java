package Meties.utils.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Utility {
    public static WebDriver driver;
    private static String currentUsersDir = System.getProperty("user.dir");
    public void openingBrowser(){


        System.setProperty("webdriver.gecko.driver", currentUsersDir + "\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public void validatehyperlinksincontentboxinMetiswikipediapage(){
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


    public void ivalidate_popup() throws InterruptedException {

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

    public void iseefamilytreeonclicking_NIKEoption(){
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
