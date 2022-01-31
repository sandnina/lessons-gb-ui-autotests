package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class DeleteProductSoap {
    WebDriver webDriver;
//    @BeforeEach
//    void setUp() {
//        webDriver = WebDriverManager.chromedriver().create();
//    }

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

        webDriver.get("https://milovarpro.ru/");

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Каталог товаров')]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
        webDriver.findElement(By.xpath("//button[@data-goal-cart]")).click();
        webDriver.findElement(By.xpath("//*[@class=\"btn btn-blue\"]")).click();
        webDriver.findElement(By.xpath("//*[@class=\"delete\"]")).click();

       List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(0);
    }

    @Test
    @DisplayName("Возврат удаленного товара из корзины - успешно")
    public void backProductTest() {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://milovarpro.ru/");

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Каталог товаров')]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
        webDriver.findElement(By.xpath("//button[@data-goal-cart]")).click();
        webDriver.findElement(By.xpath("//*[@class=\"btn btn-blue\"]")).click();
        webDriver.findElement(By.xpath("//*[@class=\"delete\"]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Вернуть ')]")).click();

        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
        assertThat(addedProducts).hasSize(1);
    }
}
