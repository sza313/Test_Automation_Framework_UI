package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import selenium.pageObjects.PhpSearchResPageObjects;

public class PhpSearchResPage extends PhpSearchResPageObjects {

    public PhpSearchResPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickCheckbox(String sectionName, String checkboxName, boolean checkboxValueToSet) {
        switch (sectionName) {
            case "STAR GRADE":
                switch(checkboxName) {
                    case ("1 star"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade1, checkboxValueToSet));
                        return true;
                    case ("2 star"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade2, checkboxValueToSet));
                        return true;
                    case ("3 star"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade3, checkboxValueToSet));
                        return true;
                    case ("4 star"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade4, checkboxValueToSet));
                        return true;
                    case ("5 star"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade5, checkboxValueToSet));
                        return true;
                    default:
                        Assert.fail("Could not find the requested item: " + checkboxName + ".");
                        return false;
                }
            case "PROPERTY TYPES":
                switch(checkboxName) {
                    case ("Apartment"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.propertyApartment, checkboxValueToSet));
                        return true;
                    case ("Hotel"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.propertyHotel, checkboxValueToSet));
                        return true;
                    case ("Villa"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.propertyVilla, checkboxValueToSet));
                        return true;
                    default:
                        Assert.fail("Could not find the requested item: " + checkboxName + ".");
                        return false;
                }
            case "AMENITIES":
                switch(checkboxName) {
                    case ("Airport Transport"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesAirportTransport, checkboxValueToSet));
                        return true;
                    case ("Business Center"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesBusinessCenter, checkboxValueToSet));
                        return true;
                    case ("Laundry Service"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesLaundryService, checkboxValueToSet));
                        return true;
                    case ("Restaurant"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesRestaurant, checkboxValueToSet));
                        return true;
                    case ("WI-FI Internet"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesWiFi, checkboxValueToSet));
                        return true;
                    case ("Swimming Pool"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesSwimmingPool, checkboxValueToSet));
                        return true;
                    case ("Inside Parking"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesInsideParking, checkboxValueToSet));
                        return true;
                    case ("Fitness Center"):
                        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.amenitiesFitnessCenter, checkboxValueToSet));
                        return true;
                    default:
                        Assert.fail("Could not find the requested item: " + checkboxName + ".");
                        return false;
                }

            default:
                Assert.fail("Could not find the requested section: " + sectionName + ".");
                return false;
        }
    }

    public boolean moveSliderToValue(String sliderName, String value) {
        int valueToSet = Integer.valueOf(value);
        switch (sliderName) {
            case "Left Slider":
                scrollToElementWithJS(this.leftPricericeRange);
                Assert.assertTrue("Could not move the handle of the slider: " + sliderName + " to the requested value.", moveSliderToValue(this.leftPricericeRange, valueToSet));
                return true;
            case "Right Slider":
                scrollToElementWithJS(this.rightPricericeRange);
                Assert.assertTrue("Could not move the handle of the slider: " + sliderName + " to the requested value.", moveSliderToValue(this.rightPricericeRange, valueToSet));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + sliderName + " .");
                return false;
        }
    }

    public boolean clickToItem(String itemName) {
        switch (itemName) {
            case "SEARCH":
                Assert.assertTrue("Could not click to " + itemName, clickToElement(this.searchButton));
                return true;
            case "Testing1 Hotel":
                scrollToElementWithJS(this.testing1Hotel);
                Assert.assertTrue("Could not click to " + itemName, clickToElement(this.testing1Hotel));
                return true;
            case "Testing2 Hotel":
                scrollToElementWithJS(this.testing2Hotel);
                Assert.assertTrue("Could not click to " + itemName, clickToElement(this.testing2Hotel));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + itemName);
                return false;
        }
    }

}
