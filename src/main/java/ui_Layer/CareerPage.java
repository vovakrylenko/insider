package ui_Layer;

import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static core.Utils.*;

public class CareerPage extends BasePage {

    @FindBy(css = ".wpb_wrapper .grid-container")
    private WebElement checkBlockList;

    @FindBy(css = ".filter-by-location .jobs-locations")
    private WebElement filterDrpdw;

    @FindBy(css = "#jobs-container .jobs-teams")
    private WebElement jobsDrpdw;

    @FindBy(css = ".jobs-list a[data-team=\"QualityAssurance\"]")
    List<WebElement> cssForPositionList;

    String qualityAssurance = "Quality Assurance";
    String location = "Istanbul, Turkey";
    String expectedMessageForContainer = "Container not visible";
    String elVisibility = "Elements not visible on page";

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void checkBLocksIsAvailable() {

        wait.until(ExpectedConditions.visibilityOf(checkBlockList));
        Assert.assertTrue(expectedMessageForContainer, isElementsPresent(By.cssSelector("#culture .grid-container >div"), 2));
        Assert.assertTrue(expectedMessageForContainer, isElementsPresent(By.cssSelector(".wpb_wrapper .col-sm-6 .careerLocations"), 2));
        Assert.assertTrue(expectedMessageForContainer, isElementsPresent(By.cssSelector(".container.main-content a.column-link"), 2));
        Assert.assertTrue(expectedMessageForContainer, isElementsPresent(By.cssSelector("#jobs-container .jobs-list >a"), 2));
        Assert.assertTrue(expectedMessageForContainer, isElementsPresent(By.cssSelector("#sbi_images .sbi_photo_wrap"), 2));
    }

    public void selectJobs() {

        Select chooseFromDropDown = new Select(filterDrpdw);
        chooseFromDropDown.selectByIndex(2);
        chooseFromDropDown = new Select(jobsDrpdw);
        chooseFromDropDown.selectByVisibleText(qualityAssurance);
        waitSleep(1000);

    }

    public void selectJobsByPosition() {

        for (WebElement item : cssForPositionList) {
            if (item.getText().contains(qualityAssurance)) {
                List<WebElement> childList = item.findElements(By.xpath("./child::*"));
                WebElement jobTitle = childList.get(0);
                WebElement jobDepartment = childList.get(1);
                WebElement jobLocation = childList.get(2);
                if (jobTitle.getText().contains(qualityAssurance))
                    Assert.assertTrue(elVisibility, jobTitle.isDisplayed());
                if (jobDepartment.getText().contains(qualityAssurance))
                    Assert.assertTrue(elVisibility, jobDepartment.isDisplayed());
                if (jobLocation.getText().contains(location))
                    Assert.assertTrue(elVisibility, jobLocation.isDisplayed());

            }
        }
    }

    public void chooseAnyPositionByUrl() {
        String linkToJob = cssForPositionList.get(0).getAttribute("href");
        cssForPositionList.get(0).click();
        //check the correct position opened by URL
        checkUrl(linkToJob);
        waitSleep(3000);

    }
}



