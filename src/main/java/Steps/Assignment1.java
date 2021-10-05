package Steps;

import Pages.NewAddressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class Assignment1 {

    WebDriver driver;
    NewAddressPage newAddressPage;

    @Given("user opens https://mystore-testlab.coderslab.pl/")
    public void openPrestaShop(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/");

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
        WebElement addAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]"));
        addAddress.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @And("user fills in alias (.*)")
    public void inputAlias(String Alias){
        newAddressPage = new NewAddressPage(driver);
        NewAddressPage.aliasInput(Alias);
    }
    @And("user fills in address (.*)")
    public void inputAddress1(String Address){
        NewAddressPage.address1Input(Address);
    }
    @And("user fills in zip/postal code (.*)")
    public void inputZipPostalCode(String ZipPostalCode){
        NewAddressPage.postCodeInput(ZipPostalCode);
    }
    @And("user fills in city (.*)")
    public void inputCity(String City){
        NewAddressPage.cityInput(City);
    }
    @And("user fills in country (.*)")
    public void inputCountry(String Country){
        NewAddressPage.countryInput(Country);
    }
    @And("user fills in phone (.*)")
    public void inputPhone(String Phone){
        NewAddressPage.phoneInput(Phone);
    }

    @And("user saves new address")
    public void saveAddress(){
        NewAddressPage.saveAddress();
    }

    @Then("user has added new address")
    public void addedAddress(){
        WebElement addedAddress = driver.findElement(By.id("notifications"));
        assertEquals("Address successfully added!", addedAddress.getText());
        System.out.println("Test completed successfully");
    }

    @And("user quits browsing")
    public void shutDown(){
        driver.quit();
    }
}