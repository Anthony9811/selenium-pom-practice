package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTests extends BaseTests {
    DropdownPage dropdownPage;

    @DataProvider(name = "dropdownOptions")
    private Object[][] getDropdownOptions() {
        return new Object[][] {
                {"Option 1"},
                {"Option 2"}
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
}
