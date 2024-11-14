public class ValidDate {
    private int day;
    private int month;
    private int year;

    //конструктор без параметров
    public ValidDate(){
        this.day = 1;
        this.month = 1;
        this.year = 1111;
    }

    //конструктор с параметрами, который может выбросить исключение
    public ValidDate(int day, int month, int year) throws InvalidDateException{
        this.day = day;
        this.month = month;
        this.year = year;
        //при инициализации сразу проверяем на корректность
        if(!isValid()){
            throw new InvalidDateException("Некорретная дата.Попробуйте еще раз.");
        }
    }

    //проверка является ли год високосным
    private boolean LeapYear(int year){
        return (year%4 ==0 && year%100!=0) || (year%400==0);
    }

    //определение максимальной даты дня, который может ввести пользователь, опираясь на месяц его рождения
    private int MaxDaysInMonth(int month, int year){
        switch(month){
            case 1: //январь
            case 3: //март
            case 5: //май
            case 7: //июль
            case 8: //август
            case 10: //октябрь
            case 12: return 31; // и декабрь вмещают максимум 31 день

            case 4: //март
            case 6: //июнь
            case 9: //сентябрь
            case 11: return 30; // и ноябрь максимум 30
            //если февраль, то кол-во дней варьируется в зависимости от "високосности" года
            case 2:
                return (LeapYear(year)) ? 29 : 28;
            default:
                return -1; //это не достигается, но иначе ругается
        }
    }

    //метод запуска проверки даты на корректность
    private boolean isValid(){
        //месяц только от 1 до 12
        if (this.month < 1 || this.month >12){
            return false;
        }
        int max_days = MaxDaysInMonth(this.month, this.year);
        //день от 1 до максимального высчитанного значения
        return this.day>=1 && this.day <= max_days;
    }
}
