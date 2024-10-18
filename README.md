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

Reports dosyası ve Paneli, test sonuçlarını ve bulguları detaylandırır.

PetStore API Testleri

Bu bölüm, PetStoreAPI için yapılan otomatikleştirilmiş API testlerini içerir. Bu testler, çevrimiçi mağazada evcil hayvan verilerini yönetmek için kullanılan API'nin doğruluğunu ve güvenilirliğini sağlamak amacıyla çeşitli CRUD (Create, Read, Update, Delete) işlemlerini doğrular. Testler, evcil hayvan ekleme, güncelleme, alma ve silme işlemlerini kapsamaktadır.

Test Senaryoları:

Mağazaya yeni bir evcil hayvan ekleme: Sisteme yeni bir evcil hayvan ekler.
Mevcut bir evcil hayvanı güncelleme: Evcil hayvanın adı, durumu ve kategorisi gibi bilgileri günceller.
Duruma göre evcil hayvanları getirme: Duruma göre (mevcut, beklemede veya satıldı) evcil hayvanları listeler.
Etiketlere göre evcil hayvanları getirme: Belirli etiketler kullanarak evcil hayvanları bulur.
ID'ye göre evcil hayvan bulma: Evcil hayvanı ID'sine göre detaylı olarak getirir.
Form verileri ile evcil hayvan güncelleme: Evcil hayvanın adını veya durumunu form verisi ile günceller.
Bir evcil hayvanı silme: Evcil hayvanı ID'sine göre mağazadan siler.

Kullanılan Teknolojiler:

Rest-Assured ile REST API testleri.
JUnit 5 ile birim testleri.
Maven ile proje bağımlılık yönetimi.

Katkıda Bulunma:

Projeye katkıda bulunmak için, Github repo'suna bir "pull request" gönderin.
