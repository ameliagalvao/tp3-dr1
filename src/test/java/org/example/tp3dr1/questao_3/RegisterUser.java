package org.example.tp3dr1.questao_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = https://demo.prestashop.com/#/en/front
public class RegisterUser {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[text() = 'Sign in']")
    public WebElement spanSign;

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    public WebElement linkDisplayRegisterForm;

    @FindBy(xpath = "//*[@id='field-id_gender-1']")
    public WebElement inputFieldGender;

    @FindBy(xpath = "//*[@id='field-firstname']")
    public WebElement inputFieldFirstname;

    @FindBy(xpath = "//*[@id='field-lastname']")
    public WebElement inputFieldLastname;

    @FindBy(xpath = "//*[@id='field-email']")
    public WebElement inputFieldEmail;

    @FindBy(xpath = "//*[@id='field-password']")
    public WebElement inputFieldPassword;

    @FindBy(xpath = "//*[@id='field-birthday']")
    public WebElement inputFieldBirthday;

    @FindBy(xpath = "//input[@name='optin']")
    public WebElement inputOptin;

    @FindBy(xpath = "//input[@name='psgdpr']")
    public WebElement input;

    @FindBy(xpath = "//input[@name='newsletter']")
    public WebElement inputNewsletter;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    public WebElement inputCustomerPrivacy;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSaveCustomer;

    public RegisterUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToRegistrationForm() {
        wait.until(ExpectedConditions.visibilityOf(spanSign));
        wait.until(ExpectedConditions.elementToBeClickable(spanSign));
        spanSign.click();
        wait.until(ExpectedConditions.visibilityOf(linkDisplayRegisterForm));
        wait.until(ExpectedConditions.elementToBeClickable(linkDisplayRegisterForm));
        linkDisplayRegisterForm.click();
    }

    public void fillRegistrationForm(String firstNameValue, String lastNameValue, String emailValue, String passwordValue, String birthdayValue) {
        wait.until(ExpectedConditions.visibilityOf(inputFieldEmail));

        inputFieldGender.click();
        inputFieldFirstname.sendKeys(firstNameValue);
        inputFieldLastname.sendKeys(lastNameValue);
        inputFieldEmail.sendKeys(emailValue);
        inputFieldPassword.sendKeys(passwordValue);
        inputFieldBirthday.sendKeys(birthdayValue);

        if (!inputOptin.isSelected()) {
            inputOptin.click();
        }
        if (!input.isSelected()) {
            input.click();
        }
        if (!inputNewsletter.isSelected()) {
            inputNewsletter.click();
        }
        if (!inputCustomerPrivacy.isSelected()) {
            inputCustomerPrivacy.click();
        }
    }

    public void submitForm() {
        buttonSaveCustomer.click();
    }


}