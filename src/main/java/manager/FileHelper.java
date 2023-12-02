package manager;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface FileHelper extends AppManager{

    default String takeScreenShot(WebDriver driver){
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        String currentDate = format.format(date);
        //String curDate = currentDate.replace(":","-");
        String filePath = "test_logs/screenshots/screenshot_"+currentDate+".png";
        File DestFile = new File(filePath);
        try {
            Files.copy(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return currentDate;
    }
}
