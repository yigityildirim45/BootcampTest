AccuWeather ve Spotify Testleri
Bu repo, web uygulamalarının kalitesini sağlamak için gerçekleştirilen testleri içerir.

AccuWeather Selenium Testleri
Bu bölüm, AccuWeather web sitesinin Selenium ile otomatikleştirilmiş testlerini içerir. Testler, farklı şehirler için hava durumu bilgilerini çekerek ve doğrulamalar yaparak web sitesinin işlevselliğini doğrulamak için tasarlanmıştır.

Test Senaryoları:

Farklı şehirlerin hava durumunu arama

Sıcaklık, rüzgar, nem ve hava kalitesi gibi hava durumu bilgilerini doğrulama

Günlük ve saatlik hava durumu tahminlerini doğrulama

Hava durumu uyarılarını kontrol etme

Kullanılan Teknolojiler:

Selenium

Python

Allure Report

Kurulum:

Python 3 ve gerekli kütüphaneleri kurun (pip install -r requirements.txt).

ChromeDriver indirerek sisteminizde doğru bir şekilde yapılandırın.

allure-pytest kütüphanesini yükleyin.

Testleri çalıştırın: pytest --alluredir=./reports

Raporu görüntüleyin: allure serve ./reports

Spotify Manuel Testleri
Bu bölüm, Spotify web uygulamasının manuel testlerini içerir. Testler, kullanıcı kayıt, giriş, arama, oynatma, çalma listesi yönetimi ve diğer işlevleri kapsayan çeşitli senaryolar aracılığıyla gerçekleştirilmiştir.

Test Türleri:

Fonksiyonel Testler

Kullanılabilirlik Testleri

Karşılaştırma Testleri

Sınır Değer Analizi

Eşdeğer Bölümleme

Test Raporları:

[Dosya Adı] dosyası, test sonuçlarını ve bulguları detaylandırır.

Katkıda Bulunma:

Projeye katkıda bulunmak için, Github repo'suna bir "pull request" gönderin.

Lisans
Bu repo, [Lisans Adı] lisansı altında lisanslanmıştır.
