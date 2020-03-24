import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class MainClass {
        static FirefoxDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if ((System.getProperty("os.name").substring(0, 3)).equals("Lin")) {
            System.setProperty("webdriver.gecko.driver", "Drivers\\Linux\\geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        driver.get("https://github.com");
        sleep(2000);
        mainPage.register("r33r3", "fdsf@FDFDF", "45345345");
    }
}
