package fileupload;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    FileUploadPage fileUploadPage;

    @Test
    public void testFileUpload() {
        reportLogger = report.createTest("File Upload Test");

        reportLogger.log(Status.INFO, "Clicking on File Upload option");
        fileUploadPage = homePage.clickOnFileUploadPage();

        String relativeFilePath = "resources/image.jpg";

        reportLogger.log(Status.INFO, "Clicking on Upload button and uploading the file");
        fileUploadPage.uploadFile(relativeFilePath);
        reportLogger.log(Status.PASS, "File uploaded");

        Assert.assertEquals(fileUploadPage.getUploadedFile(),
                "image.jpg",
                "Uploaded file is incorrect");
    }
}
