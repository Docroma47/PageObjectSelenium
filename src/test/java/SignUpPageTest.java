import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "A:\\Proj\\TestSelenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpReservedUsernameTest(){
        SignUpPage sp = signUpPage.inputLogin("username");
        String error = sp.getErrorLogin();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    public void signUpTakenUsername(){
        SignUpPage sp = signUpPage.inputLogin("user");
        String error = sp.getErrorLogin();
        Assert.assertEquals("Username user is not available.", error);
    }

    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
