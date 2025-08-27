package fileupload;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    FileUploadPage fileUploadPage;

    @Test
    public void testFileUpload() {
        fileUploadPage = homePage.clickOnFileUploadPage();
        String relativeFilePath = "resources/image.jpg";
        fileUploadPage.uploadFile(relativeFilePath);

        Assert.assertEquals(fileUploadPage.getUploadedFile(),
                "image.jpg",
                "Uploaded file is incorrect");
    }
}
