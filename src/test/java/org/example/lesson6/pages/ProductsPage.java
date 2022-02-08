package org.example.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage {
    WebDriver webDriver;

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Добавить товар в корзину")
    public ProductsPage putProductInCart(WebElement element) {
        webDriver.findElement(By.xpath("//button[@data-goal-cart]")).click();
                return new ProductsPage(webDriver);
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//*[@class=\"btn btn-blue\"]")).click();
        return new CartPage(webDriver);
    }


}
