import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //*[@id="login_field"]
    //*[@id='password']
    //input[@value='Sign in'] //button
    ////h1[text()='Sign in to GitHub']
    //div[@class="container-lg px-2"]

    private By textGithub = By.xpath("//h1[text()='Sign in to GitHub']");
    private By error = By.xpath("//div[@class=\"container-lg px-2\"]");
    private By createAccountButton = By.xpath("//p//a");
    private By logInButton = By.xpath("//input[@value='Sign in']");
    private By loginOrEmailField = By.xpath("//*[@id='login_field']");
    private By passwordField = By.xpath("//*[@id='password']");

    public LoginPage inputLoginOrEmail(String email) {
        driver.findElement(loginOrEmailField).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clicklogInButton(String username, String password) {
        this.inputLoginOrEmail(username);
        this.inputPassword(password);
        driver.findElement(logInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(textGithub).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public LoginPage createAccount() {
        driver.findElement(createAccountButton).click();
        return new LoginPage(driver);
    }
}
