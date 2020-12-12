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
import java.util.concurrent.TimeUnit;

import static core.Utils.*;

public class CareerPage extends BasePage {

    @FindBy(css = ".wpb_wrapper .grid-container")
    private WebElement cultureBlock;

    @FindBy(css = ".row-bg-wrap.instance-7 .row-bg")
    private WebElement locationBlock;

    @FindBy(css = ".filter-by-location .jobs-locations")
    private WebElement filterDrpdw;

    @FindBy(css = ".filter-by-jobs .jobs-teams")
    private WebElement jobsDrpdw;

    @FindBy(css = "#jobs-container")
    private WebElement jobsContainer;

    @FindBy(css = ".wpb_wrapper .col-sm-6 .careerLocations")
    List<WebElement> listLocationBlock;

    @FindBy(css = ".filter-by-location .jobs-locations")
    List<WebElement> cssContainer;

    @FindBy(css = ".jobs-list a[data-team=\"QualityAssurance\"]")
    List<WebElement> cssForPositionList;

    @FindBy(css = "#jobs-container [href*=\"0\"]")
    List<WebElement> linksInPosition;

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public void checkBLocksIsAvailable() {

        wait.until(ExpectedConditions.visibilityOf(cultureBlock));
        Assert.assertTrue("Container not visible", isElementsPresent(By.cssSelector(".wpb_wrapper .grid-container >div"), 2));
        Assert.assertTrue("Container not visible", isElementsPresent(By.cssSelector(".wpb_wrapper .col-sm-6 .careerLocations"), 2));
        Assert.assertTrue("Container not visible", isElementsPresent(By.cssSelector("a.column-link"), 2));
        Assert.assertTrue("Container not visible", isElementsPresent(By.cssSelector("#jobs-container .jobs-list >a"), 2));
        Assert.assertTrue("Container not visible", isElementsPresent(By.cssSelector("#sbi_images .sbi_photo_wrap"), 2));
    }

    public void selectJobs() {

        Select chooseFromDropDown = new Select(filterDrpdw);
        chooseFromDropDown.selectByIndex(2);
        chooseFromDropDown = new Select(jobsDrpdw);
        chooseFromDropDown.selectByVisibleText("Quality Assurance");
        waitSleep(1000);

    }

    public void selectJobsByPosition() {

        for (WebElement item : cssForPositionList) {
            if (item.getText().contains("Quality Assurance")) {
                List<WebElement> childList = item.findElements(By.xpath("./child::*"));
                WebElement jobTitle = childList.get(0);
                if (jobTitle.getText().contains("Quality Assurance")) {
                    WebElement jobDepartment = childList.get(1);
                    if (jobDepartment.getText().contains("Quality Assurance")) {
                        WebElement jobLocation = childList.get(2);
                        if (jobLocation.getText().contains("Istanbul, Turkey")) {
                            System.out.println();
                        }
                    }
                }
            } else {
                System.out.println("Something went wrong");
            }
        }

    }

    public void chooseAnyPositionByUrl() {
        String linkToJob = cssForPositionList.get(0).getAttribute("href");
        cssForPositionList.get(0).click();
        //check the correct position opened by URL
        checkUrl(linkToJob);
        waitSleep(5000);
    }


}



