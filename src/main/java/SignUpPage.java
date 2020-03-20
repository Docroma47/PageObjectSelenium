import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //*[@id='user_login']
    //*[@id='user_email']
    //*[@id='user_password']
    //h1 //Create your Account
    //*[@id="signup_button"]

    //*[@id="input-check-5381"]//error
    //*[@id="input-check-5346"]

    private By textGithub = By.xpath("//h1");
    private By errorMain = By.xpath("//div[@class=\"flash flash-error my-3\"]");
    private By errorLogin = By.xpath("//auto-check[1]//dd[@class=\"error\"]//div[@class=\"m-1\"]/div[1]");
    private By errorEmail = By.xpath("//auto-check[2]//dd[@class=\"error\"]");
    private By errorPassword = By.xpath("//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");
    private By createAccountButton = By.xpath("//*[@id='signup_button']");
    private By loginOrEmailField = By.xpath("//*[@id='user_login']");
    private By emailField = By.xpath("//*[@id='user_email']");
    private By passwordField = By.xpath("//*[@id='user_password']");

    public SignUpPage inputLogin(String login) {
        driver.findElement(loginOrEmailField).sendKeys(login);
        return this;
    }

    public SignUpPage inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage clickRegistrateInButton(String username, String email, String password) {
        this.inputLogin(username);
        this.inputEmail(email);
        this.inputPassword(password);
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }

    public String getErrorMain() {
        return driver.findElement(errorMain).getText();
    }

    public String getErrorLogin() {
        return driver.findElement(errorLogin).getText();
    }

    public String getErrorPassword() {
        return driver.findElement(errorPassword).getText();
    }

    public String getErrorEmail() {
        return driver.findElement(errorEmail).getText();
    }

    public String getHeadingText() {
        return driver.findElement(textGithub).getText();
    }
}
