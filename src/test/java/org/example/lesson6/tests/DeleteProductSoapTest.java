package org.example.lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.pages.MainLoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteProductSoapTest {
    WebDriver webDriver;
    private static final String URL = "https://milovarpro.ru/";

    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(200);
        webDriver.quit();
    }

    @Test
    @DisplayName("Удаление товара из корзины - успешно")
    public void deleteTest() {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get(URL);

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();


        new MainLoginPage(webDriver).goToProductPage("Каталог товаров", "Отдушки")
                .putProductInCart(webDriver.findElement(By.xpath("//button[@data-goal-cart]")))
                .goToCart()
                .checkProductsInCart()
                .deleteProductFromCart()
                .checkDelProductFromCart();

    }

    @Test
    @DisplayName("Возврат удаленного товара из корзины - успешно")
    public void backProductTest() throws InterruptedException {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get(URL);

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();


        new MainLoginPage(webDriver).goToProductPage("Каталог товаров", "Отдушки")
                .putProductInCart(webDriver.findElement(By.xpath("//button[@data-goal-cart]")))
                .goToCart()
                .checkProductsInCart()
                .deleteProductFromCart()
                .checkDelProductFromCart()
                .backProductToCart();

        Thread.sleep(2000);

    }
}
