package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginLogoutSoap {
    WebDriver webDriver;
//    @BeforeEach  // когда использую этот метод, то почему-то срабатывает ошибка. Закомментировала во всех тестах. При этом AfterEach работает без ошибок.
//    void setUp() {
//        webDriver = WebDriverManager.chromedriver().create();
//    }

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(200);
        webDriver.quit();
    }

    @Test
    @DisplayName("Авторизация - успешно")
    public void successfulLogInOut() throws InterruptedException {
        webDriver = WebDriverManager.chromedriver().create();

        webDriver.get("https://milovarpro.ru/");

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        webDriver.findElement(By.xpath("//button[text()='Выйти']")).click();

        new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Войти']")));
        }

    @Test
    @DisplayName("Авторизация - неуспешо")
    public void failedLogInOut() throws InterruptedException {
        webDriver = WebDriverManager.chromedriver().create();

        webDriver.get("https://milovarpro.ru/");

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("password_wrong");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();

        new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Несуществующая пара логин-пароль, попробуйте еще раз.']")));
    }
}
