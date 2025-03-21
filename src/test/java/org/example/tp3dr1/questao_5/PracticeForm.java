package org.example.tp3dr1.questao_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://demoqa.com/automation-practice-form
public class PracticeForm {

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//label[text()='Male']")
    public WebElement maleGenderRadio;

    @FindBy(xpath = "//label[text()='Female']")
    public WebElement femaleGenderRadio;

    @FindBy(xpath = "//label[text()='Other']")
    public WebElement otherGenderRadio;

    @FindBy(id = "userNumber")
    public WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//label[text()='Sports']")
    public WebElement sportsCheckbox;

    @FindBy(xpath = "//label[text()='Reading']")
    public WebElement readingCheckbox;

    @FindBy(xpath = "//label[text()='Music']")
    public WebElement musicCheckbox;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "state")
    public WebElement stateDropdown;

    @FindBy(id = "city")
    public WebElement cityDropdown;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public PracticeForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}