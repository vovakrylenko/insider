package ui_Layer;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static core.Utils.isElementsPresent;

public class ApplyFormPage extends BasePage {

    @FindBy(css = ".section.page-centered.application-form >h4")
    List<WebElement> applyTitleList;

    @FindBy(css = ".section.page-centered.application-form >*")
    List<WebElement> allElementsInFormList;


    public void checkingApplicationForm() {

        isElementsPresent(By.cssSelector(".section.page-centered.application-form >*"), 1);

        for (WebElement checkTitle : applyTitleList) {
            if (checkTitle.getText().contains("SUBMIT YOUR APPLICATION")) {
                Assert.assertEquals("Error message", "SUBMIT YOUR APPLICATION", checkTitle.getText());
            }
        }
    }

}