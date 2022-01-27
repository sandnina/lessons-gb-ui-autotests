package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class AddProduct {
    public static void main( String[] args ) throws InterruptedException {

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


        Thread.sleep(2000);

        webDriver.quit();
    }

}
