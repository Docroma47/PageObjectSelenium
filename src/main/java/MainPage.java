import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    private By signInButton = By.xpath("//header//a[@href='/login']");
    private By signUpButton = By.xpath("//header//div//a[2]");;
    private By signUpFormButton = By.xpath("//form/button");;
    private By loginField = By.xpath("//*[@id='user[login]']");;
    private By emailField = By.xpath("//*[@id='user[email]']");;
    private By passwordField = By.xpath("//*[@id='user[password]']");
    private By erroLogin = By.xpath("//div[@class=\"m-1\"]/div[1]");
    private By erroEmail = By.xpath("//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");


    public String getErrorLogin() {
        return driver.findElement(erroLogin).getText();
    }

    public String getErrorEmail() {
        return driver.findElement(erroEmail).getText();
    }

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        return new  SignUpPage(driver);
    }
}
