import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FieldRepository {
    int date1Year = 365;  // кол-во дней от текущей даты + 3 дня для подачи заявки (для Randoma)

    //    Город — один из административных центров субъектов РФ.
    public String RandomCity() {
        String[] AdminCityRF = {"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан", "Благовещенск", "Брянск", "ВеликийНовгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Красногорск", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Нальчик", "Нарьян-Мар", "НижнийНовгород", "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль", "Гатчина", "Горно-Алтайск", "Мурманск", "Черкесск"};
        Random generator = new Random();
        int randomIndex = generator.nextInt(AdminCityRF.length);
        return AdminCityRF[randomIndex];
    }

    //  Дата — не ранее трёх дней с текущей даты.
    //  datePlus3days - текущая дата + 3 дня
    //  datePlus1Year - datePlus3days + 1 год - для выбора случай даты
    public String RandomDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate datePlus3days = LocalDate.now(zoneId).plusDays(3);
        Random generator = new Random();
        int randomDate = generator.nextInt(date1Year);
        LocalDate dateRandom1Year = datePlus3days.plusDays(randomDate);
        int year = dateRandom1Year.getYear();
        int month = dateRandom1Year.getMonthValue();
        int day = dateRandom1Year.getDayOfMonth();
        dateRandom1Year.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        String dayStr = "";
        String monthStr = "";
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        String dateStr = dayStr + "." + monthStr + "." + year;
        return dateStr;
    }

//    В поле телефона — только 11 цифр, символ + на первом месте.
    public String RandomTelefon() {
        Random generator = new Random();
        int countDigit = 7;
        int random7digit;
        String telefonStr = "+7910";
        for (int i = 0; i < countDigit; i++) {
            random7digit = generator.nextInt(9);
            telefonStr += random7digit;
        }
        return telefonStr;
    }

    //    В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
    public String RandomSurname() {
        String[] AllowedCharacters = {"А",	"Б",	"В",	"Г",	"Д",	"Е",	"Ж",	"З",	"И",	"Й",	"К",	"Л",	"М",	"Н",	"О",	"П",	"Р",	"С",	"Т",	"У",	"Ф",	"Х",	"Ц",	"Ч",	"Ш",	"Щ",	"Ъ",	"Ы",	"Ь",	"Э",	"Ю",	"Я",	"а",	"б",	"в",	"г",	"д",	"е",	"ж",	"з",	"и",	"й",	"к",	"л",	"м",	"н",	"о",	"п",	"р",	"с",	"т",	"у",	"ф",	"х",	"ц",	"ч",	"ш",	"щ",	"ъ",	"ы",	"ь",	"э",	"ю",	"я",	" ",	"-"
        };
        int countAllowedCharacters = 68; // кол-во разрешенных символов 33 большие + 33 малые + 2 спецсимола 
        int countSurname = 20; // макс кол-во букв в Фамилии
        int countName = 12; // макс кол-во букв в Имени
        String Surname = "";
        String Name = "";
        Random generator = new Random();
        int randomCountSurname = generator.nextInt(countSurname);  // Рандомное кол-во букв в Фамилии
        int randomCountName = generator.nextInt(countName); // Рандомное кол-во букв в Имени
        for (int i = 0; i < randomCountSurname - 1; i++) {
            Surname += AllowedCharacters[generator.nextInt(countAllowedCharacters) - 1];
        }
        for (int i = 0; i < randomCountName - 1; i++) {
            Name += AllowedCharacters[generator.nextInt(countAllowedCharacters) - 1];
        }
        return Surname + " " + Name;
    }
}
