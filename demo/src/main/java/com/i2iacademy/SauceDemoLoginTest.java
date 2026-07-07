package com.i2iacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest {

    public static void main(String[] args) {
        // 1. Tarayıcıyı başlatma (Selenium WebDriver)
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Demo test sitesine gitme
            driver.get("https://www.saucedemo.com/");
            System.out.println("Web sitesi açıldı.");

            // 3. Kullanıcı adı, şifre alanlarını ve giriş butonunu Locators (ID) ile bulma
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            // 4. Test verilerini girme ve giriş yapma
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();
            System.out.println("Giriş bilgilerini doldurup butona tıklandı.");

            // 5. Doğrulama (Assertion) - Ödevde tavsiye edilen güvenlik adımı
            // Sayfa URL'si "inventory.html" (ürünler sayfası) içeriyorsa giriş başarılıdır.
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Test Başarılı: Giriş işlemi doğrulandı!");
            } else {
                System.out.println("Test Başarısız: Giriş yapılamadı!");
            }

        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        } finally {
            // Test bitiminde arka planda açık kalmaması için tarayıcıyı kapatma
            driver.quit();
            System.out.println("Tarayıcı kapatıldı.");
        }
    }
}
