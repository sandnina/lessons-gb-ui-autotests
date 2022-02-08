package org.example.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLoginPage {
    String login = "for_mos_testing@mail.ru";
    String password = "141085";
    WebDriver webDriver;

    public MainLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Авторизоваться под учетной запись {login} {password}")
    public MainLoginPage clickLoginButton(String login, String password) {
        webDriver.findElement(By.name("email")).sendKeys(login);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        return this;
    }

    @Step("Выйти из личного кабинета")
    public MainLoginPage clickLogoutButton() {
        webDriver.findElement(By.xpath("//button[text()='Выйти']")).click();
        return new MainLoginPage(webDriver);

    }

    @Step("Проверить отображение кнопки 'Войти'")
    public MainLoginPage checkLoginButton() {
    new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Войти']")));
    return this;
    }

    @Step("Проверить отображение текста ошибки авторизации")
    public void checkError(String errorText) {
        new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Несуществующая пара логин-пароль, попробуйте еще раз.']")));
    }

    @Step("Перейти на страницу каталога 'Отдушки'")
    public ProductsPage goToProductPage(String tab1, String tab2) {
        webDriver.findElement(By.xpath("//*[contains(text(), 'Каталог товаров')]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
        return new ProductsPage(webDriver);
    }


}
