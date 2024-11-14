import java.time.LocalDate; //для определения текущей даты
import java.time.format.DateTimeFormatter; //для форматирования даты

public class Age {
    private String birth;

    //конструктор без параметров
    public Age(){
        this.birth = "01.01.1111";
    }
    //конструктор с параметром
    public Age(String birth){
        this.birth = birth;
    }

    //определение верного окончания для подсчитанного возраста
    private String End(int age){
        if ((age % 100 >= 11) && (age %100 <=14)){
            return "лет";
        }
        switch (age%10){
            case 1: return "год";
            case 2:
            case 3:
            case 4: return "года";
            default: return "лет";
        }
    }

    //подсчет возраста
    public String YearsCounter(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String current_date = date.format(pattern);

        String[] current_dmy = current_date.split("\\.");
        String[] birth_dmy = this.birth.split("\\.");

        //делю текущую дату на день, месяц и год
        int current_day = Integer.parseInt(current_dmy[0]);
        int current_month = Integer.parseInt(current_dmy[1]);
        int current_year = Integer.parseInt(current_dmy[2]);

        //делю дату рождения пользователя на день, месяц и год
        int birth_day = Integer.parseInt(birth_dmy[0]);
        int birth_month = Integer.parseInt(birth_dmy[1]);
        int birth_year = Integer.parseInt(birth_dmy[2]);

        int age = current_year - birth_year;
        //если день и месяц рождения пользователя наступает позже текущей даты, то значит ему неполных age лет
        if (current_month < birth_month || (current_month == birth_month && current_day < birth_day)){
            age--;
        }

        String end = End(age);
        return age + " " + end;
    }

    //создание строки нужного формата
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Возраст: ").append(YearsCounter());
        return str.toString();
    }
}
