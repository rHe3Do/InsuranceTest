package Steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

    public class BaseSteps {

        private static WebDriver driver;
        static String baseUrl;
        public static Properties properties = util.TestProperties.getInstance().getProperties();

        public static WebDriver getDriver() {
            return driver;
        }

        @BeforeClass
        public static void startScenario() {
            switch (properties.getProperty("browser")) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
            }
            driver.get("http://www.rgs.ru");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }

        @AfterClass
        public static void afterMethod() {
            driver.quit();
        }

        @Attachment(type = "image/png", value = "Screenshot")
        public static byte[] takeScreenshot() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

    }
