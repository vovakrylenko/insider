package ui_Layer;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static core.Utils.checkUrl;
import static core.Utils.waitSleep;

public class MainPage extends BasePage {

    @FindBy(css = "#menu-item-21643")
    private WebElement careerBtn;

    @FindBy(css = ".comments-items .comment-item")
    List<WebElement> cssContainer;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void clickCareerBtn() {

        wait.until(ExpectedConditions.visibilityOf(careerBtn));
        careerBtn.click();

    }


}


