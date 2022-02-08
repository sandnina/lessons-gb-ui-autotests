package org.example.lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.pages.MainLoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;

public class NegativeLoginTest {

        String login = "for_mos_testing@mail.ru";
        String password = "141086";
        private static final String URL = "https://milovarpro.ru/";

        WebDriver webDriver;

        @AfterEach
        void tearDown() throws Exception {
            webDriver.quit();
        }

        @DisplayName("Авторизация - неуспешо")
        @Test
        public void failedLogin() throws InterruptedException {
            webDriver = WebDriverManager.chromedriver().create();

            webDriver.get(URL);

            new MainLoginPage(webDriver)
                    .clickLoginButton(login, password);
            new MainLoginPage(webDriver)
                    .checkError("Несуществующая пара логин-пароль, попробуйте еще раз");
        }
    }
