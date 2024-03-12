package homework_4;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Ex6
{
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
        capabilities.setCapability("orientation", "PORTRAIT");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
    @Test
    public void saveFirstArticleToMyList()
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
                "JAVA",
                "cannot send keys",
                Duration.ofSeconds(10)
        );
        waitForElementAndClick(
                By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/search_results_list\"]/android.view.ViewGroup[2]"),
                "cannot find java prog lang element",
                Duration.ofSeconds(10)
        );
        String title_locator = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"Java (programming language)\"]";
        assertElementPresent(By.xpath(title_locator));

    }

    private WebElement waitForElementAndClick(By by, String error_message, Duration timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, Duration.ofSeconds(5));
        element.click();
        return element;
    }
    private WebElement waitForElementPresent(By by, String error_message, Duration timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,
                timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private WebElement sendKeys(By by, String text, String error_message, Duration timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.sendKeys(text);
        return element;
    }
    private boolean waitForElementNotPresent(By by, String error_message,Duration timeOutInSeconds )
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );

    }
    protected void swipeUp()
    {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        WaitOptions timeOfSwipe = new WaitOptions();
        timeOfSwipe.withDuration(Duration.ofSeconds(5));
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) (size.height*0.2);
        action.press(PointOption.point(x, start_y)).waitAction(timeOfSwipe).moveTo(PointOption.point(x, end_y)).release().perform();
    }
    protected void swipeUpQuick()
    {
        swipeUp();
    }
    protected void SwipeToFindElement(By by, String error_message,
                                      int max_swipes)
    {
        int already_swiped = 0;
        driver.findElements(by);
        driver.findElements(by).size();
        while (driver.findElements(by).size() == 0){
            if(already_swiped > max_swipes){
                waitForElementPresent(by,
                        "Cannot find element by swiping up \n" +error_message,
                        Duration.ofSeconds(5));
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }
    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                Duration.ofSeconds(10));
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y +element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction()
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();


    }
    protected void dragElementDown (By by,By by2, String error_message)
    {
        WebElement element1 = waitForElementPresent(
                by,
                error_message,
                Duration.ofSeconds(10)
        );
        WebElement element2 = waitForElementPresent(
                by2,
                error_message,
                Duration.ofSeconds(10)
        );
        int x1 = element1.getLocation().getX();
        int y1 = element1.getLocation().getY();
        int x2 = element2.getLocation().getX();
        int y2 = element2.getLocation().getY();

        TouchAction action =new TouchAction((PerformsTouchActions) driver);
        action
                .press(PointOption.point(x1,y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
                .moveTo(PointOption.point(x2,y2))
                .release()
                .perform();

    }
    private int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }
    private void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element" + by.toString() + " supposed to be not present";
            throw new AssertionError(default_message + "" + error_message);
        }
    }
    private String waitForElementAndGetAttribute(By by,
                                                 String attribute,
                                                 String error_message,
                                                 Duration timeOutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);

    }

    private void assertElementPresent(By by)
    {
        WebElement element_locator = driver.findElement(by);
        if ( !element_locator.isDisplayed()) {
            String default_message = "An element" + by.toString() + " doesnot exist ";
            throw new AssertionError(default_message );
        }

    }

}