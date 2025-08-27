package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploadPage {
    WebDriver driver;
    private By inputFileField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String relativePathOfTheFile) {
        String currentWorkingDirectory = System.getProperty("user.dir");
        String fullPath = currentWorkingDirectory + File.separator + relativePathOfTheFile;

        File file = new File(fullPath);
        driver.findElement(inputFileField).sendKeys(file.getAbsolutePath());
        clickUploadButton();
    }

    public String getUploadedFile() {
        return driver.findElement(uploadedFile).getText();
    }
}
