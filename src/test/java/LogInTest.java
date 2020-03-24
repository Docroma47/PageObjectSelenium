import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LogInTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest() throws InterruptedException {
        sleep(2000);
        LoginPage newLoginPage =  loginPage.createAccount("","");
        sleep(2000);
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest() throws InterruptedException  {
        sleep(2000);
        LoginPage newLoginPage =  loginPage.createAccount("qweqewqwe","qweqweweqwe");
        sleep(2000);
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() throws InterruptedException  {
        sleep(2000);
        SignUpPage signUpPage = loginPage.clickCreateAnAccount();
        sleep(2000);
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
