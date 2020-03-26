import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        if ((System.getProperty("os.name").substring(0, 3)).equals("Lin")) {
            System.setProperty("webdriver.gecko.driver", "Drivers//Linux//geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void signUpTest() throws InterruptedException {
        sleep(2000);
        SignUpPage signUpPage = mainPage.clickSignUpFormButton();
        sleep(2000);
        String heading = signUpPage.getHeadingText();
        sleep(2000);
        Assert.assertEquals("Create your account", heading);
    }

    @Test
    public void registerFailTest()  throws InterruptedException  {
        sleep(2000);
        mainPage.register("re", "ftsd@fd", "s321");
        sleep(2000);
        String error = mainPage.getErrorLogin();
        Assert.assertEquals("Username re is not available.", error);
    }

    @Test
    public void logInHeadingTest()  throws InterruptedException  {
        sleep(2000);
        LoginPage loginPage = mainPage.clickSignIn();
        sleep(2000);
        String text = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", text);
    }

    @Test
    public void logInFailTest()  throws InterruptedException  {
        sleep(2000);
        LoginPage loginPage = mainPage.clickSignIn();
        sleep(2000);
        loginPage.createAccount("roma", "5654fdg");
        sleep(2000);
        String text = loginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", text);
    }
}
