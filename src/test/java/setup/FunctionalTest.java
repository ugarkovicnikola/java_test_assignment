package setup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * <strong>setup.FunctionalTest</strong> handles setup and teardown of WebDriver.
 * @author Kim Schiller
 */
public class FunctionalTest {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "E:\\Alas doo project\\java_test_assignment\\src\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After
  public void cleanUp(){
    driver.manage().deleteAllCookies();
  }

  @AfterClass
  public static void tearDown(){
    driver.close();
  }
}
