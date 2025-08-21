package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoversPage {
    WebDriver driver;
    public String userName, userProfileLink;

    @FindBy(className = "figure")
    public List<WebElement> userProfiles;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//initializes the web elements above
    }

    public void hoverOverUser(int index) {
        if (index < 0 || index >= userProfiles.size()) {
            throw new IndexOutOfBoundsException("Invalid user index provided.");
        }
        WebElement profile = userProfiles.get(index);
        WebElement profileName;
        WebElement profileLink;
        Actions actions = new Actions(driver);

        actions.moveToElement(profile).perform();
        profileName = profile.findElement(By.tagName("h5"));
        profileLink = profile.findElement(By.linkText("View profile"));

        setUserName(profileName.getText());
        setUserProfileLink(profileLink.getText());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileLink() {
        return userProfileLink;
    }

    public void setUserProfileLink(String userProfileLink) {
        this.userProfileLink = userProfileLink;
    }
}
