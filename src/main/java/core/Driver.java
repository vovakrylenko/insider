package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Driver {


    private static WebDriver driver;

    public static WebDriver get() {
        return driver;
    }

    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static void init() {
        WebDriver driverInput;
        switch (Config.getProperty("test.browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
                driverInput = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
                driverInput = new ChromeDriver();
                break;
            default:
                throw new AssertionError("Unsupported browser: " + Config.getProperty("test.browser"));
        }
        driverInput.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("test.timeouts")), TimeUnit.SECONDS);
        driverInput.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Driver.set(driverInput);
        get().manage().window().maximize();
    }

    public static void tearDown() {

        Driver.get().quit();

    }
}
