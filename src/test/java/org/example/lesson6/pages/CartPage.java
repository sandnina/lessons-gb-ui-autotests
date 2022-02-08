package org.example.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверить, что товар добавлен в корзину")
    public CartPage checkProductsInCart() {
        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(1);
        return new CartPage(webDriver);
    }

    @Step("Удалить товар из корзины")
    public CartPage deleteProductFromCart() {
        webDriver.findElement(By.xpath("//*[@class=\"delete\"]")).click();
        return new CartPage(webDriver);
    }

    @Step("Проверить, что товар удален из корзины")
    public CartPage checkDelProductFromCart() {
        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(0);
        return new CartPage(webDriver);
    }

    @Step("Проверить возврат удаленного товара из корзины")
    public CartPage backProductToCart() {
        webDriver.findElement(By.xpath("//*[contains(text(),'Вернуть ')]")).click();
        return new CartPage(webDriver);
    }

    @Step("Проверить невозможность оформления заказа при пустой корзине")
    public CartPage getOrderEmptyCart(){
        webDriver.findElement(By.xpath("//*[contains(@class, 'btn btn-middle btn-submit')]")).click();
        return new CartPage(webDriver);
    }

    @Step("Проверить отображение текста ошибки оформления при пустой карзине")
    public void checkErrorCartText(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@class='red']"));
        assertThat(elements).isEqualTo(webDriver.findElements(By.xpath("//*[contains(text(),'Ваша корзина пуста')]")));
    }
}