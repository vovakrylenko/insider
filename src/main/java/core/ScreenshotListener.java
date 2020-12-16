package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        String filename = tr.getName() + "_" + (System.currentTimeMillis()/1000) + ".png";
        File screenshot = new File("screenshots" + File.separator + filename);
        if (!screenshot.exists()) {
            new File(screenshot.getParent()).mkdirs();
            try {
                screenshot.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            new FileOutputStream(screenshot).write(((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
