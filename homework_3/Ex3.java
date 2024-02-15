package homework_3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class Ex3 {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","emu_Pixel_6");
        capabilities.setCapability("platformVersion","14.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/mariazigalova/Desktop/JavaAuto/JavaAUTO/apks/wikipedia-2-7-50466-huawei-2024-01-09.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
    @Test
    public void testCancellSearch()
    {
        waitForElementAndClick(
                By.xpath (
                        "//*[contains(@text, 'Skip')]"
                ), "Cannot find Skip element", Duration.ofSeconds(5));
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia element",
                Duration.ofSeconds(5));
        sendKeys(
                By.id("org.wikipedia:id/search_src_text"
                ),
                "Appium",
                "cannot send keys",
                Duration.ofSeconds(10)
        );
        waitForElementPresent(
                By.xpath(
                        "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/search_results_list\"]/android.view.ViewGroup[2]"),
                        "cannot find some elements",
                        Duration.ofSeconds(5)); // здесь находится элемент с индексом [2] , если тест падает, значит в поиске отображается меньше 1 элемента
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find and click cancel button",
                Duration.ofSeconds(5));
        waitForElementPresent(
                By.xpath(
                        "//android.widget.LinearLayout[@resource-id=\"org.wikipedia:id/search_empty_container\"]"),
                "Search container is not empty!",
                Duration.ofSeconds(5)
                );

    }
    private WebElement waitForElementPresent(By by, String error_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,
                timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private WebElement waitForElementAndClick(By by, String error_message, Duration timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, Duration.ofSeconds(5));
        element.click();
        return element;
    }
    private WebElement sendKeys(By by, String text, String error_message, Duration timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.sendKeys(text);
        return element;
    }

}
