package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.IndexPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shuvashish on 3/10/2018.
 */
public class Browser {
    public static WebDriver driver ;
    public static final String url = "http://localhost/dotdash/index.php";

    public static IndexPage openBrowser(){
        System. setProperty("webdriver.chrome.driver", "src\\main\\java\\resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        return PageFactory.initElements(driver, IndexPage.class);
    }
}
