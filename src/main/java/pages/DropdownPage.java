package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOptionByText(String text) {
        findDropdownElement().selectByVisibleText(text);
    }

    public String getSelectedOptionText() {
        return findDropdownElement().getFirstSelectedOption().getText();
    }

    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }

    public void enableMultiSelect() {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        String script = "arguments[0].setAttribute('multiple', '');";
        javaScriptExecutor.executeScript(script, findDropdownElement());
    }

    public void selectMultipleOptions(List<String> options) {
        findDropdownElement();
        for (String option : options) {
            selectOptionByText(option);
        }
    }

    public List<String> getAllSelectedOptions() {
        List<String> selectedOptions = new ArrayList<>();
        findDropdownElement().getAllSelectedOptions().forEach(
                option -> selectedOptions.add(option.getText()));
        return selectedOptions;
    }
}
