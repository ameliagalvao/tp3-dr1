package org.example.tp3dr1.questao_5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormTest {
    private static WebDriver driver;
    private static PracticeForm practiceForm;

    @BeforeAll
    public static void setUp() {
        // Se necessário, configure a propriedade do ChromeDriver:
        // System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        practiceForm = new PracticeForm(driver);
    }

    @Test
    public void testFillContactUsForm() {
        // Preenche os campos do formulário
        practiceForm.firstNameInput.sendKeys("John");
        practiceForm.lastNameInput.sendKeys("Doe");
        practiceForm.emailInput.sendKeys("john.doe@example.com");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceForm.maleGenderRadio);
        practiceForm.maleGenderRadio.click();

        practiceForm.mobileInput.sendKeys("1234567890");

        // Preenchendo a data de nascimento
        practiceForm.dateOfBirthInput.click();
        practiceForm.dateOfBirthInput.sendKeys("10 Sep 1990");

        // Preenche o campo de subjects
        practiceForm.subjectsInput.sendKeys("Maths");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subjectOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0")));
        subjectOption.click();

        // Seleciona alguns hobbies
        practiceForm.sportsCheckbox.click();
        practiceForm.readingCheckbox.click();

        // Caso deseje, pode enviar uma imagem (verifique o caminho do arquivo)
        // contactUsForm.uploadPictureInput.sendKeys("C:\\caminho\\para\\imagem.jpg");

        // Preenche o endereço
        practiceForm.currentAddressInput.sendKeys("123 Main Street, City, Country");

        // Seleciona o estado
        practiceForm.stateDropdown.click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();

        // Seleciona a cidade
        practiceForm.cityDropdown.click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();

        // Submete o formulário
        practiceForm.submitButton.click();

        // Validação: aguarda e verifica se o modal de confirmação foi exibido com a mensagem correta
        String modalTitle = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")))
                .getText();

        assertEquals("Thanks for submitting the form", modalTitle, "O formulário não foi submetido com sucesso");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
