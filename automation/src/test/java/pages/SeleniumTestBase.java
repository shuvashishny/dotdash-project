package pages;

import browser.Browser;
import org.testng.annotations.AfterMethod;

/**
 * Created by Shuvashish on 3/13/2018.
 */
public class SeleniumTestBase {

    @AfterMethod
    public void closeBrowser(){
        Browser.driver.close();
        Browser.driver.quit();
    }
}
