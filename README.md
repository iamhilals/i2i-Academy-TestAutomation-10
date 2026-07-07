Proje, Java tabanlı bir Maven altyapısı üzerine inşa edilmiş olup aşağıdaki üç ana modülden oluşmaktadır:

* Web UI Otomasyonu (Selenium WebDriver): Bir demo web sitesi (SauceDemo) üzerinde kullanıcı giriş işlemlerini simüle eden ve işlemin başarıyla tamamlandığını doğrulayan (assertion) otomasyon senaryosu.
* API Otomasyonu (REST Assured): JSONPlaceholder test servisi kullanılarak GET ve POST gibi temel HTTP isteklerinin yapıldığı; 200 OK, 201 Created gibi durum kodlarının, yanıt sürelerinin ve gövde verilerinin doğrulandığı API testleri.
* Performans ve Stres Testi (Nginx & Apache JMeter): Nginx web sunucusu üzerinde oluşturulan sahte (dummy) bir API uç noktasına Apache JMeter aracılığıyla yüksek eşzamanlı sanal kullanıcı gönderilerek sistemin stres altındaki davranışlarının analiz edilmesi.
