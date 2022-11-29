import com.github.javafaker.Faker;
import entities.RegistrationInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

import java.util.Locale;

public class TestWithFaker {
    // генератор тестовых данных
    private static Faker faker;

    // Faker для РФ
    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    // генерация фио, телефона, города
//    @Test
//    void shoulGenerateTestData() {
//        String name = faker.name().fullName();
//        String phone = faker.phoneNumber().phoneNumber();
//        String city = faker.address().city();
//        printTestData(name, phone, city);
//    }

    @Test
    void shouldGenerateTestDataUsingUtils() {
//        entities.RegistrationInfo - информация для регистрации
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        printTestData(info);
    }

    // вывод в консоль сгенерированных данных
    private void printTestData(String name, String phone, String city) {
        System.out.println(StringUtils.repeat("=", 30));
        System.out.println(name + "\n" + phone + "\n" + city  + "\n");
        System.out.println(StringUtils.repeat("=", 30));
    }

    // вывод в консоль сгенерированных данных
    private void printTestData(entities.RegistrationInfo registrationInfo) {
        printTestData(registrationInfo.getName(), registrationInfo.getPhone(), registrationInfo.getCity());
    }
}
