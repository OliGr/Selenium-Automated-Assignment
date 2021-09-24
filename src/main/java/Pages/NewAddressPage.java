package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    public static WebElement aliasInput;

    @FindBy(name = "address1")
    public static WebElement address1Input;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "id_country")
    WebElement countryInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public static void aliasInput(String Alias){
        aliasInput.sendKeys(Alias);
    }

    public static void address1Input(String Address) {
        address1Input.sendKeys(Address);
    }
}
