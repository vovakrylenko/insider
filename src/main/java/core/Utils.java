package core;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {


    private static WebDriverWait wait = new WebDriverWait(Driver.get(), 10);


    public static void checkUrl(String expURl) {
        Assert.assertEquals(Driver.get().getCurrentUrl(), expURl, "Url was not as expected");
    }

    public static void clickJS(WebElement someButton) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", someButton);
    }

    public static boolean isElementsPresent(By locator, int timeout) {
        Driver.get().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.get().findElements(locator);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }


    public static void waitSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {
        }
    }

}

