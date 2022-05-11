import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class demo {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void click_test() {
        driver.findElementByAccessibilityId("Accessibility").click();
        driver.findElementByAccessibilityId("Accessibility Node Provider").click();
        String text = driver.findElementByAccessibilityId("Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.").getText();
        System.out.println(text);
        driver.navigate().back();
        driver.navigate().back();
    }

   // @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
