package selenium.pageObjects.seleniumeasy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

import java.util.List;

public class FormFillerPageObjects extends DriverUtil {
    private final static Logger LOG = LogManager.getLogger();

    @FindBy(css = "input[name='first_name']")
    private WebElement firstNameTextField;

    @FindBy(css = "input[name='last_name']")
    private WebElement lastNameTextField;

    @FindBy(css = "input[name='email']")
    private WebElement emailTextField;

    @FindBy(css = "input[name='phone']")
    private WebElement phoneTextField;

    @FindBy(css = "input[name='address']")
    private WebElement addressTextField;

    @FindBy(css = "input[name='city']")
    private WebElement cityTextField;

    @FindBy(css = "select[name='state']")
    private WebElement stateSelect;

    @FindBy(css = "input[name='zip']")
    private WebElement zipTextField;

    @FindBy(css = "input[name='website']")
    private WebElement websiteTextField;

    @Deprecated
    @FindBy(css = "div.col-md-4")
    private WebElement haveHostingRadioButtion;

    @FindBy(css = "textarea[name='comment']")
    private WebElement projectDescriptionTextArea;

    @FindBy(css = "button.btn.btn-default")
    private WebElement submitButton;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> radioButtons;

    public FormFillerPageObjects(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        LOG.info("Formfiller page-objects initialized.");
    }

    public WebElement getFirstNameTextField() {
        return firstNameTextField;
    }

    public WebElement getLastNameTextField() {
        return lastNameTextField;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getPhoneTextField() {
        return phoneTextField;
    }

    public WebElement getAddressTextField() {
        return addressTextField;
    }

    public WebElement getCityTextField() {
        return cityTextField;
    }

    public WebElement getStateSelect() {
        return stateSelect;
    }

    public WebElement getZipTextField() {
        return zipTextField;
    }

    public WebElement getWebsiteTextField() {
        return websiteTextField;
    }

    public WebElement getHaveHostingRadioButtion() {
        return haveHostingRadioButtion;
    }

    public WebElement getProjectDescriptionTextArea() {
        return projectDescriptionTextArea;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }
}
