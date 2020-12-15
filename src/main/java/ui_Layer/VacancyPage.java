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

public class VacancyPage extends BasePage {


    @FindBy(css = ".section.page-centered.last-section-apply[data-qa=\"btn-apply-bottom\"] >a")
    private WebElement btnApply;


    private WebDriverWait wait = new WebDriverWait(Driver.get(), 20);

    public void checkingJobDescriptionAndRequirements() {

        Assert.assertTrue(isElementsPresent(By.cssSelector(".section.page-centered"), 2000));

    }

    public void checkButtonsOnPageAndClick() {

        Assert.assertTrue(isElementsPresent(By.cssSelector(".postings-btn.template-btn-submit.shamrock"), 1));
        clickJS(btnApply);

    }
}


