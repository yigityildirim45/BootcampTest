import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetStoreApiPet {

    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    // 1. Yeni Bir Pet Ekleme ve Doğrulama
    @Test
    public void addNewPet() {
        String petPayload = "{\n" +
                "  \"id\": 1001,\n" +
                "  \"category\": {\"id\": 1, \"name\": \"Dog\"},\n" +
                "  \"name\": \"Fluffy\",\n" +
                "  \"photoUrls\": [\"https://cdn.outsideonline.com/wp-content/uploads/2023/03/Funny_Dog_S.jpg\"],\n" +
                "  \"tags\": [{\"id\": 1, \"name\": \"friendly\"}],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given()
                .body(petPayload)
                .contentType(ContentType.JSON)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)  // Başarılı olmalı
                .body("id", equalTo(1001))  // ID'nin 1001 olduğunu kontrol eder
                .body("name", equalTo("Fluffy"))  // İsim "Fluffy" olmalı
                .body("status", equalTo("available"))  // Durum "available" olmalı
                .log().all();
    }

    // 2. Mevcut Pet'i Güncelleme ve Doğrulama
    @Test
    public void updatePet() {
        String updatedPetPayload = "{\n" +
                "  \"id\": 1001,\n" +
                "  \"category\": {\"id\": 1, \"name\": \"Dog\"},\n" +
                "  \"name\": \"Fluffy Updated\",\n" +
                "  \"photoUrls\": [\"https://cdn.outsideonline.com/wp-content/uploads/2023/03/Funny_Dog_S.jpg\"],\n" +
                "  \"tags\": [{\"id\": 1, \"name\": \"friendly\"}],\n" +
                "  \"status\": \"pending\"\n" +
                "}";

        given()
                .body(updatedPetPayload)
                .contentType(ContentType.JSON)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)  // Güncelleme başarılı olmalı
                .body("name", equalTo("Fluffy Updated"))  // Güncellenen ismi kontrol et
                .body("status", equalTo("pending"))  // Güncellenen durumu kontrol et
                .log().all();
    }

    // 3. Belirli Bir Duruma Göre Pet'leri Bulma ve Doğrulama
    @Test
    public void findPetsByStatus() {
        given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200)  // İstek başarılı olmalı
                .body("status", everyItem(equalTo("available")))  // Tüm pet'lerin durumu "available" olmalı
                .log().all();
    }

    // 4. Pet ID'ye Göre Pet Bulma ve Doğrulama
    @Test
    public void findPetById() {
        given()
                .pathParam("petId", 1001)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)  // Pet bulundu
                .body("id", equalTo(1001))  // ID 1001 olmalı
                .body("name", equalTo("Fluffy Updated"))  // İsim doğru olmalı
                .log().all();
    }

    // 5. Form Verisi ile Pet Güncelleme ve Doğrulama
    @Test
    public void updatePetWithFormData() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("name", "Fluffy Form Updated")
                .formParam("status", "sold")
                .pathParam("petId", 1001)
                .when()
                .post("/pet/{petId}")
                .then()
                .statusCode(200)  // Başarı durumu kontrolü
                .body("message", equalTo("1001"))  // Güncellenen pet'in ID'sini doğrular
                .log().all();
    }

    // 6. Pet Silme ve Doğrulama
    @Test
    public void deletePet() {
        given()
                .pathParam("petId", 1001)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200)  // Başarıyla silindi
                .log().all();
    }

    // Main method to run tests individually (optional)
    public static void main(String[] args) {
        PetStoreApiPet test = new PetStoreApiPet();
        test.addNewPet();
        test.updatePet();
        test.findPetsByStatus();
        test.findPetById();
        test.updatePetWithFormData();
        test.deletePet();
    }
}
