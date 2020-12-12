package ui_Layer;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static core.Utils.*;

public class QAPage extends BasePage {

    @FindBy(css = ".main-footer-text.page-centered .image-link")
    private WebElement linkInBottom;

    @FindBy(css = ".section.page-centered.last-section-apply[data-qa=\"btn-apply-bottom\"] >a")
    private WebElement btnApply;

    @FindBy(css = ".postings-btn.template-btn-submit.shamrock")
    List<WebElement> allButtonsList;

    CareerPage careerPage;


    private WebDriverWait wait = new WebDriverWait(Driver.get(), 20);

    public void checkingJobDescriptionAndRequirements() {

        Assert.assertTrue(isElementsPresent(By.cssSelector(".section.page-centered"), 1));

    }

    public void checkButtonsOnPage() {


        Assert.assertTrue(isElementsPresent(By.cssSelector(".postings-btn.template-btn-submit.shamrock"), 1));
        clickJS(btnApply);

    }
}


