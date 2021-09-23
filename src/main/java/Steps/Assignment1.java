package Steps;

import Pages.NewAddressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assignment1 {

    NewAddressPage newAddressPage;
    WebDriver driver;

    @Given("user opens https://prod-kurs.coderslab.pl/index.php")
    public void openPrestaShop(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");

    }

    @And("user signs in")
    public void signInPresta(){

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        signInButton.click();
        WebElement fieldEmail = driver.findElement(By.name("email"));
        fieldEmail.sendKeys("kolok@wp.pl");
        WebElement fieldPassword = driver.findElement(By.name("password"));
        fieldPassword.sendKeys("12345");
        WebElement loginSignIn = driver.findElement(By.id("submit-login"));
        loginSignIn.click();
    }
    @When("user opens addresses page")
    public void addNewAddress(){
        WebElement addAddress = driver.findElement(By.id("address-link"));
        addAddress.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @And("user fills in alias (.*)")
    public void inputAlias(String Alias){
        NewAddressPage.aliasInput(Alias);
    }

}
