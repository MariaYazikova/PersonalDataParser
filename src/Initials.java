public class Initials {
    private String surname;
    private String name;
    private String patronymic;

    //конструктор без параметров
    public Initials() {
        this.surname = "Петров";
        this.name = "Пётр";
        this.patronymic = "Петрович";
    }
    //конструктор с параметрами
    public Initials(String surname, String name, String patronymic){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getSurname(){
        return this.surname;
    }
    public String getName(){
        return this.name;
    }
    public String getPatronymic(){
        return this.patronymic;
    }

    //создание строки нужного формата
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Инициалы: ").append(getSurname()).append(" ");
        str.append(getName().charAt(0)).append(".");
        str.append(getPatronymic().charAt(0)).append(".");
        return str.toString();
    }
}
