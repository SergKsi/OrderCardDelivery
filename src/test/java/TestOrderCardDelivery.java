import entities.FieldRepository;
import entities.RegistrationInfo;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class TestOrderCardDelivery {

    @Test
    void orderCardTestMessageSuccess() {
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        FieldRepository field = new FieldRepository();
        String planningDate = field.generateDate(3);
        open("http://localhost:9999");
        $("[data-test-id=\"city\"] input").setValue(info.getCity());
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(planningDate);
        $("[data-test-id=\"name\"] input").setValue(info.getName());
        $("[data-test-id=\"phone\"] input").setValue(info.getPhone());
        $("[data-test-id=\"agreement\"] span").click();
        $$(".button").find(exactText("Забронировать")).click();
        $(withText("Успешно!"))
                .shouldBe(exist, Duration.ofMillis(13000));
    }

    @Test
    void orderCardTestMessageMeeting() {
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        FieldRepository field = new FieldRepository();
        open("http://localhost:9999");
        String planningDate = field.generateDate(3);
        $("[data-test-id=\"city\"] input").setValue(info.getCity());
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(planningDate);
        $("[data-test-id=\"name\"] input").setValue(info.getName());
        $("[data-test-id=\"phone\"] input").setValue(info.getPhone());
        $("[data-test-id=\"agreement\"] span").click();
        $$("button").find(exactText("Забронировать")).click();
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofMillis(13000))
                .shouldBe(exist);
    }

}
