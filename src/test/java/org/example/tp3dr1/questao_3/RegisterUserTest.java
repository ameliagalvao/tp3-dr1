package org.example.tp3dr1.questao_3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUserTest {
    private static WebDriver driver;
    private static RegisterUser registerUser;

    @BeforeAll
    public static void setUp() {
        // Se necessário, configure a propriedade do ChromeDriver:
        // System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/#/en/front");
        registerUser = new RegisterUser(driver);
        registerUser.navigateToRegistrationForm();
    }

    @Test
    public void testRegisterUser() {
        String uniqueEmail = "usuario" + System.currentTimeMillis() + "@example.com";
        registerUser.fillRegistrationForm("João", "Silva", uniqueEmail, "Senha@123", "1990-01-01");
        registerUser.submitForm();
        assertTrue(driver.getCurrentUrl().contains("account") || driver.getCurrentUrl().contains("registration"),
                "Cadastro não concluído.");
        System.out.println("Cadastro realizado com sucesso para o e-mail: " + uniqueEmail);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
