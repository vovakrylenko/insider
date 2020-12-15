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

    String errorMessage = "Text is not as expected";

    public void checkingApplicationForm() {

        isElementsPresent(By.cssSelector(".section.page-centered.application-form >*"), 5);

        for (WebElement checkTitle : applyTitleList) {
            if (checkTitle.getText().contains("SUBMIT YOUR APPLICATION")) {
                Assert.assertEquals(errorMessage, "SUBMIT YOUR APPLICATION", checkTitle.getText());
            }
        }
    }

}