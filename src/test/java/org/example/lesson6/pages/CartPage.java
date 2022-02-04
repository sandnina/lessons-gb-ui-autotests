package org.example.lesson6.pages;

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

    public CartPage checkProductsInCart() {
        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(1);
        return new CartPage(webDriver);
    }

    public CartPage deleteProductFromCart() {
        webDriver.findElement(By.xpath("//*[@class=\"delete\"]")).click();
        return new CartPage(webDriver);
    }

    public CartPage checkDelProductFromCart() {
        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(0);
        return new CartPage(webDriver);
    }

    public CartPage backProductToCart() {
        webDriver.findElement(By.xpath("//*[contains(text(),'Вернуть ')]")).click();
        return new CartPage(webDriver);
    }

    public CartPage getOrderEmptyCart(){
        webDriver.findElement(By.xpath("//*[contains(@class, 'btn btn-middle btn-submit')]")).click();
        return new CartPage(webDriver);
    }

    public void checkErrorCartText(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@class='red']"));
        assertThat(elements).isEqualTo(webDriver.findElements(By.xpath("//*[contains(text(),'Ваша корзина пуста')]")));
    }
}