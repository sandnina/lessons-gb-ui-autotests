package org.example.lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.pages.MainLoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;


public class LoginLogoutSoapTest {
    String login = "for_mos_testing@mail.ru";
    String password = "14108";
    private static final String URL = "https://milovarpro.ru/";

    WebDriver webDriver;

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(200);
        webDriver.quit();
    }

    @DisplayName("Авторизация - успешно")
    @Test
    public void successfulLogInOut() throws InterruptedException {
        webDriver = WebDriverManager.chromedriver().create();

        webDriver.get(URL);

        new MainLoginPage(webDriver)
                .clickLoginButton(login, password)
                .clickLogoutButton()
                .checkLoginButton();
    }

}
