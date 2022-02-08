package org.example.lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.pages.MainLoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddProductSoapTest {

    private static final String URL = "https://milovarpro.ru/";
    WebDriver webDriver;
    String login = "for_mos_testing@mail.ru";
    String password = "141085";

//    @BeforeEach
//    void Class() {
//        WebDriver webDriver = WebDriverManager.chromedriver().create();
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        webDriver.get(URL);
//    }

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(200);
        webDriver.quit();
    }

    @DisplayName("Добавление товара в корзину - успешно")
    @Test
    public void addTest() {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get(URL);


        new MainLoginPage(webDriver).clickLoginButton("for_mos_testing@mail.ru", "141085")
            .goToProductPage("Каталог товаров", "Отдушки")
            .putProductInCart(webDriver.findElement(By.xpath("//button[@data-goal-cart]")))
            .goToCart()
            .checkProductsInCart();
    }

}
