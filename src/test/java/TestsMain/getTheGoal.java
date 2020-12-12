package TestsMain;

import core.BaseTest;
import core.Config;
import core.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ui_Layer.ApplyFormPage;
import ui_Layer.CareerPage;
import ui_Layer.MainPage;
import ui_Layer.QAPage;
import org.openqa.selenium.WebDriver;

import static core.Utils.checkUrl;
import static core.Utils.waitSleep;

public class getTheGoal extends BaseTest {

    MainPage mainPage;
    CareerPage careerPage;
    QAPage qaPage;
    ApplyFormPage applyFormPage;

    @Test
    public void openMain() {

        mainPage = new MainPage();

        checkUrl("https://useinsider.com/");
        mainPage.clickCareerBtn();

    }

    @Test
    public void setCareerPage() {

        careerPage = new CareerPage();

        careerPage.checkBLocksIsAvailable();
        careerPage.selectJobs();
        careerPage.selectJobsByPosition();
        careerPage.chooseAnyPositionByUrl();

        //----------checkingDataFromQAPage-----------//

        qaPage = new QAPage();
        qaPage.checkingJobDescriptionAndRequirements();
        qaPage.checkButtonsOnPage();

        //------------checkingDataFromApplyPage-------//

        applyFormPage = new ApplyFormPage();
        applyFormPage.checkingApplicationForm();

    }

/*
    @Test
    public void checkingDataFromQAPage() {

        //Driver.get().get("https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e");


    }

    @Test
    public void checkingDataFromApplyPage() {

        //Driver.get().get("https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e/apply");


    }
*/


}


