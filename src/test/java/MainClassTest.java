import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "A:\\Proj\\TestSelenium\\drivers\\geckodriver.exe");
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
    public void signUpTest() {
        SignUpPage signUpPage = mainPage.clickSignUpFormButton();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @Test
    public void registerFailTest() {
        mainPage.register("re", "ftsd@fd", "s321");
        String error = mainPage.getErrorLogin();
        Assert.assertEquals("Username re is not available.", error);
    }

    @Test
    public void logInHeadingTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String text = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", text);
    }

    @Test
    public void logInFailTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        loginPage.createAccount("roma", "5654fdg");
        String text = loginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", text);
    }
}
