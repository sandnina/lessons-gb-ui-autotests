package org.example.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLoginPage {
    WebDriver webDriver;

    public MainLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainLoginPage clickLoginButton(String login, String password) {
        webDriver.findElement(By.name("email")).sendKeys(login);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        return this;
    }

    public MainLoginPage clickLogoutButton() {
        webDriver.findElement(By.xpath("//button[text()='Выйти']")).click();
        return new MainLoginPage(webDriver);

    }

    public MainLoginPage checkLoginButton() {
    new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Войти']")));
    return this;
    }

    public void checkError(String errorText) {
        new WebDriverWait(webDriver,2000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Несуществующая пара логин-пароль, попробуйте еще раз.']")));
    }

    public ProductsPage goToProductPage(String tab1, String tab2) {
        webDriver.findElement(By.xpath("//*[contains(text(), 'Каталог товаров')]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
        return new ProductsPage(webDriver);
    }


}
