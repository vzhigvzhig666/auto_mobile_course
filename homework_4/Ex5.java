package homework_4;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
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
public class Ex5
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
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find button article options",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/customize_toolbar"),
                "Cannot find customize button",
                Duration.ofSeconds(5)
        );
        dragElementDown(
                By.xpath("(//android.widget.ImageView[@content-desc=\"Hold the drag icon to move the item\"])[1]"),
                By.xpath("(//android.widget.ImageView[@content-desc=\"Hold the drag icon to move the item\"])[6]"),
                "cannot drag element save"
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "cannot find back button",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find button article options",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Save']"),
                "Cannot find button to save",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "cannot find Add to reading list button",
                Duration.ofSeconds(5)
        );
        sendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Languages",
                "cannot send keys for name list",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("android:id/button1"),
                "cannot press ok button",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_search"),
                "cannot press search wikipedia field",
                Duration.ofSeconds(5)
        );
        sendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "python",
                "cannot find search wikipedia field",
                Duration.ofSeconds(5)

        );
        String python_article_locator = "//androidx.recyclerview.widget" +
                ".RecyclerView" +
                "[@resource-id=\"org.wikipedia:id/search_results_list\"]" +
                "/android.view.ViewGroup" +
                "//android.widget.TextView" +
                "[@text=\"Python (programming language)\"]";
        waitForElementAndClick(
                By.xpath(python_article_locator),
                "cannot find python locator",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find button article options",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Save']"),
                "Cannot find button to save",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "cannot find Add to reading list button",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/item_title\"]"),
                "Cannot find an existing list named +(добавить переменную)",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "Cannot close list",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "Cannot close list",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "Cannot close list",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/navigation_bar_item_small_label_view\" and @text=\"Saved\"]"),
                "cannot find saved button",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Languages']"),
                "Cannot click list article ",
                Duration.ofSeconds(5)
        );
        swipeElementToLeft(
                By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"Java (programming language)\"]"),
                "Cannot find saved article"
        );
        String second_article_from_list = waitForElementAndGetAttribute(
                By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"Python (programming language)\"]"),
                "text",
                "cannot find text attribute from article",
                Duration.ofSeconds(5)
        );
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"Python (programming language)\"]"),
                "cannot click a second article",
                Duration.ofSeconds(5)
        );
        String title_from_article = waitForElementAndGetAttribute(
                By.xpath("//android.widget.TextView[@text=\"Python (programming language)\"]"),
                "text",
                "cannot find a title from article",
                Duration.ofSeconds(5)
        );
        Assert.assertEquals(
                "Titles are not the same",
                second_article_from_list,
                title_from_article

        );

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
}