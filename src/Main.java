import java.util.Scanner; //для обработки ввода

//основной класс
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //шаблон для проверки правильного ввода
        String pattern = "^[А-Яа-я]+\\s[А-Яа-я]+\\s[А-Яа-я]+\\s\\d{2}\\.\\d{2}\\.\\d{4}$";
        String str;

        //цикл до тех пор, пока пользователь не введет верные данные
        while(true) {
            System.out.println("Введите ФИО и дату рождения в формате: " +
                    "Языкова Мария Денисовна 27.09.2005");
            str = input.nextLine();
            try {
                //если данные не соответствуют шаблону - кидаем исключение
                if (!str.matches(pattern)) {
                    throw new InvalidInputException("Неверный формат. Введите информацию в верном формате.");
                }
                //делю дату на день, месяц и год
                String[] name_age = str.split(" ");
                String birth = name_age[3];
                String[] date_dmy = birth.split("\\.");
                int day = Integer.parseInt(date_dmy[0]);
                int month = Integer.parseInt(date_dmy[1]);
                int year = Integer.parseInt(date_dmy[2]);
                //создание нового объекта класса, который проверяет корректность введённой даты
                //и если дата некорректна, то кидает исключение
                ValidDate valid_date = new ValidDate(day, month, year);

                //делю ФИО на имя, фамилию и отчество
                String surname = name_age[0];
                String name = name_age[1];
                String patronymic = name_age[2];

                //запуск классов, которые выполняют основные требования задачи,
                //если все данные введены нормально
                Initials initials = new Initials(surname, name, patronymic);
                Gender gender = new Gender(patronymic);
                Age age = new Age(birth);

                System.out.println(initials);
                System.out.println(gender);
                System.out.println(age);

                break;
            }catch(InvalidInputException | InvalidDateException e){ //отлавливаю исключения
                System.out.println(e.getMessage());
            }
        }
    }
}