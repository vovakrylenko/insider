package Tests.UI_Tests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ui_Layer.ApplyFormPage;
import ui_Layer.CareerPage;
import ui_Layer.MainPage;
import ui_Layer.VacancyPage;

import static core.Utils.checkUrl;

public class TC001 extends BaseTest {

    MainPage mainPage;
    CareerPage careerPage;
    VacancyPage qaPage;
    ApplyFormPage applyFormPage;

    @Test(dataProvider = "C01", priority = 1, dataProviderClass = DataDrivenClass.class)

    public void openMain(String url) {

        Reporter.log("C01: Open main page and click on \"Career\" section");

        mainPage = new MainPage();

        checkUrl(url);
        mainPage.clickCareerBtn();

        Reporter.log("C01: Main page and \"Career\" section was successfully opened");

    }

    @Test(dataProvider = "C02", dependsOnMethods = {"openMain"}, dataProviderClass = DataDrivenClass.class)

    public void selectVacancy() {

        Reporter.log("C02: Set vacancy, description and checking apply form");

        careerPage = new CareerPage();
        qaPage = new VacancyPage();
        applyFormPage = new ApplyFormPage();

        careerPage.checkBLocksIsAvailable();
        careerPage.selectJobs();
        careerPage.selectJobsByPosition();
        careerPage.chooseAnyPositionByUrl();

        qaPage.checkingJobDescriptionAndRequirements();
        qaPage.checkButtonsOnPageAndClick();

        applyFormPage.checkingApplicationForm();

        Reporter.log("C02: Vacancy selected, job description and requirements available, apply form opened");

    }
}