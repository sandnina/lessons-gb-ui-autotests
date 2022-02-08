package org.example.lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.pages.MainLoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class GetOrderSoapTest {
    private static final String URL = "https://milovarpro.ru/";
    WebDriver webDriver;

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(200);
        webDriver.quit();
    }

    @DisplayName("Оформление заказа при пустой корзине - неуспешно")
    @Test
    public void backProductTest() {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get(URL);

        new MainLoginPage(webDriver)
                .clickLoginButton("for_mos_testing@mail.ru", "141085")
                .goToProductPage("Каталог товаров", "Отдушки")
                .putProductInCart(webDriver.findElement(By.xpath("//button[@data-goal-cart]")))
                .goToCart()
                .checkProductsInCart()
                .deleteProductFromCart()
                .checkDelProductFromCart()
                .getOrderEmptyCart()
                .checkErrorCartText();

    }

}
