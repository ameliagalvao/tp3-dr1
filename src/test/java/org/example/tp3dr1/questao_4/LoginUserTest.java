package org.example.tp3dr1.questao_4;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUserTest {
    static WebDriver webDriver;
    static LoginUser loginUser;

    @BeforeAll
    static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://practicetestautomation.com/practice-test-login/");
        loginUser = new LoginUser(webDriver);
    }

    @Test
    public void shouldLoginSuccessfully(){
        loginUser.inputUsername.sendKeys("student");
        loginUser.inputPassword.sendKeys("Password123");
        loginUser.buttonSubmit.click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl   = webDriver.getCurrentUrl();
        assertEquals(expectedUrl,
                actualUrl,
                "A URL após o login não corresponde à esperada");
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
