from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def check_weather(city):
    driver = webdriver.Chrome()
    driver.get("https://www.accuweather.com/")

    try:
        wait = WebDriverWait(driver, 10)

        # Çerez uyarısını kapat
        try:
            cookie_button = wait.until(
                EC.element_to_be_clickable((By.ID, "privacy-policy-banner")))
            cookie_button.click()
        except Exception as e:
            print(f"Çerez uyarısı hatası: {e}")

        # Arama kutusunu bul ve şehri yaz
        search_box = wait.until(EC.presence_of_element_located((By.NAME, "query")))
        search_box.send_keys(city)
        search_box.send_keys(Keys.RETURN)

        # Açılır menünün görünmesini bekle
        try:
            wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, ".search-results")))
        except:
            pass  # Eğer menü zaten açıksa hata verme

        # Arama sonuçları varsa ilk sonuca tıkla (JavaScript kullanarak)
        try:
            first_result = wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, ".page-column-1 .locations-list a:first-child")))
            driver.execute_script("arguments[0].click();", first_result)
        except Exception as e:
            print(f"{city} için arama sonuçlarına tıklama hatası: {e}")

        # Sıcaklık bilgisini çek
        temperature_element = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, ".temp-container .temp")))
        temperature = temperature_element.text.split("°")[0]

        # Detaylı bilgileri çek
        details_container = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, ".cur-con-weather-card__panel.details-container")))
        details = details_container.find_elements(By.CSS_SELECTOR, ".detail")

        realfeel_shade = details[0].find_element(By.CLASS_NAME, "value").text
        wind = details[1].find_element(By.CLASS_NAME, "value").text
        wind_gusts = details[2].find_element(By.CLASS_NAME, "value").text
        air_quality = details[3].find_element(By.CLASS_NAME, "value").text

        # Sonuçları yazdır
        print(f"{city} Hava Durumu:")
        print(f"Sıcaklık: {temperature}°C")
        print(f"Hissedilen Sıcaklık (Gölge): {realfeel_shade}")
        print(f"Rüzgar: {wind}")
        print(f"Rüzgar Hamleleri: {wind_gusts}")
        print(f"Hava Kalitesi: {air_quality}")

    except Exception as e:
        print(f"{city} için genel hata: {e}")

    finally:
        driver.quit()

# Test etmek istediğiniz şehirler
cities = ["Paris", "İstanbul", "Londra"]

# Her şehir için hava durumunu kontrol edin
for city in cities:
    check_weather(city)