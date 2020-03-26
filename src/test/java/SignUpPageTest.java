import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SignUpPageTest {
    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        if ((System.getProperty("os.name").substring(0, 3)).equals("Lin")) {
            System.setProperty("webdriver.gecko.driver", "Drivers//Linux//geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "Drivers\\Windows\\geckodriver.exe");
        }
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpReservedUsernameTest() throws InterruptedException {
        sleep(2000);
        SignUpPage sp = signUpPage.inputLogin("username");
        sleep(2000);
        String error = sp.getErrorLogin();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    public void signUpTakenUsername() throws InterruptedException {
        sleep(2000);
        SignUpPage sp = signUpPage.inputLogin("user");
        sleep(2000);
        String error = sp.getErrorLogin();
        Assert.assertEquals("Username user is not available.", error);
    }

    @Test
    public void getHeadingTest() throws InterruptedException {
        sleep(2000);
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
