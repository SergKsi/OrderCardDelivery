import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class OrderCardDelivery {

    @Test
    void orderCardTestFullData() {
        FieldRepository fieldsRepository = new FieldRepository();
        open("http://localhost:9999");
        $("[data-test-id=\"city\"] input").setValue(fieldsRepository.RandomCity());
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(fieldsRepository.RandomDate());
        $("[data-test-id=\"name\"] input").setValue(fieldsRepository.RandomSurname());
        $("[data-test-id=\"phone\"] input").setValue(fieldsRepository.RandomTelefon());
        $("[data-test-id=\"agreement\"] span").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldHave(exist, Duration.ofSeconds(3));
    }
}
