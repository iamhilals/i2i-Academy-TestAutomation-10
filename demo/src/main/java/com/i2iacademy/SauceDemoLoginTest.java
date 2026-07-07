package com.i2iacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");
            System.out.println("Web sitesi açıldı.");

            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();
            System.out.println("Giriş bilgilerini doldurup butona tıklandı.");

            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Test Başarılı: Giriş işlemi doğrulandı!");
            } else {
                System.out.println("Test Başarısız: Giriş yapılamadı!");
            }

        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Kapatıldı.");
        }
    }
}
