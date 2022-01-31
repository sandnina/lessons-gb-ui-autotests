package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductSoap {
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
    @DisplayName("Добавление товара в корзину - успешно")
    public void addTest() {
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://milovarpro.ru/");

        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
        webDriver.findElement(By.name("password")).sendKeys("141085");
        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
        webDriver.findElement(By.xpath("//*[contains(text(), 'Каталог товаров')]")).click();
        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
        webDriver.findElement(By.xpath("//button[@data-goal-cart]")).click();
        webDriver.findElement(By.xpath("//*[@class=\"btn btn-blue\"]")).click();

       List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
       assertThat(addedProducts).hasSize(1);

//    @Test
//    @DisplayName("Увеличение количества товара в корзине - успешо")
//    public void addCountTest() {
//        WebDriver webDriver = WebDriverManager.chromedriver().create();
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        webDriver.get("https://milovarpro.ru/");
//
//        webDriver.findElement(By.name("email")).sendKeys("for_mos_testing@mail.ru");
//        webDriver.findElement(By.name("password")).sendKeys("141085");
//        webDriver.findElement(By.xpath("//button[text()='Войти']")).click();
//        webDriver.findElement(By.xpath("//*[contains(text(), 'Каталог товаров')]")).click();
//        webDriver.findElement(By.xpath("//*[contains(text(),'Отдушки')]")).click();
//        webDriver.findElement(By.xpath("//button[@data-goal-cart]")).click();
//        webDriver.findElement(By.xpath("//*[@class=\"btn btn-blue\"]")).click();
//
//        List<WebElement> addedProducts = webDriver.findElements(By.xpath("//*[@class=\"el-count\"]"));
//        assertThat(addedProducts).hasSize(1);

//        new Actions(webDriver)
//                .moveToElement(webDriver.findElement(By.xpath("//*[contains(@class, 'el-count')]")))
//                .build()
//                .perform();
//
//        webDriver.findElement(By.xpath("//*[@class=\"el-count-plus\"]")).click();
//
//        List<WebElement> addedCount = webDriver.findElements(By.xpath("//div/input[(contains(@value, '2'))]"));
//        assertThat(addedCount).isEqualTo("2");

    }
    }
