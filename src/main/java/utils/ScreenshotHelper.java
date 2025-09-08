package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    public static String takeAScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        String filePath = System.getProperty("user.dir") + "test-output/screenshots/" +
                                                            testName + "_" + timestamp + ".png";
        File screenshotSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(filePath);

        try {
            Files.createDirectories((destination.getParentFile().toPath()));
            Files.copy(screenshotSource.toPath(), destination.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filePath;
    }
}
