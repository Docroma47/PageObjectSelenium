import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//header//a[@href='/login']")
    private WebElement signInButton;
    @FindBy (xpath = "//header//div//a[2]")
    private WebElement signUpButton;
    @FindBy (xpath = "//form/button")
    private WebElement signUpFormButton;
    @FindBy (xpath = "//*[@id='user[login]']")
    private WebElement loginField;
    @FindBy (xpath = "//*[@id='user[email]']")
    private WebElement emailField;
    @FindBy (xpath = "//*[@id='user[password]']")
    private WebElement passwordField;

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        return new  MainPage(driver);
    }
}
