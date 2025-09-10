package dropdown;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.Arrays;
import java.util.List;

public class DropdownTests extends BaseTests {
    DropdownPage dropdownPage;

    @DataProvider(name = "dropdownOptions")
    private Object[][] getDropdownOptions() {
        return new Object[][] {
                {"Option 1"},
                {"Option 2"}
        };
    }

    @DataProvider(name = "multiSelectOptions")
    private Object[][] getMultiSelectOptions() {
        return new Object[][] {
                {Arrays.asList("Option 1", "Option 2")}
        };
    }

    @Test(dataProvider = "dropdownOptions")
    public void testDropdownSelection(String optionText) {
        reportLogger = report.createTest("Single Dropdown Selection Test");

        reportLogger.log(Status.INFO, "Clicking on Dropdown option");
        dropdownPage = homePage.clickOnDropdown();

        reportLogger.log(Status.INFO, "Selecting an option");
        dropdownPage.selectOptionByText(optionText);
        reportLogger.log(Status.PASS, " " + optionText + " selected");

        reportLogger.log(Status.INFO, "Getting text from the selected option");
        String selectedOption = dropdownPage.getSelectedOptionText();
        reportLogger.log(Status.PASS, "Text obtained");

        Assert.assertEquals(selectedOption, optionText,
                "The selected option is different than "+ optionText);
    }

    @Test(dataProvider = "multiSelectOptions")
    public void testMultiSelect(List<String> optionsToSelect) {
        reportLogger = report.createTest("Multiple Selection Dropdown Test");

        reportLogger.log(Status.INFO, "Clicking on Dropdown option");
        dropdownPage = homePage.clickOnDropdown();

        reportLogger.log(Status.INFO, "Changing dropdown attribute to enable multiselect");
        dropdownPage.enableMultiSelect();
        reportLogger.log(Status.PASS, "Attribute changed");

        reportLogger.log(Status.INFO, "Selecting options");
        dropdownPage.selectMultipleOptions(optionsToSelect);
        reportLogger.log(Status.PASS, "Options selected");

        reportLogger.log(Status.INFO, "Getting selected options");
        List<String> selectedOptions = dropdownPage.getAllSelectedOptions();
        reportLogger.log(Status.PASS, "Selected options obtained");

        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect),
                "Not all options were selected");
    }
}
