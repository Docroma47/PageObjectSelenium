import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class MainClass {
        static FirefoxDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "A:\\Proj\\TestSelenium\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        driver.get("https://github.com");
        sleep(2000);
        mainPage.register("r33r3", "fdsf@FDFDF", "45345345");
    }
}
