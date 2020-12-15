package core;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static core.Utils.waitSleep;

@Listeners(ScreenshotListener.class)
public class BaseTest {

    @BeforeSuite
    public void init() {

        Driver.init();

    }


    @BeforeClass
    public void openURL() {

        Driver.get().get(Config.getBaseURL());
        waitSleep(200);

    }


    @AfterSuite
    public void cleanup() {

        Driver.tearDown();

    }


}

