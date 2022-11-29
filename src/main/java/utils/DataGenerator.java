package utils;

import com.github.javafaker.Faker;
import entities.FieldRepository;
import entities.RegistrationInfo;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

// Утилитный класс - содержит приватный конструктор и статичные методы
// Для удобства - вызвали один метод,к-ый сенерировал сразу 3 поля (фио, тел, город)
@UtilityClass
public class DataGenerator {

    FieldRepository field = new FieldRepository();
    // класс generateInfo возвращает RegistrationInfo (Data класс с 3-мя полями)
    // генерируем новый RegistrationInfo с 3-мя полями с помощью faker
    //     @UtilityClass позволяет вызывать generateInfo в Тестах без подробного описания.
    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locate) {
            Faker faker = new Faker(new Locale(locate));
            String phoneForm = faker.phoneNumber().phoneNumber();
            phoneForm = phoneForm.replaceAll("[()-]","");
            return new RegistrationInfo(faker.name().fullName(), phoneForm, field.randomCity());
        }
    }

}
