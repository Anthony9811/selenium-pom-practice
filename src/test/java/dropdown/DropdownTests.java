package dropdown;

import base.BaseTests;
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
        dropdownPage = homePage.clickOnDropdown();
        dropdownPage.selectOptionByText(optionText);
        String selectedOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOption, optionText,
                "The selected option is different than "+ optionText);
    }

    @Test(dataProvider = "multiSelectOptions")
    public void testMultiSelect(List<String> optionsToSelect) {
        dropdownPage = homePage.clickOnDropdown();
        dropdownPage.enableMultiSelect();
        dropdownPage.selectMultipleOptions(optionsToSelect);

        List<String> selectedOptions = dropdownPage.getAllSelectedOptions();

        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect),
                "Not all options were selected");
    }
}
