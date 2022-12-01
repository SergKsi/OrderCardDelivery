package entities;

import lombok.Data;
// Data - класс - содержит поля и простейшие методы для доступа к полям
// Это просто контейнеры для данных, используемых другими классами
// entities.RegistrationInfo - информация для регистрации

@Data
public class RegistrationInfo {
    private final String name;
    private final String phone;
    private final String city;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

}
