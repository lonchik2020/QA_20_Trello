package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloHomePageTests {
    WebDriver driver;

    @BeforeClass
    public void openTrello() {
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void homePageTest() {
        WebElement logo = driver.findElement(By.xpath("//a[@href='/home']"));
        //System.out.println(logo.getAttribute("data-testid"));
        Assert.assertEquals(logo.getAttribute("data-testid"), "logo_link");

        List<WebElement> buttonList = driver.findElements(By.xpath("//button[@data-testid='bignav-tab']"));
        for (WebElement e : buttonList) {
            System.out.println(e.getText());
        }
        Assert.assertTrue(buttonList.size() == 4);
    }

    @Test
    public void homePageInputTest() {
        WebElement fieldInput = driver.findElement(
                By.xpath("//form[@data-testid='ui-email-signup-form']/input[3]"));

        WebElement fieldInput1 = driver.findElement(
                By.xpath("//form[@data-testid='ui-email-signup-form']/input[last()]"));
        Assert.assertEquals(fieldInput1.getAttribute("aria-label"), "Email");
    }

    @Test
    public void homePageButtonSignUp() {
        WebElement buttonSignUp = driver.findElement(By.xpath("//button[@aria-label='Sign up for Trello - it’s free!']"));

    }

    @Test
    public void homePageLogin() {
        WebElement buttonLogin = driver.findElement(
                By.xpath("//a[@href='/login' and @class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
        Assert.assertTrue(buttonLogin.getText().contains("Log"));
    }

    @Test
    public void buttonGetTrello() {
        WebElement buttonGet = driver.findElement(
                By.xpath("//div[@class='Buttonsstyles__ButtonGroup-sc-1jwidxo-3 jnMZCI']//a[@href='/signup']"));
        Assert.assertFalse(buttonGet.getText().equals("Get Trello for fre"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
